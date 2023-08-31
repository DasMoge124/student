---
layout: post
title: Linux Shell and Bash
description: A Tech Talk on Linux and the Bash shell.
toc: true
comments: true
categories: [5.A, C4.1]
courses: { csse: {week: 1}, csp: {week: 0, categories: [6.B]}, csa: {week: 1} }
type: hacks
---
## Bash Tutorial!
> A brief overview of Bash, on your way to becoming a Linux expert.  When a computer boots up, a kernel (MacOS, Windows, Linux) is started.  This kernel provides a shell that allows user to interact with a most basic set of commands.  Typically, the casual user will not interact with the shell as a Desktop User Interface is started by the computer boot up process.  To activate a shell directly, users will run a "terminal" through the Desktop. VS Code provides ability to activate "terminal" while in the IDE.

## Prerequisites
> Setup bash shell dependency variables for this page.

- Hack: Change variables to match your project.

```bash
%%script bash

# Dependency Variables, set to match your project directories

cat <<EOF > /tmp/variables.sh
export project_dir=$HOME/vscode  # change vscode to different name to test git clone
export project=\$project_dir/teacher  # change teacher to name of project from git clone
export project_repo="https://github.com/nighthawkcoders/teacher.git"  # change to project of choice
EOF
```
```bash
%%script bash

# Extract saved variables
source /tmp/variables.sh

# Access the variables
echo "Project dir: $project_dir"
echo "Project: $project"
echo "Repo: $project_repo"
```
Project dir: /Users/johnmortensen/vscode
Project: /Users/johnmortensen/vscode/teacher
Repo: https://github.com/nighthawkcoders/teacher.git

## Setup Project
> Pull code from GitHub to your machine. This script will create a project directory and add "project" from GitHub to the vscode directory.  There is conditional logic to make sure that clone only happen if it does not (!) exist.

```bash
%%script bash

# Extract saved variables
source /tmp/variables.sh

echo "Using conditional statement to create a project directory and project"

cd ~    # start in home directory

# Conditional block to make a project directory
if [ ! -d $project_dir ]
then 
    echo "Directory $project_dir does not exists... makinng directory $project_dir"
    mkdir -p $project_dir
fi
echo "Directory $project_dir exists." 

# Conditional block to git clone a project from project_repo
if [ ! -d $project ]
then
    echo "Directory $project does not exists... cloning $project_repo"
    cd $project_dir
    git clone $project_repo
    cd ~
fi
echo "Directory $project exists." 
```
Using conditional statement to create a project directory and project
Directory /Users/johnmortensen/vscode exists.
Directory /Users/johnmortensen/vscode/teacher exists.

### Look at files Github project
> All computers contain files and directories.  The clone brought more files from cloud to your machine.  Review the bash shell script observe the commands that show and interact with files and directories.

- "ls" lists computer files in Unix and Unix-like operating systems
- "cd" offers way to navigate and change working directory
- "pwd" print working directory
- "echo" used to display line of text/string that are passed as an argument

```bash
%%script bash

# Extract saved variables
source /tmp/variables.sh

echo "Navigate to project, then navigate to area wwhere files were cloned"
cd $project
pwd

echo ""
echo "list top level or root of files with project pulled from github"
ls

```
Navigate to project, then navigate to area wwhere files were cloned
/Users/johnmortensen/vscode/teacher

list top level or root of files with project pulled from github
Gemfile
Gemfile.lock
LICENSE
Makefile
README.md
_config.yml
_data
_includes
_layouts
_notebooks
_posts
_site
csa.md
csp.md
csse.md
images
index.md
indexBlogs.md
nohup.out
scripts

### Look at file list with hidden and long attributes
> Most linux commands have options to enhance behavior

