# USING PROJECT WITH WITH INTELLIJ
Major updates to master were done.

Instructions to use:
1) first clone repo

2) MAKE SURE YOU HAVE OPENJDK11:  https://jdk.java.net/11/
IF not download install and setup the proper pathing

3) Launch Intellij

4) navigate .. File > open
  and select this project

5) once the project is loaded a popup will appear  asking the following:

[Popup](https://github.com/Derevi/submission/blob/master/Capture1.PNG)

  Click on the blue font "import Gradle project"
  
6) Now you need to tell intellij which folders is your source code, test etc. Gradle does this automatically for you.
You can do this by opening the gradle task (it is the tool bar on the far right side, labelled gradle, and has an elephant icon)
then click the refresh button. This will sync everything up and it should work perfectly

[screenshot labelled](https://github.com/Derevi/submission/blob/master/Capture2.PNG)

  Everything should now work out of the box, with out messing around with any vm args or anything else



# Installation

Refer to the "User Manual.pdf" in the folder "Documentation" for installation help.

# Requirements

Refer to the "Requirements Document.pdf" in the folder "Documentation".

# Executable Jars

The two executable jars are "editorApp.jar" for the app used to edit the talkbox buttons and "talkboxApp.jar" for the main front end of the talkbox.
