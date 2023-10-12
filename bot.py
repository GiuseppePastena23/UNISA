import os
import datetime
import git

repo = git.Repo(os.getcwd())

master = repo.head.reference

print(master.commit.message)