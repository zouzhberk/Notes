Ambari Study
==


#1  安装与配置

##1.1  模块依赖分析
Ambari主要由python(>=2.6)以及java。

###1.1.1  Ambari-Server 
1. Python
2. Java
3. Ambari-web
4. Apache Flume (非必须依赖，)
 1.1.2  Ambari-Agent
Python
Ambari-common
Facter(--> ruby)
Puppet(--> ruby)
 1.1.3  Ambari-common
此模块仅包含jinjia2开源python模块，jinja2依赖Sphinx模块。
 1.1.4  Ambari-client
此模块为Ambari提供客户端API,依赖python.

 1.1.5  Ambari-Web
Ambari-Web使用node.js，所以依赖如下模块
Npm
brunch
同时可以结合Ganglia与Nagios，但并非必须依赖。


 1.2  非ROOT权限下编译
 1.2.1  依赖包安装与环境变量设置
1. 首先以非root权限安装facter( http://downloads.puppetlabs.com/facter/facter-1.6.10.tar.gz ),puppet (  http://downloads.puppetlabs.com/puppet/puppet-2.7.9.tar.gz )
 1.2.1.1  ruby,facter,puppet 安装与设置
Puppet依赖Facter, Puppet( http://downloads.puppetlabs.com/puppet/puppet-2.7.9.tar.gz)与Facter(http://downloads.puppetlabs.com/facter/facter-1.6.10.tar.gz)依赖ruby.
1. 首先确认已经安装 ruby.
2. 安装facter
cd facter
ruby install.rb --destdir=/home/clouder/berk/programs/puppet

3. 安装puppet
cd puppet
ruby install.rb --destdir=/home/clouder/berk/programs/puppet
4. 设置环境变量
编辑~/.bashrc 添加.
export RUBYLIB=$RUBYLIB:/home/clouder/berk/programs/puppet/usr/lib/ruby/site_ruby/1.8
export PATH=$PATH:/home/clouder/berk/programs/puppet/usr/bin

5.    puppet测试：见附录1.

 1.2.1.2  Python, Jinja2, Sphinx 安装与设置
Ambari-common 即为jinja2模块，jinja2为基于Python的模板引擎，依赖于模块Sphinx,安装配置步骤如下：
1. 首先确保已经安装python 2.6或以上版本
2. 安装sphinx
wget https://pypi.python.org/packages/source/S/Sphinx/Sphinx-1.2.2.tar.gz
tar -zxf Sphinx-1.2.2.tar.gz
cd Sphinx-1.2.2
python setup.py build
cp -rf ./build/lib  /home/clouder/berk/programs/lib/python/site-packages/

export PYTHONPATH=$PYTHONPATH:/home/clouder/berk/programs/lib/python/site-packages

3. 同理安装与配置jinja2
4. 测试jinja2
cd /home/clouder/berk/ambari-1.4.4/ambari-common/src/main/python/jinja2
python setup.py test

 1.2.1.3  npm,brunch 安装配置

 1.2.2  编译过程
wget http://www.apache.org/dist/ambari/ambari-1.4.4/ambari-1.4.4.tar.gz
tar xfvz ambari-1.4.4.tar.gz
cd ambari-1.4.4
mvn -X -B -e clean install package rpm:rpm -DskipTests -Dpython.ver="python >= 2.6"

编译完成之后主要使用 ambari-agent与ambari-server 的target目录下的安装包，分别为
ambari-server-1.3.0-SNAPSHOT-dist.tar.gz 与ambari-agent-1.0.3-SNAPSHOT.linux-x86_64.tar.gz
 1.3  Ambari 使用设置
 1.3.1  Ambari-Server使用配置
1. 修改sbin/ambari-server.py
将此文件使用绝对路径的地方改成使用AMBARI_SERVER_HOME变量定义的位置。
2. 

目前Ambari-Server设置必须拥有root权限.


 2  源码剖析
 2.1  系统框架
 2.2  Ambari-Server分析


 3  附录2  ambari.properties 属性说明
属性
说明
备注
client.api.port
Ambari Web 服务端口
默认值为8080
webapp.dir
web 服务安装 路径

resources.dir
Java jar 包路径
需预先设置，如果不设置此值则setup 报错
server.jdbc.rca.driver
分别为数据库ambarirca 所使用的Driver, username,url 以及密码文件路径

server.jdbc.rca.user.name

默认等于server.jdbc.user.name
server.jdbc.rca.url


server.jdbc.rca.user.passwd


server.jdbc.schema
数据库名
默认为ambari 
server.jdbc.user.name


server.jdbc.port


server.jdbc.driver


server.jdbc.url


server.jdbc.user.passwd


server.jdbc.database
数据库类型

ambari-server.user
Ambari server 用户名

java.home
java home目录
通过 -j $JAVA_HOME设置
metadata.path
stacks路径







