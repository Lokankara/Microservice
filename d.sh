sudo apt update
sudo apt install apt-transport-https
curl -fsSL https://download.docker.com/linux/centos/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/centos $(lsb_release -cs) stable"
sudo apt update
sudo apt install docker-ce
sudo systemctl status docker
sudo usermod -aG docker $USER

docker ps
docker ps -a
docker images

docker search tomcat
docker pull tomcat
docker run -it -p 1234:8080 tomcat
docker run -it -p 8888:80 nginx
docker run -d -p 8888:80 nginx

docker build -t pasha .
docker images

docker run -it  -p 1234:80  pasha:latest
docker run -d -p  1234:80  pasha:latest

docker  ps -a

docker tag pasha_ubuntu pasha_ubuntu-PROD
docker tag pasha_ubuntu pasha_ubuntu-PROD:v2

docker rm   # delete container
docker rmi  # delete image

docker run -d -p 7777:80 pasha_ubuntu4
docker exec -it 5267e21d140 /bin/bash
echo "V2" >> /var/www/html/index.html
exit
docker commit 5267e21d140 pasha_v2:latest
docker save image:tag > arch_name.tar
docker load -i arch_name.tar

# docker rm -f $(docker ps -aq)        # Delete all Containers
# docker rmi -f $(docker images -q)    # Delete all Images