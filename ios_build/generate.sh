#!/bin/bash
export PATH=/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Users/admin/gradle/bin
rm -rf ~/filePath
ln -s /Users/admin/Desktop/Sloan_app_ionic_iOS  ~/filePath 
cd ~/filePath
echo 'Changed the file directory to project directory'
gradle -q shareTheApp