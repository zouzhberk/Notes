
1. 预安装

sudo yum install python-devel



sudo yum install asciidoc  （否则doc编译不同过，a2x）

=========================================================================================================================================================================
 Package                                        Arch                                Version                                      Repository                         Size
 =========================================================================================================================================================================
 Installing:
  asciidoc                                       noarch                              8.4.5-4.1.el6                                base                              183 k
  Installing for dependencies:
   docbook-dtds                                   noarch                              1.0-51.el6                                   base                              274 k
    docbook-style-xsl                              noarch                              1.75.2-6.el6                                 base                              2.6 M
     sgml-common                                    noarch                              0.6.3-32.el6                                 base                               43 k



2. 删除文件(remove files which need hadoop mr1)

rm /home/azureuser/workspace/hue/hue-release-3.6.0/desktop/libs/hadoop/java/src/main/java/org/apache/hadoop/mapred/ThriftJobTrackerPlugin.java

rm desktop/libs/hadoop/java/src/main/java/org/apache/hadoop/thriftfs/ThriftJobTrackerPlugin.java



 /home/azureuser/workspace/hue/hue-release-3.6.0/build/env/bin/python2.6 /home/azureuser/workspace/hue/hue-release-3.6.0/build/env/bin/easy_install -f http://archive.cloudera.com/desktop-sdk-python-packages/    -H archive.cloudera.com -qq ipdb
