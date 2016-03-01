#!/usr/bin/env bash
export RELEASE_DATE=`date -u +%Y/%m/%d_%H_%M`
export LAST_RELEASE=2010/02/15:11:18:+0000
export SCRIPT=$(pwd)/../src/ReleaseNotesProcessor

#last release 2010/02/15:11:18:+0000
#current
rm -rf tmp
mkdir -p tmp
cd tmp/
echo 'Serenity Core release notes generation'
git clone git@github.com:serenity-bdd/serenity-core.git
cd serenity-core/
git remote rename origin upstream
git remote add origin git@github.com:YamStranger/serenity-core.git
git checkout master
git fetch upstream
git merge master upstream/master
git push origin -u master
git checkout -b release_notes_$RELEASE_DATE
github-changes --owner serenity-bdd -r serenity-core -d pulls --token ${GITHUB_TOKEN} --file pulls.md --title 'Serenity BDD core change Log' --no-merges --verbose
github-changes --owner serenity-bdd -r serenity-core -d commits --token ${GITHUB_TOKEN} --file commits.md --title 'Serenity BDD core change Log' --no-merges --verbose
echo '
## Serenity BDD core change Log
{{#tags}}

### {{name}}
**Commits with examples:**

{{#commits}}
{{#messageBody}}
* [commit:](https://github.com/serenity-bdd/serenity-core/commit/{{hash}}) {{messageTitle}}

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


groovy $SCRIPT.groovy $(pwd)/pulls.md $(pwd)/commits.md $(pwd)/commmits_ex.md $(pwd)/commit_times.md CHANGELOG.md $LAST_RELEASE

git add CHANGELOG.md
git commit -m "updating changelog"
git push origin -u release_notes_$RELEASE_DATE
git checkout master
cd ../..
rm -rf tmp