[ls reference](https://www.rapidtables.com/code/linux/ls.html)
```bash
%%script bash

# Extract saved variables
source /tmp/variables.sh

echo "Navigate to project, then navigate to area wwhere files were cloned"
cd $project
pwd

echo ""
echo "list all files in long format"
ls -al   # all files -a (hidden) in -l long listing
```

- Basically just lists all of the hidden files in a certain directory

### Look inside a Markdown File
> "cat" reads data from the file and gives its content as output
```bash
%%script bash

# Extract saved variables
source /tmp/variables.sh

echo "Navigate to project, then navigate to area wwhere files were cloned"

cd $project
echo "show the contents of README.md"
echo ""

cat README.md  # show contents of file, in this case markdown
echo ""
echo "end of README.md"

```
Project dir: /Users/johnmortensen/vscode
Project: /Users/johnmortensen/vscode/teacher
Repo: https://github.com/nighthawkcoders/teacher.git
Using conditional statement to create a project directory and project
Directory /Users/johnmortensen/vscode exists.
Directory /Users/johnmortensen/vscode/teacher exists.
Navigate to project, then navigate to area wwhere files were cloned
/Users/johnmortensen/vscode/teacher

list top level or root of files with project pulled from github
Gemfile
Gemfile.lock
LICENSE
Makefile
README.md
_config.yml
_data
_includes
_layouts
_notebooks
_posts
_site
csa.md
csp.md
csse.md
images
index.md
indexBlogs.md
nohup.out
scripts
Navigate to project, then navigate to area wwhere files were cloned
/Users/johnmortensen/vscode/teacher

list all files in long format
total 120
drwxr-xr-x  25 johnmortensen  staff   800 Jun 11 09:06 .
drwxr-xr-x  61 johnmortensen  staff  1952 Jun 11 04:39 ..
drwxr-xr-x  16 johnmortensen  staff   512 Jun 11 09:09 .git
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 .github
-rw-r--r--   1 johnmortensen  staff    37 Jun 11 04:39 .gitignore
-rw-r--r--   1 johnmortensen  staff    73 Jun 11 04:39 Gemfile
-rw-r--r--   1 johnmortensen  staff  7309 Jun 11 04:39 Gemfile.lock
-rw-r--r--   1 johnmortensen  staff  1081 Jun 11 04:39 LICENSE
-rw-r--r--   1 johnmortensen  staff  1318 Jun 11 04:39 Makefile
-rw-r--r--   1 johnmortensen  staff  1373 Jun 11 04:39 README.md
-rw-r--r--   1 johnmortensen  staff   405 Jun 11 06:46 _config.yml
drwxr-xr-x   6 johnmortensen  staff   192 Jun 11 04:39 _data
drwxr-xr-x   9 johnmortensen  staff   288 Jun 11 04:39 _includes
drwxr-xr-x   6 johnmortensen  staff   192 Jun 11 04:39 _layouts
drwxr-xr-x  11 johnmortensen  staff   352 Jun 11 08:33 _notebooks
drwxr-xr-x  12 johnmortensen  staff   384 Jun 11 08:52 _posts
drwxr-xr-x  21 johnmortensen  staff   672 Jun 11 10:35 _site
-rw-r--r--   1 johnmortensen  staff    92 Jun 11 04:39 csa.md
-rw-r--r--   1 johnmortensen  staff    98 Jun 11 04:39 csp.md
-rw-r--r--   1 johnmortensen  staff   108 Jun 11 04:39 csse.md
...
-rw-r--r--   1 johnmortensen  staff  5122 Jun 11 04:39 index.md
-rw-r--r--   1 johnmortensen  staff    53 Jun 11 04:39 indexBlogs.md
-rw-------   1 johnmortensen  staff  2307 Jun 11 10:35 nohup.out
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 scripts
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...
Look for posts
/Users/johnmortensen/vscode/teacher/_posts
total 224
-rw-r--r--  1 johnmortensen  staff   8086 Jun 11 09:06 2023-05-30-linux_shell_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   3878 Jun 11 08:49 2023-05-30-pair_programming.md
-rw-r--r--  1 johnmortensen  staff   5552 Jun 11 09:06 2023-05-31-VSCode-GitHub-project_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   6271 Jun 11 09:06 2023-06-01-javascript-input_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   8702 Jun 11 09:06 2023-06-01-python_hello_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  24393 Jun 11 09:06 2023-06-02-javascript_output_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  11097 Jun 11 09:06 2023-06-03-javascript_api_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  15072 Jun 11 09:06 2023-06-04-AWS-deployment_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   5215 Jun 11 08:51 2023-06-04-javascript-animation-mario-oop.md
-rw-r--r--  1 johnmortensen  staff  12219 Jun 11 09:06 2023-06-08-JWT-python_IPYNB_2_.md
Look for notebooks
/Users/johnmortensen/vscode/teacher/_notebooks
total 344
-rw-r--r--  1 johnmortensen  staff  37377 Jun 11 10:35 2023-05-30-linux_shell.ipynb
-rw-r--r--  1 johnmortensen  staff   7706 Jun 11 09:04 2023-05-31-VSCode-GitHub-project.ipynb
-rw-r--r--  1 johnmortensen  staff   9292 Jun 11 08:47 2023-06-01-javascript-input.ipynb
-rw-r--r--  1 johnmortensen  staff  11477 Jun 11 04:39 2023-06-01-python_hello.ipynb
-rw-r--r--  1 johnmortensen  staff  44353 Jun 11 08:06 2023-06-02-javascript_output.ipynb
-rw-r--r--  1 johnmortensen  staff  15666 Jun 11 08:48 2023-06-03-javascript_api.ipynb
-rw-r--r--  1 johnmortensen  staff  20550 Jun 11 09:06 2023-06-04-AWS-deployment.ipynb
-rw-r--r--  1 johnmortensen  staff  16271 Jun 11 04:39 2023-06-08-JWT-python.ipynb
Look for images in notebooks, print working directory, list files
/Users/johnmortensen/vscode/teacher/_notebooks
bash: line 6: cd: /images: No such file or directory
total 344
-rw-r--r--  1 johnmortensen  staff  37377 Jun 11 10:35 2023-05-30-linux_shell.ipynb
-rw-r--r--  1 johnmortensen  staff   7706 Jun 11 09:04 2023-05-31-VSCode-GitHub-project.ipynb
-rw-r--r--  1 johnmortensen  staff   9292 Jun 11 08:47 2023-06-01-javascript-input.ipynb
-rw-r--r--  1 johnmortensen  staff  11477 Jun 11 04:39 2023-06-01-python_hello.ipynb
-rw-r--r--  1 johnmortensen  staff  44353 Jun 11 08:06 2023-06-02-javascript_output.ipynb
-rw-r--r--  1 johnmortensen  staff  15666 Jun 11 08:48 2023-06-03-javascript_api.ipynb
-rw-r--r--  1 johnmortensen  staff  20550 Jun 11 09:06 2023-06-04-AWS-deployment.ipynb
-rw-r--r--  1 johnmortensen  staff  16271 Jun 11 04:39 2023-06-08-JWT-python.ipynb
Navigate to project, then navigate to area wwhere files were cloned
show the contents of README.md

## Blog site using GitHub Pages and Jekyll
> This site is intended for Teachers.   This is to build lessons and distribute across different sections.
- This support 3 computer science sections that are in a pathway (JavaScript, Python/Flask, Java/Spring)
- JavaScript documents are new material for entry class into the pathway, they are prerequisites for the Python and Java classes.
- All course material works off of Notebooks using Python kernel, except Java which requires it own kernel.

## Preview Site 
> GitHub Pages development is optimized by testing and developing on your local machine.  This is called previewing you work, prior to commit and push. 
- GitHub setup for, [Testing your GitHub Pages site locally with Jekyll](https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll/testing-your-github-pages-site-locally-with-jekyll).  After requirements are met for Jekyll and Ruby you need to install requirements for project.
```bash
bundle install
```
- Now the project is ready for preview.  To simplify typing and sharing logging the details for running have be place in a ```Makefile```
    - run preview server
    ```bash
    make
    ```
    - stop preview server
    ```bash
    make stop
    ```
    - test notebook conversions
...
    make clean
    ```

end of README.md
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...
Show the shell environment variables, key on left of equal value on right

VSCODE_CLI=1
NIX_PROFILES=/nix/var/nix/profiles/default /Users/johnmortensen/.nix-profile
VSCODE_CRASH_REPORTER_PROCESS_TYPE=extensionHost
TERM_PROGRAM=Apple_Terminal
TERM=xterm-color
SHELL=/bin/bash
CLICOLOR=1
VSCODE_CRASH_REPORTER_SANDBOXED_HINT=1
TMPDIR=/var/folders/_n/7k1b0n557ng0fkmw74pd5cx00000gn/T/
CONDA_SHLVL=1
PYTHONUNBUFFERED=1
TERM_PROGRAM_VERSION=447
CONDA_PROMPT_MODIFIER=(base) 
ORIGINAL_XDG_CURRENT_DESKTOP=undefined
MallocNanoZone=0
PYDEVD_USE_FRAME_EVAL=NO
TERM_SESSION_ID=9056DE5B-8519-46AC-8C0A-42B5FFE425B9
PYTHONIOENCODING=utf-8
USER=johnmortensen
COMMAND_MODE=unix2003
CONDA_EXE=/Users/johnmortensen/opt/anaconda3/bin/conda
SSH_AUTH_SOCK=/private/tmp/com.apple.launchd.htDuJuikD5/Listeners
__CF_USER_TEXT_ENCODING=0x1F5:0x0:0x0
...
VSCODE_L10N_BUNDLE_LOCATION=
VSCODE_CWD=/Users/johnmortensen/vscode/teacher
SECURITYSESSIONID=186a6
_=/usr/bin/env
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...

show the secrets of .git
total 72
-rw-r--r--   1 johnmortensen  staff     9 Jun 11 09:09 COMMIT_EDITMSG
-rw-r--r--   1 johnmortensen  staff   102 Jun 11 09:09 FETCH_HEAD
-rw-r--r--   1 johnmortensen  staff    21 Jun 11 04:39 HEAD
-rw-r--r--   1 johnmortensen  staff    41 Jun 11 09:09 ORIG_HEAD
drwxr-xr-x   2 johnmortensen  staff    64 Jun 11 04:39 branches
-rw-r--r--   1 johnmortensen  staff   312 Jun 11 04:39 config
-rw-r--r--   1 johnmortensen  staff    73 Jun 11 04:39 description
drwxr-xr-x  13 johnmortensen  staff   416 Jun 11 04:39 hooks
-rw-r--r--   1 johnmortensen  staff  4695 Jun 11 09:09 index
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 info
drwxr-xr-x   4 johnmortensen  staff   128 Jun 11 04:39 logs
drwxr-xr-x  34 johnmortensen  staff  1088 Jun 11 09:09 objects
-rw-r--r--   1 johnmortensen  staff   112 Jun 11 04:39 packed-refs
drwxr-xr-x   5 johnmortensen  staff   160 Jun 11 04:39 refs

look at config file
[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
	ignorecase = true
...
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch "main"]
	remote = origin
	merge = refs/heads/main
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...

File listing and status
-rw-r--r--  1 johnmortensen  wheel  809 Jun 11 10:43 sample.md
      15     132     809 sample.md

Show Generated Markdown ========================================================

This introductory paragraph and this line and the title above are generated
using tee with the standard input (<<) redirection operator.
- This bulleted element is still part of the tee body.
- This bulleted element and lines below are generated using echo with standard
output (>>) redirection operator.
- The list definition, as is, is using space to seperate lines. Thus the use of
commas and hyphens in output.
      - ls: list directory
      - cd: change directory
      - pwd: present working directory
      - if then fi: test condition
      - env: bash environment variables
      - cat: view file contents
      - tee: write to output
      - echo: display content of string
      - echo "sample text" >$file: write content to file
      - echo "sample text" >>$file: append content to file
### Env, Git and GitHub
> Env(ironment) is used to capture things like path to Code or Home directory.  Git and GitHub is NOT Only used to exchange code between individuals, it is often used to exchange code through servers, in our case deployment for Website.   All tools we use have a behind the scenes hav relationship with the system they run on (MacOS, Windows, Linus) or a relationship with servers which they are connected to (ie GitHub).  There is an "env" command in bash.  There are environment files and setting files (.git/config) for Git.  They both use a key/value concept.

- "env" show setting for your shell
- "git clone" sets up a director of files
- "cd $project" allows user to move inside that directory of files
- ".git" is a hidden directory that is used by git to establish relationship between machine and the git server on GitHub.  

### Student Request - Make a file in Bash
> This example was requested by a student (Jun Lim, CSA). The request was to make jupyer file using bash, I adapted the request to markdown.  This type of thought will have great extrapolation to coding and possibilities of using List, Arrays, or APIs to build user interfaces.  JavaScript is a language where building HTML is very common.

> To get more interesting output from terminal, this will require using something like mdless (https://github.com/ttscoff/mdless).  This enables see markdown in rendered format.
- On Desktop [Install PKG from MacPorts](https://www.macports.org/install.php)
- In Terminal on MacOS
    - [Install ncurses](https://ports.macports.org/port/ncurses/)
    - ```gem install mdless```
    
> Output of the example is much nicer in "jupyter"

```bash
%%script bash

# This example has error in VSCode, it run best on Jupyter
cd /tmp

file="sample.md"
if [ -f "$file" ]; then
    rm $file
fi

tee -a $file >/dev/null <<EOF
# Show Generated Markdown
This introductory paragraph and this line and the title above are generated using tee with the standard input (<<) redirection operator.
- This bulleted element is still part of the tee body.
EOF

echo "- This bulleted element and lines below are generated using echo with standard output (>>) redirection operator." >> $file
echo "- The list definition, as is, is using space to seperate lines.  Thus the use of commas and hyphens in output." >> $file
actions=("ls,list-directory" "cd,change-directory" "pwd,present-working-directory" "if-then-fi,test-condition" "env,bash-environment-variables" "cat,view-file-contents" "tee,write-to-output" "echo,display-content-of-string" "echo_text_>\$file,write-content-to-file" "echo_text_>>\$file,append-content-to-file")
for action in ${actions[@]}; do  # for loop is very similar to other language, though [@], semi-colon, do are new
  action=${action//-/ }  # convert dash to space
  action=${action//,/: } # convert comma to colon
  action=${action//_text_/ \"sample text\" } # convert _text_ to sample text, note escape character \ to avoid "" having meaning
  echo "    - ${action//-/ }" >> $file  # echo is redirected to file with >>
done

echo ""
echo "File listing and status"
ls -l $file # list file
wc $file   # show words
mdless $file  # this requires installation, but renders markown from terminal

rm $file  # clean up termporary file
```

show the secrets of .git
total 72
-rw-r--r--   1 johnmortensen  staff     9 Jun 11 09:09 COMMIT_EDITMSG
-rw-r--r--   1 johnmortensen  staff   102 Jun 11 09:09 FETCH_HEAD
-rw-r--r--   1 johnmortensen  staff    21 Jun 11 04:39 HEAD
-rw-r--r--   1 johnmortensen  staff    41 Jun 11 09:09 ORIG_HEAD
drwxr-xr-x   2 johnmortensen  staff    64 Jun 11 04:39 branches
-rw-r--r--   1 johnmortensen  staff   312 Jun 11 04:39 config
-rw-r--r--   1 johnmortensen  staff    73 Jun 11 04:39 description
drwxr-xr-x  13 johnmortensen  staff   416 Jun 11 04:39 hooks
-rw-r--r--   1 johnmortensen  staff  4695 Jun 11 09:09 index
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 info
drwxr-xr-x   4 johnmortensen  staff   128 Jun 11 04:39 logs
drwxr-xr-x  34 johnmortensen  staff  1088 Jun 11 09:09 objects
-rw-r--r--   1 johnmortensen  staff   112 Jun 11 04:39 packed-refs
drwxr-xr-x   5 johnmortensen  staff   160 Jun 11 04:39 refs

look at config file
[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
	ignorecase = true
...
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch "main"]
	remote = origin
	merge = refs/heads/main
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...









File listing and status
-rw-r--r--  1 johnmortensen  wheel  809 Jun 11 10:43 sample.md
      15     132     809 sample.md

Show Generated Markdown ========================================================

This introductory paragraph and this line and the title above are generated
using tee with the standard input (<<) redirection operator.
- This bulleted element is still part of the tee body.
- This bulleted element and lines below are generated using echo with standard
output (>>) redirection operator.
- The list definition, as is, is using space to seperate lines. Thus the use of
commas and hyphens in output.
      - ls: list directory
      - cd: change directory
      - pwd: present working directory
      - if then fi: test condition
      - env: bash environment variables
      - cat: view file contents
      - tee: write to output
      - echo: display content of string
      - echo "sample text" >$file: write content to file
      - echo "sample text" >>$file: append content to file

Project dir: /Users/johnmortensen/vscode
Project: /Users/johnmortensen/vscode/teacher
Repo: https://github.com/nighthawkcoders/teacher.git
Using conditional statement to create a project directory and project
Directory /Users/johnmortensen/vscode exists.
Directory /Users/johnmortensen/vscode/teacher exists.
Navigate to project, then navigate to area wwhere files were cloned
/Users/johnmortensen/vscode/teacher

list top level or root of files with project pulled from github
Gemfile
Gemfile.lock
LICENSE
Makefile
README.md
_config.yml
_data
_includes
_layouts
_notebooks
_posts
_site
csa.md
csp.md
csse.md
images
index.md
indexBlogs.md
nohup.out
scripts
Navigate to project, then navigate to area wwhere files were cloned
/Users/johnmortensen/vscode/teacher

list all files in long format
total 120
drwxr-xr-x  25 johnmortensen  staff   800 Jun 11 09:06 .
drwxr-xr-x  61 johnmortensen  staff  1952 Jun 11 04:39 ..
drwxr-xr-x  16 johnmortensen  staff   512 Jun 11 09:09 .git
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 .github
-rw-r--r--   1 johnmortensen  staff    37 Jun 11 04:39 .gitignore
-rw-r--r--   1 johnmortensen  staff    73 Jun 11 04:39 Gemfile
-rw-r--r--   1 johnmortensen  staff  7309 Jun 11 04:39 Gemfile.lock
-rw-r--r--   1 johnmortensen  staff  1081 Jun 11 04:39 LICENSE
-rw-r--r--   1 johnmortensen  staff  1318 Jun 11 04:39 Makefile
-rw-r--r--   1 johnmortensen  staff  1373 Jun 11 04:39 README.md
-rw-r--r--   1 johnmortensen  staff   405 Jun 11 06:46 _config.yml
drwxr-xr-x   6 johnmortensen  staff   192 Jun 11 04:39 _data
drwxr-xr-x   9 johnmortensen  staff   288 Jun 11 04:39 _includes
drwxr-xr-x   6 johnmortensen  staff   192 Jun 11 04:39 _layouts
drwxr-xr-x  11 johnmortensen  staff   352 Jun 11 08:33 _notebooks
drwxr-xr-x  12 johnmortensen  staff   384 Jun 11 08:52 _posts
drwxr-xr-x  21 johnmortensen  staff   672 Jun 11 10:35 _site
-rw-r--r--   1 johnmortensen  staff    92 Jun 11 04:39 csa.md
-rw-r--r--   1 johnmortensen  staff    98 Jun 11 04:39 csp.md
-rw-r--r--   1 johnmortensen  staff   108 Jun 11 04:39 csse.md
...
-rw-r--r--   1 johnmortensen  staff  5122 Jun 11 04:39 index.md
-rw-r--r--   1 johnmortensen  staff    53 Jun 11 04:39 indexBlogs.md
-rw-------   1 johnmortensen  staff  2307 Jun 11 10:35 nohup.out
drwxr-xr-x   3 johnmortensen  staff    96 Jun 11 04:39 scripts
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...
Look for posts
/Users/johnmortensen/vscode/teacher/_posts
total 224
-rw-r--r--  1 johnmortensen  staff   8086 Jun 11 09:06 2023-05-30-linux_shell_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   3878 Jun 11 08:49 2023-05-30-pair_programming.md
-rw-r--r--  1 johnmortensen  staff   5552 Jun 11 09:06 2023-05-31-VSCode-GitHub-project_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   6271 Jun 11 09:06 2023-06-01-javascript-input_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   8702 Jun 11 09:06 2023-06-01-python_hello_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  24393 Jun 11 09:06 2023-06-02-javascript_output_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  11097 Jun 11 09:06 2023-06-03-javascript_api_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff  15072 Jun 11 09:06 2023-06-04-AWS-deployment_IPYNB_2_.md
-rw-r--r--  1 johnmortensen  staff   5215 Jun 11 08:51 2023-06-04-javascript-animation-mario-oop.md
-rw-r--r--  1 johnmortensen  staff  12219 Jun 11 09:06 2023-06-08-JWT-python_IPYNB_2_.md
Look for notebooks
/Users/johnmortensen/vscode/teacher/_notebooks
total 344
-rw-r--r--  1 johnmortensen  staff  37377 Jun 11 10:35 2023-05-30-linux_shell.ipynb
-rw-r--r--  1 johnmortensen  staff   7706 Jun 11 09:04 2023-05-31-VSCode-GitHub-project.ipynb
-rw-r--r--  1 johnmortensen  staff   9292 Jun 11 08:47 2023-06-01-javascript-input.ipynb
-rw-r--r--  1 johnmortensen  staff  11477 Jun 11 04:39 2023-06-01-python_hello.ipynb
-rw-r--r--  1 johnmortensen  staff  44353 Jun 11 08:06 2023-06-02-javascript_output.ipynb
-rw-r--r--  1 johnmortensen  staff  15666 Jun 11 08:48 2023-06-03-javascript_api.ipynb
-rw-r--r--  1 johnmortensen  staff  20550 Jun 11 09:06 2023-06-04-AWS-deployment.ipynb
-rw-r--r--  1 johnmortensen  staff  16271 Jun 11 04:39 2023-06-08-JWT-python.ipynb
Look for images in notebooks, print working directory, list files
/Users/johnmortensen/vscode/teacher/_notebooks
bash: line 6: cd: /images: No such file or directory
total 344
-rw-r--r--  1 johnmortensen  staff  37377 Jun 11 10:35 2023-05-30-linux_shell.ipynb
-rw-r--r--  1 johnmortensen  staff   7706 Jun 11 09:04 2023-05-31-VSCode-GitHub-project.ipynb
-rw-r--r--  1 johnmortensen  staff   9292 Jun 11 08:47 2023-06-01-javascript-input.ipynb
-rw-r--r--  1 johnmortensen  staff  11477 Jun 11 04:39 2023-06-01-python_hello.ipynb
-rw-r--r--  1 johnmortensen  staff  44353 Jun 11 08:06 2023-06-02-javascript_output.ipynb
-rw-r--r--  1 johnmortensen  staff  15666 Jun 11 08:48 2023-06-03-javascript_api.ipynb
-rw-r--r--  1 johnmortensen  staff  20550 Jun 11 09:06 2023-06-04-AWS-deployment.ipynb
-rw-r--r--  1 johnmortensen  staff  16271 Jun 11 04:39 2023-06-08-JWT-python.ipynb
Navigate to project, then navigate to area wwhere files were cloned
show the contents of README.md

## Blog site using GitHub Pages and Jekyll
> This site is intended for Teachers.   This is to build lessons and distribute across different sections.
- This support 3 computer science sections that are in a pathway (JavaScript, Python/Flask, Java/Spring)
- JavaScript documents are new material for entry class into the pathway, they are prerequisites for the Python and Java classes.
- All course material works off of Notebooks using Python kernel, except Java which requires it own kernel.

## Preview Site 
> GitHub Pages development is optimized by testing and developing on your local machine.  This is called previewing you work, prior to commit and push. 
- GitHub setup for, [Testing your GitHub Pages site locally with Jekyll](https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll/testing-your-github-pages-site-locally-with-jekyll).  After requirements are met for Jekyll and Ruby you need to install requirements for project.
```bash
bundle install
```
- Now the project is ready for preview.  To simplify typing and sharing logging the details for running have be place in a ```Makefile```
    - run preview server
    ```bash
    make
    ```
    - stop preview server
    ```bash
    make stop
    ```
    - test notebook conversions
...
    make clean
    ```

end of README.md
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...
Show the shell environment variables, key on left of equal value on right

VSCODE_CLI=1
NIX_PROFILES=/nix/var/nix/profiles/default /Users/johnmortensen/.nix-profile
VSCODE_CRASH_REPORTER_PROCESS_TYPE=extensionHost
TERM_PROGRAM=Apple_Terminal
TERM=xterm-color
SHELL=/bin/bash
CLICOLOR=1
VSCODE_CRASH_REPORTER_SANDBOXED_HINT=1
TMPDIR=/var/folders/_n/7k1b0n557ng0fkmw74pd5cx00000gn/T/
CONDA_SHLVL=1
PYTHONUNBUFFERED=1
TERM_PROGRAM_VERSION=447
CONDA_PROMPT_MODIFIER=(base) 
ORIGINAL_XDG_CURRENT_DESKTOP=undefined
MallocNanoZone=0
PYDEVD_USE_FRAME_EVAL=NO
TERM_SESSION_ID=9056DE5B-8519-46AC-8C0A-42B5FFE425B9
PYTHONIOENCODING=utf-8
USER=johnmortensen
COMMAND_MODE=unix2003
CONDA_EXE=/Users/johnmortensen/opt/anaconda3/bin/conda
SSH_AUTH_SOCK=/private/tmp/com.apple.launchd.htDuJuikD5/Listeners
__CF_USER_TEXT_ENCODING=0x1F5:0x0:0x0
...
VSCODE_L10N_BUNDLE_LOCATION=
VSCODE_CWD=/Users/johnmortensen/vscode/teacher
SECURITYSESSIONID=186a6
_=/usr/bin/env
Output is truncated. View as a scrollable element or open in a text editor. Adjust cell output settings...

## Hack Preparation.
> Review Tool Setup Procedures and think about some thing you could verify through a Shell notebook.
- Come up with your own student view of this procedure to show your tools are installed.
- Name and create notes on some Linux commands you will use frequently: ls and cd (do go back to directory the current directory is in, do cd..)
- Is there anything we use to verify tools we install? Review versions checks.
- Is there anything we could verify with Anaconda?  or WSL?  
- How would you update a repository?  Could you do that in script above? I would usually just update the repository through git commands and gui, like push then commit and just push again. But sometimes when necessary, I will use the script.