nmcli d
sudo echo "
DEVICE=enp42
ONBOOT=yes
IPADDR=192.168.1.42
NETMASK=255.255.255.0
GATEWAY=192.168.1.1" >> /etc/sysconf ig/network-scripts/ifcfg-enp42
ifdown enp42
ifup enp42
sudo echo"
DEVICE=enp42
ONBOOT=no
DHCP=yes" >> /etc/sysconfig/network-scripts/ifcfg-enp42
ifdown enp42
ifup enp42
ip a show enp42
