## Here is some scripts to generate serenity release notes

It uses different tools to create release notes: 
[git-changelog-lib](https://github.com/tomasbjerre/git-changelog-lib)
[github-changes](https://github.com/lalitkapoor/github-changes)

and custom groovy script. 

To install all you should (for Ubuntu 15.10): 

Install git:

```
sudo apt-get install git
```

Install Java: 

```
mkdir -p ~/dev/apps/
cd ~/dev/apps/

wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u72-b15/jdk-8u72-linux-x64.tar.gz"
tar xzf jdk-8u72-linux-x64.tar.gz
cd jdk1.8.0_72
echo 'export JAVA_HOME="'$(pwd)'"' >> ~/.bashrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.bashrc
```

Export your GitHub token: 

```
echo 'export GITHUB_TOKEN=some_value' >> ~/.bashrc
```
 
Install nodeJs: 

```
curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -
sudo su 
apt-get install -y nodejs
```

Install [github-changes](https://github.com/lalitkapoor/github-changes):

```
npm install -g github-changes
```

Install [git-changelog](https://github.com/tomasbjerre/git-changelog-lib):

```
cd ~/dev/apps/
wget https://repo1.maven.org/maven2/se/bjurr/gitchangelog/git-changelog-command-line/1.9/git-changelog-command-line-1.9.tar
tar -xvf git-changelog-command-line-1.9.tar
cd git-changelog-command-line-1.9/bin
echo 'export PATH="'$(pwd)':$PATH"' >> ~/.bashrc
```

Now you can generate tree different reports:
 1. Based on pull requests
   ``` github-changes --owner serenity-bdd -r serenity-core -d pulls --token ${GITHUB_TOKEN} --file github-changes.md --title '# Serenity BDD Core Change Log' --no-merges --verbose ```

 2. Based on Commits
   ``` github-changes --owner serenity-bdd -r serenity-core -d commits --token ${GITHUB_TOKEN} --file github-changes_commits.md --title '# Serenity BDD Core Change Log' --no-merges --verbose ```

 3. Based on Commits extended
 ```
 echo '
 ## Serenity BDD Release Notes
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
 
 git-changelog-command-line -of change_log_with_multiline_commits.md  --template multiline_commit_messages.mustache
 rm multiline_commit_messages.mustache
     ```

Based on Commits additional

 ```
    echo '
    ## Serenity BDD Release Notes
    {{#tags}}
    
    ### {{name}}
    **Commits:**
    
    {{#commits}}
    {{^messageBody}}
    * [commit:](https://github.com/serenity-bdd/serenity-core/commit/{{hash}}) {{messageTitle}} 
    {{/messageBody}}
    {{/commits}}
    
    {{/tags}}' > commits_styled.mustache
    
    git-changelog-command-line -of change_log_with_commits.md  --template commits_styled.mustache --ignore-pattern '^[^(feat)(fix)(docs)(style)(refactor)(perf)(test)(chore)]+.*'
    rm commits_styled.mustache
```


