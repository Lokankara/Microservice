#!/usr/bin/expect
sudo yum update -y
sudo yum install keychain -y
sudo yum install sshpass -y
sudo yum install expect -y

spawn sftp user@192.168.0.103
expect "password:"
send "yourpasswordhere\n"
expect "sftp>"
send "cd logdirectory\n"
expect "sftp>"
send "put /var/log/file.log\n"
expect "sftp>"
send "exit\n"
interact

export SSHPASS=your-password-here
sshpass -e sftp -oBatchMode=no -b - sftp-user@remote-host << !
   cd incoming
   put your-log-file.log
   bye
!

#lftp -e 'mirror -R /local/log/path/ /remote/path/' --env-password -u user sftp.foo.com
lftp --env-password sftp://user@host  -e "put local-file.name; bye"

#!/bin/bash

sftp -oPort=21 user@192.168.0.130:/home/user/test/update <<EOF
put /home/user/.m2/repository/com/pasha/TestPlugin/0.0.1-SNAPSHOT/TestPlugin-0.0.1-SNAPSHOT.jar 
exit
EOF

vi test_script.sh
#!/bin/sh
HOST=<yourhostname>
USER=<someusername>
PASSWD=<yourpasswd>

cd <base directory for your put file>

lftp<<END_SCRIPT
open sftp://$HOST
user $USER $PASSWD
put local-file.name
bye
END_SCRIPT

chmod +x test_script.sh
./test_script.sh
