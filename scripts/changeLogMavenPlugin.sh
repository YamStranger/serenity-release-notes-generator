#!/usr/bin/env bash
export RELEASE_DATE=`date -u +%Y/%m/%d_%H_%M`
export LAST_RELEASE=2010/02/15:11:18:+0000
export SCRIPT=$(pwd)/../src/ReleaseNotesProcessor
export HARD_FILTERING_RELEASE=2016/02/15:23:18:+0000
export TYPES=feat,fix,docs,style,refactor,perf,test,chore

#last release 2010/02/15:11:18:+0000
#current
rm -rf tmp
mkdir -p tmp
cd tmp/
echo 'Serenity BDD Maven Plugin release notes generation'
git clone git@github.com:serenity-bdd/serenity-maven-plugin.git
cd serenity-maven-plugin/
git remote rename origin upstream
git remote add origin git@github.com:YamStranger/serenity-maven-plugin.git
git checkout master
git fetch upstream
git merge master upstream/master
git push origin -u master
git checkout -b release_notes_$RELEASE_DATE
github-changes --owner serenity-bdd -r serenity-maven-plugin -d pulls --token ${GITHUB_TOKEN} --file pulls.md --title 'Serenity BDD Maven Plugin change Log' --no-merges --verbose
github-changes --owner serenity-bdd -r serenity-maven-plugin -d commits --token ${GITHUB_TOKEN} --file commits.md --title 'Serenity BDD Maven Plugin change Log' --no-merges --verbose
echo '
## Serenity BDD Maven Plugin change Log
{{#tags}}

### {{name}}
**Commits with examples:**

{{#commits}}
{{#messageBody}}
* [commit:](https://github.com/serenity-bdd/serenity-maven-plugin/commit/{{hash}}) {{messageTitle}}

{{#messageBodyItems}}
 > {{.}}
{{/messageBodyItems}}
{{/messageBody}}

{{/commits}}
{{/tags}}' > multiline_commit_messages.mustache
git-changelog-command-line -of commmits_ex.md  --template multiline_commit_messages.mustache

echo '{{#tags}}
{{#commits}}
{{commitTime}}-{{hash}}
{{/commits}}
{{/tags}}' > commit_time.mustache
git-changelog-command-line -of commit_times.md  --template commit_time.mustache


groovy $SCRIPT.groovy $(pwd)/pulls.md $(pwd)/commits.md $(pwd)/commmits_ex.md $(pwd)/commit_times.md CHANGELOG.md $LAST_RELEASE $HARD_FILTERING_RELEASE $TYPES

git add CHANGELOG.md
git commit -m "updating changelog"
git push origin -u release_notes_$RELEASE_DATE
git checkout master
cd ../..
#rm -rf tmp






