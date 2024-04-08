ssh-copy-id
ssh-keygen
ssh-keygen
ifconfig
sudo echo 'user ALL=(ALL) NOPASSWD:ALL' > /etc/sudoers.d/user
vi /etc/sysconfig/network-scripts/ifcfg-eth0
nmcli d
ifdown enp0s3
ifup enp0s3
nmcli d
#vi /etc/sysconfig/network-scripts/ifcfg-
ip a
cat /etc/sysconfig/network-scripts/ifcfg-
cat /etc/sysconfig/network-scripts/ifcfg-enp0s3
ping google.com

echo "BOOTPROTO=static
IPADDR=192.168.1.21
GATEWAY=192.168.1.1
DNS1=8.8.8.8
DNS2=8.8.4.4
NETMASK=255.255.255.0" > /etc/sysconfig/network-scripts/ifcfg-enp0s3
service network restart
systemctl status network.service
ifup
nmcli -d
ping google.com
yum -y install expect

history > ip.sh
