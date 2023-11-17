yum install yum-utils
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
yum install docker-ce docker-ce-cli containerd.io
systemctl enable --now docker
systemctl status docker
docker run -d -p 80:80 --restart=always --name nginx-proxy nginx
docker ps
ss -tulnp

curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-Linux-x86_64" -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
docker-compose -v

sudo echo "version: '3'" > docker-compose.yaml

sudo echo "
services:
  mysql:
    image: mysql:8
    command: --default-authentication-plugin=mysql_native_password
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: wordpress
    volumes:
      - './db:/var/lib/mysql'

  wordpress:
    image: wordpress:php7.4-apache
    ports:
      - '80:80'
    environment:
      WORDPRESS_DB_HOST: mysql
      WORDPRESS_DB_USER: root
      WORDPRESS_DB_PASSWORD: root
      WORDPRESS_DB_NAME: wordpress
    volumes:
      - './wp:/var/www/html/'
" > docker-compose.yaml
 

docker-compose up

systemctl stop firewalld
systemctl restart docker


sudo apt update
# sudo apt install apt-transport-https
# curl -fsSL https://download.docker.com/linux/centos/gpg | sudo apt-key add -
# sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/centos $(lsb_release -cs) stable"
# sudo apt update
# sudo apt install docker-ce
# sudo systemctl status docker
# sudo usermod -aG docker $USER

# docker ps
# docker ps -a
# docker images

# docker search tomcat
# docker pull tomcat
# docker run -it -p 1234:8080 tomcat
# docker run -it -p 8888:80 nginx
# docker run -d -p 8888:80 nginx

# docker build -t pasha .
# docker images

# docker run -it  -p 1234:80  pasha:latest
# docker run -d -p  1234:80  pasha:latest

# docker  ps -a

# docker tag pasha_ubuntu pasha_ubuntu-PROD
# docker tag pasha_ubuntu pasha_ubuntu-PROD:v2

# docker rm   # delete container
# docker rmi  # delete image

# docker run -d -p 7777:80 pasha_ubuntu4
# docker exec -it 5267e21d140 /bin/bash
# echo "V2" >> /var/www/html/index.html
# exit
# docker commit 5267e21d140 pasha_v2:latest
# docker save image:tag > arch_name.tar
# docker load -i arch_name.tar

# # docker rm -f $(docker ps -aq)        # Delete all Containers
# # docker rmi -f $(docker images -q)    # Delete all Images