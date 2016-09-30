Docker Storage Driver 介绍与选择
===============================

Docker模型的核心部分是有效利用分层镜像机制，镜像可以通过分层来进行继承，基于基础镜像（没有父镜像），可以制作各种具体的应用镜像。不同 Docker 容器就可以共享一些基础的文件系统层，同时再加上自己独有的改动层，大大提高了存储的效率。



Overlay

Overlay2

DeviceMapper Centos7 会出现镜像下不了情况

## Docker Volume

http://www.linuxidc.com/Linux/2015-05/117378.htm


## Reference

https://docs.docker.com/engine/userguide/storagedriver/imagesandcontainers/

https://docs.docker.com/engine/userguide/storagedriver/selectadriver/#select-a-storage-driver