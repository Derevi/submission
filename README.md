# General FAQ for group project goes here for now..

# Naming Conventions for Branches
feature/name      Feature I'm adding or expanding

bug/name          Bug fix or experiment


# Creating and push branches

When working on a feature make sure you create a new branch use command:

``git checkout -b "feature/name"    ..... (ignore quotes)``

To push the branch to remote origin so that it shows up on github use command:

``git push -u origin "feature/name"  ..... (ignore quotes)``

# Merging Branches
When you merge a branch it will merge on your local project files first and effectively remove one of the branches.
As an example if I want to merge one of my feature branches to master I would do the following:

``git checkout master
``git merge feature/something    #this deletes the feature branch
``git push origin master      #this pushes all the changes to origin the remote repo on github

Notice that the branch will still appear on github and you have to delete that as well using command:
``git push origin --delete feature/something
***Be sure to issue "--delete" or its alias "-d" as that only deletes a branch if it has already been fully merged upstream***
***If you instead use option "-D" which is an alias for "--delete --force" it deletes the branch "irrespective of its merged status." 

# Before you merge
note before you merge and delete your branch make sure to have fully tested it with master
