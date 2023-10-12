import os
import datetime
import time
import git

last_commit = ""

while(True):
    repo = git.Repo(os.getcwd())
    master = repo.head.reference    
    commit = master.commit.message
    if(commit != last_commit):
        print(commit)
        last_commit = commit
    

    time.sleep(5);