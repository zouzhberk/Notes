Docker Machine & Docker Compose & Docker Registry
===============================

## Docker Machine

Docker Machine 可以通过


## Docker Compose

### Docker Compose的工作原理

Docker Compose将所管理的容器分为三层，工程（project），服务（service）以及容器（contaienr）。Docker Compose运行的目录下的所有文件（docker-compose.yml, extends文件或环境变量文件等）组成一个工程，若无特殊指定工程名即为当前目录名。一个工程当中可包含多个服务，每个服务中定义了容器运行的镜像，参数，依赖。一个服务当中可包括多个容器实例，Docker Compose并没有解决负载均衡的问题，因此需要借助其他工具实现服务发现及负载均衡。



### Docker Compose 说明
 
```
version: '2'
services:
  web:
    build: .
    ports:
    - "5000:5000"
    volumes:
    - .:/code
    - logvolume01:/var/log
    links:
    - redis
  redis:
    image: redis
volumes:
  logvolume01: {}
```



## Docker 镜像使用帮助


[https://lug.ustc.edu.cn/wiki/mirrors/help/docker](https://lug.ustc.edu.cn/wiki/mirrors/help/docker)

使用说明



新版的 Docker 使用 /etc/docker/daemon.json（Linux） 或者 %programdata%\docker\config\daemon.json（Windows） 来配置 Daemon。

请在该配置文件中加入（没有该文件的话，请先建一个）：

{
  "registry-mirrors": ["https://docker.mirrors.ustc.edu.cn"]
} 


