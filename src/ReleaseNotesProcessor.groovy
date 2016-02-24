import javafx.collections.transformation.SortedList

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
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
        if (args.length < 5) {
            throw new IllegalArgumentException("Should be three input file paths and one output");
        }

        def Path pulls = Paths.get(args[0]) //report generated based on Pull Requests
        def Path commits = Paths.get(args[1]) //report generated based on commits
        def Path commitsEx = Paths.get(args[2]) //report generated based on commits with description
        def Path commitsTime = Paths.get(args[3]) //report generated based on commits with description
        def Path result = Paths.get(args[4]) //report generated based on commits with description

        def String date = args.size() >= 6 ? args[5] : null //date before what skip all report entity
        def Date filter = new SimpleDateFormat("yyyy/MM/dd:HH:mm:Z").parse("2016/02/15:11:18:+0000");

        if (date) {
            def DateFormat format = new SimpleDateFormat("yyyy/MM/dd:HH:mm:Z")
            try {
                filter = format.parse(date);
                println("parsed filter - will be included only data after ${format.format(filter)}")
            } catch (e) {
                println("can not parse date string \"$date\" according format \"yyyy/MM/dd:HH:mm:Z\" try \"2000/01/01:10:10:+0000\"")
            }
        }

        if (!Files.exists(commitsTime)) {
            throw new IllegalArgumentException("${commitsTime.toAbsolutePath().toString()} does not exist");
        } else {
            commitsTime = commitsTime.toAbsolutePath()
        }
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
        def Map<String, Date> commitTimes = new HashMap<String, Date>()

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

        lines = commitsTime.readLines("UTF-8")
        iterator = lines.iterator();
        while (iterator.hasNext()) {
            def line = iterator.next()
            def Pattern pattern = Pattern.compile(".*(?<date>\\d+-\\d+-\\d+\\s+\\d+:\\d+:\\d+){1}-(?<hash>[a-f0-9]+){1}.*")
            def DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            if (!line.isEmpty()) {
                def Matcher matcher = pattern.matcher(line)
                if (matcher.find()) {
                    def hash = matcher.group("hash").substring(0, 7)
                    def commitDate = matcher.group("date")
                    def Date readedDate
                    try {
                        readedDate = format.parse(commitDate);
                        println("parsed date from $line it equal to ${format.format(readedDate)}")
                        commitTimes.put(hash, readedDate)
                    } catch (e) {
                        println("can not parce date from string $commitDate")
                    }
                }
            }
        }

        println("readed commit times: ${commitTimes.size()}")


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
                def SimpleDateFormat fo = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                if (release.date.after(filter)) {
                    println("accepted release ${release.name} becase ${fo.format(filter)}.before(${fo.format(release.date)})")
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

                        release.lines.sort(new Comparator<String>() {
                            @Override
                            int compare(String o1, String o2) {
                                def String left = commitId(o1)
                                def String right = commitId(o2)
                                def Date leftDate = commitTimes.get(left)
                                def Date rightDate = commitTimes.get(right)
                                if (leftDate != null && rightDate != null) {
                                    return leftDate.compareTo(rightDate)
                                }else{
                                    return left.compareTo(right)
                                }
                            }
                        })

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
                    println("skip release ${release.name} becase ${fo.format(filter)}.before(${fo.format(release.date)})")
                }
            } else {
                println("Indicated that it is not release line: ${line}")
                results.add(line)
            }
        }


        result.withPrintWriter { writer ->
            results.each { line ->
                if (include(line)) {
                    writer.write("${updateDevName(line)}\n")
                }
            }
        }
        println "done"
    }

    def static Boolean include(def String line) {
        def Collection<String> exclude = [
            ".*([a-f0-9]+\\))\\s+(Revert\\s+.*)",
            ".*([a-f0-9]+\\))\\s+Merge\\s+branch\\s+.*",
            ".*(pdating\\s+changelog).*"

        ].asList()
        def boolean match = false;
        exclude.each { parameter ->
            if (!match && line.matches(parameter)) {
                match = true
            } else {
                println("$line not match $parameter")
            }
        }
        return !match
    }

    def static String updateDevName(def String line) {
        def Pattern pattern = Pattern.compile(".+(?<developer>\\@(?<login>[^()]+)).+")
        def Matcher matcher = pattern.matcher(line)
        if (matcher.find()) {
            def developer = matcher.group("developer")
            def login = matcher.group("login")
            return line.replaceAll(developer, "[$developer](https://github.com/$login)")
        } else {
            return line
        }
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
        line.matches("^(###)+.+\\(+.+\\)+\$")
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
        def Pattern pattern = Pattern.compile("\\((?<date>\\d+/\\d+/\\d+\\s+\\d+:\\d+)\\s+(?<timezone>.{1}\\d+:\\d+\\))")
        def Matcher matcher = pattern.matcher(name)
        if (matcher.find()) {
            def dateString = matcher.group("date")
            def DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date result = new Date();
            try {
                result = format.parse(dateString);
                println("parsed date from $dateString it equal to ${format.format(result)}")
            } catch (e) {
                println("can not parce date from string $dateString")
            }
            release.date = result
        }
        while (iterator.hasNext()) {
            def line = iterator.next()
            if (!line.isEmpty()) {
                release.lines.add(line)
                println("line readed as release description $line for release $name")
            } else {
                println("relase reading skipped line $line")
                return release
            }
        }
        return release
    }


}

class Release {
    def String name
    def List<String> lines
    def Date date

    Release(String name) {
        this.name = name
        lines = new LinkedList<String>()
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
