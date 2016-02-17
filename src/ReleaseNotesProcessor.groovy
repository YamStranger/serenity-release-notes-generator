import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * User: YamStranger
 * Date: 2/17/16
 * Time: 4:40 PM
 *
 * This class should process release notes
 */
public class ReleaseNotesProcessor {
    static void main(String... args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Should be three input file paths and one output");
        }

        def Path pulls = Paths.get(args[0]) //report generated based on Pull Requests
        def Path commits = Paths.get(args[1]) //report generated based on commits
        def Path commitsEx = Paths.get(args[2]) //report generated based on commits with description
        def Path result = Paths.get(args[3]) //report generated based on commits with description

        if (!Files.exists(pulls)) {
            throw new IllegalArgumentException("${pulls.toAbsolutePath().toString()} does not exist");
        } else {
            pulls = pulls.toAbsolutePath()
        }
        if (!Files.exists(commits)) {
            throw new IllegalArgumentException("${commits.toAbsolutePath().toString()} does not exist");
        } else {
            commits = commits.toAbsolutePath()
        }
        if (!Files.exists(commitsEx)) {
            throw new IllegalArgumentException("${commitsEx.toAbsolutePath().toString()} does not exist");
        } else {
            commitsEx = commitsEx.toAbsolutePath()
        }
        if (!Files.exists(result)) {
            Files.createDirectories(result.toAbsolutePath().parent)
            Files.createFile(result)
            println("Created result file ${result.toAbsolutePath().toString()}")
        } else {
            Files.delete(result)
            Files.createFile(result)
        }

        def Map<String, Commit> extensions = new HashMap<String, Commit>()
        def Map<String, Release> releases = new HashMap<String, Release>()

        def List lines = commitsEx.readLines("UTF-8")
        def Iterator<String> iterator = lines.iterator();

        while (iterator.hasNext()) {
            def line = iterator.next()
            if (isCommitHeader(line)) {
                def id = commitId(line)
                extensions.put(id, readCommitDescription(id, iterator))
            }
        }

        println("readed extended commits: ${extensions.size()}")

        def results = new LinkedList<String>()
        lines = pulls.readLines("UTF-8")
        iterator = lines.iterator();
        while (iterator.hasNext()) {
            def line = iterator.next()
            if (isReleaseHeader(line)) {
                releases.put(line, readRelease(line, iterator))
            }
        }

        lines = commits.readLines("UTF-8")
        iterator = lines.iterator();
        while (iterator.hasNext()) {
            def line = iterator.next()
            if (isReleaseHeader(line)) {
                def Release release = readRelease(line, iterator)
                results.add("${release.name}")
                results.add(" ")
                def Release pullRelease = releases.get(release.name)
                if (pullRelease) {
                    results.add("**Pull requests:**")
                    results.add(" ")

                    pullRelease.lines.each { pull -> results.add("$pull") }
                } else {
                    println("can not find pulls release with name ${release.name}")
                }

                if (release.lines.size()) {
                    results.add(" ")
                    results.add("**Commits:**")
                    results.add(" ")
                    release.lines.each { commit ->
                        results.add(commit)
                        def id = commitId(commit)
                        if (extensions.containsKey(id)) {
                            results.add(" ")
                            extensions.get(id).description.each { descrLine ->
                                results.add(descrLine)
                            }
                        } else {
                            println("can not fine extension for ${id}")
                        }
                    }
                }
                results.add(" ")
            } else {
                results.add(line)
            }
        }


        result.withPrintWriter { writer ->
            results.each { line ->
                writer.write("$line\n")
            }
        }
        println "done"
    }

    def static boolean isCommitHeader(def line) {
        line.matches("^.+\\([^\\(]+(github){1,1}[^\\s]+(commit){1,1}/\\d+.+\$")
    }

    def static String commitId(def String line) {
        def Pattern pattern = Pattern.compile(".+\\([^\\(]+(github){1}[^\\s]+(commit){1}/(?<issue>[a-f0-9]+)\\).+")
        def Matcher matcher = pattern.matcher(line)
        if (matcher.find()) {
            def id = matcher.group("issue").substring(0, 7)
            println("read issue id=$id")
            return id
        } else {
            // println("can not fine commit id for $line")
            return ""
        }
    }

    def static boolean isReleaseHeader(def String line) {
        line.matches("^(###).+\\(.+\\)\$")
    }

    def static Commit readCommitDescription(def id, def Iterator<String> iterator) {
        def commit = new Commit(ref: id);
        commit.description = new LinkedList()
        def first = true
        while (iterator.hasNext()) {
            def line = iterator.next()
            if (!line.isEmpty()) {
                println("line readed as issue description $line for issue id=$id")
                commit.description.add(line)
            } else {
                if (first) {
                    first = false
                } else {
                    return commit
                }
            }
        }
        return commit
    }

    def static Release readRelease(def String name, def Iterator<String> iterator) {
        def release = new Release(name);
        while (iterator.hasNext()) {
            def line = iterator.next()
            if (!line.isEmpty()) {
                release.lines.add(line)
                println("line readed as release description $line for release $name")
            } else {
                return release
            }
        }
        return release
    }


}

class Release {
    def String name
    def List<String> lines

    Release(String name) {
        this.name = name
        lines = new LinkedList();
    }
}

class Commit {
    def String ref
    def List<String> description

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Commit commit = (Commit) o

        if (description != commit.description) return false
        if (ref != commit.ref) return false

        return true
    }

    int hashCode() {
        int result
        result = (ref != null ? ref.hashCode() : 0)
        result = 31 * result + (description != null ? description.hashCode() : 0)
        return result
    }
}