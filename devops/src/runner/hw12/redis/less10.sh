sudo apt-get install bridge-utils -y
mkdir redis 
docker images
#docker run --name redis -v $(pwd)/redis/:/data/ -d redis
#docker exec -it redis /bin/bash

#apt-get update -y && apt-get install procps -y && ps aux -y
#docker stop redis
docker ps && docker ps -a
docker start redis
docker ps
docker exec -it redis /bin/bash
docker exec -it nginx /bin/bash
docker run  --name nginx -d nginx
docker ps
ip a | grep docker0
brctl show docker0

