ip a
nmcli
#adduser user1
#passwd user1
#echo >> 1
#echo >> 1
#usermod -aG wheel user
#exit
ssh user@192.168.0.130
#echo >> 1
sudo echo 'user ALL=(ALL) NORASSWD:ALL' > /etc/sudoers.d/user
ssh user@192.168.0.130

