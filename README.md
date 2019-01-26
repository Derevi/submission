# General FAQ for group project goes here for now..

# Note About JavaFX

For this project we will beusing FXML to create our gui. Luckily there is a graphical based tool that can generate the front end for us
automatically. The link to the download is below:
https://gluonhq.com/products/scene-builder/
I believe this is a standalone app I havent used it my self.
You should be able to create the front end and then the program will spit out an FXML document which we can the copy paste to our project

************************THERE ARE ISSUES RUNNING FXML WITH MAVEN DEPENDENCIES I HAVE TO FIX THE MAVEN PLUGINS I WILL DO THAT LATER***

for now use the SDK download from here https://gluonhq.com/products/javafx/

use the guide here: https://openjfx.io/openjfx-docs/

you want to add the lib to your IDE first..


and when you run make sure you set the VM options!! JVM needs to know where the libraries are or else it can run anything

for mac/linux use:

``--module-path /path/to/javafx-sdk-11.0.1/lib --add-modules=javafx.controls,javafx.fxml``

for windows use:

``--module-path "\path\to\javafx-sdk-11.0.1\lib" --add-modules=javafx.controls,javafx.fxml``

# Website for maven dep

https://mvnrepository.com/

# IMPORTANT UPDATE: JAVAFX

You CANNOT run the project regularly the reason for this is because JVM needs to compile the project and it DOES NOT KNOW where the jar files are for the JAVAFX library
Use maven to execute it because it will load the proper jars
I have created custom plugin that will compile and run with maven jars

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

``git checkout master``

``git merge feature/something``    

``git push origin master      ...... this pushes all the changes to origin the remote repo on github``


Notice that the branch will still appear on github and you have to delete that as well using command:

``git push origin --delete feature/something``

***Be sure to issue "--delete" or its alias "-d" as that only deletes a branch if it has already been fully merged upstream***

***If you instead use option "-D" which is an alias for "--delete --force" it deletes the branch "irrespective of its merged status." 

to delete your branch locally use commmand:

``git branch -d feature/something``


# Before you merge
note before you merge and delete your branch make sure to have fully tested it with master

