Github Usage
===
git status  #查看更改状态
git add -  #将更改文件放置暂存区
git commit -m '注释'   #提交文件到本地分支
git reset --hard HEAD  #如果commit出错，将回滚到add之前状态
git push origin master #将更改文件提交到远程分支，origin指定了你要push到哪个remote
其间需要输入github 文件名和密码


```
#添加一个远程分支
git remote add cloudera-master https://github.com/cloudera/hue.git


git remote -v # 列出所有远程分支名称

##回滚到之前位置
git reset d8bc236d8d622759fa5988ff32246e4c750e7503 



git checkout -b release-3.6.0-x #切换到一个新的本地分支1


git branch --all #查看所有的本地或者远程分支


git fetch origin branch-3.6 # 将 本地分支release-3.6.0-x指向远程分支 origin 的branch-3.6


git merge cloudera/master  #将本地分支（dev）与远程分支cloudera（master）进行合并

git push origin dev 将本地分支(dev) 上传到远程分支origin dev(如果远程没有dev 分支将新建)

```
###回到某一个TAG
```
git reset --soft release-3.6.0

将当前版本回退到tag release-3.6.0
```





=============================
同步 一个远程分支

git remote -v

git remote add ooyala https://github.com/ooyala/spark-jobserver.git

git remote -v


git fetch ooyala


git branch -va


git checkout master


git merge ooyala/master

git push origin master

