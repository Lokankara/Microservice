#!/bin/bash
HOST="192.168.0.103"
NAME="user"
FILE1="/tmp/*.log"
FILE2="log.txt"
sudo apt-get install ftp
command -v ftp
sudo yum install ftp
command -v ftp
ftp $HOST
ls
get $FILE1
put $FILE1
ls /home/$NAME

#sftp
sftp $HOST
#/home/user/.ssh/known_hosts by default
scp $FILE1 $NAME@$HOST:$FILE2
ls
get $FILE1
$ put $FILE1
ls -l
#scp user@192.168.178.28:file user@192.168.178.27:file

sudo yum install rsync
rsync $FILE1 $NAME@$HOST:$FILE2
