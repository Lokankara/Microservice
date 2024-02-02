#!/bin/sh
#Logging
# set -e
# LOG_F="/tmp/sftp-server-setup_"`date "+%F-%T"`".log"
# exec &> >(tee "${LOG_F}")
# echo "Logging setup to ${LOG_F}"

# #add user
# adduser $1
# passwd $1
# usermod -aG wheel $1
# echo "$1 ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers.d/$1
# #echo "$1 ALL=(ALL) NOPASSWD:ALL" | EDITOR= "tee -a" visudo

# user sudo
#chmod 0440 /etc/sudoers.d/$1
#chown -R $1:$1 /home/$1/.ssh/

apt-get update -y
systemctl start firewalld
systemctl enable firewalld
#firewall-cmd --state

systemctl start vsftpd
systemctl enable vsftpd

#systemctl stop firewalld
#firewall

firewall-cmd --zone=public --permanent --add-port=21/tcp
firewall-cmd --zone=public --permanent --add-service=ftp
firewall-cmd --zone=public --permanent --add-port=10000-10001/tcp
firewall-cmd --reload

#firewall-cmd --state

#config

cp /etc/vsftpd/vsftpd.conf /etc/vsftpd/vsftpd.conf.default
echo "anonymous_enable=NO" >> /etc/vsftpd/vsftpd.conf
echo "local_enable=YES" >> /etc/vsftpd/vsftpd.conf
echo "write_enable=YES" >> /etc/vsftpd/vsftpd.conf
echo "chroot_local_user=YES" >> /etc/vsftpd/vsftpd.conf
echo "allow_writeable_chroot=YES" >> /etc/vsftpd/vsftpd.conf
echo "userlist_enable=YES" >> /etc/vsftpd/vsftpd.conf
echo "userlist_file=/etc/vsftpd/user_list" >> /etc/vsftpd/vsftpd.conf
echo "userlist_deny=NO" >> /etc/vsftpd/vsftpd.conf
echo "chroot_list_enable=YES" >> /etc/vsftpd/vsftpd.conf
echo "chroot_list_file=/etc/vsftpd/chroot_list" >> /etc/vsftpd/vsftpd.conf
echo "pasv_enable=YES" >> /etc/vsftpd/vsftpd.conf
echo "pasv_min_port=10000" >> /etc/vsftpd/vsftpd.conf
echo "pasv_max_port=10001" >> /etc/vsftpd/vsftpd.conf
#vi /etc/vsftpd/vsftpd.conf

systemctl restart vsftpd

systemctl start firewalld
systemctl enable firewalld

echo $1 | tee -a /etc/vsftpd/user_list
echo $1 | tee -a /etc/vsftpd/chroot_list

# add new ftp test 

adduser $2
passwd $2
echo $2 | tee -a /etc/vsftpd/user_list
mkdir -p /home/$2/ftp/upload
chmod 550 /home/$2/ftp
chmod 750 /home/$2/ftp/upload
chown -R $2: /home/$2/ftp

echo "=============ftp==============="

#chmod +x ftp.sh
#HOST="192.168.0.103"
#USER="user"
#PWD=1

#ftp -inv $HOST <<EOF
#user $USER $PWD
#cd /tmp
#put *.log
#bye
#EOF

git config --global user.name polyakpavlo
git config --global user.email poliyakpavlo@gmail.com
#git clone https://github.com/pyanush/devops_crash.git
#cd ./devops_crash
#git branch polyakpavlo_25021982
#git branch
#git checkout polyakpavlo_25021982
#git branch --set-upstream-to=origin polyakpavlo_25021982
#git pull
#mkdir lesson3
#cp /tmp/* lesson3
#git add .
#git status
#git commit -m "logs add in lesson3"
#git push -u origin polyakpavlo_25021982
#git status