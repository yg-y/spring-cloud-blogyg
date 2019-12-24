# mysql 主从同步配置
- master 主数据库
```text
    Dockerfile  mysql镜像
    my.cnf      mysql配置文件
```
- slave 从数据库
```text
    Dockerfile  mysql镜像
    my.cnf      mysql配置文件
```
- docker-compose-mysql.yml docker-compose配置文件
```text
//启动master及slave两个mysql实例
docker-compose -f docker-compose-mysql.yml up -d

//进入mysql master 容器
docker exec -it xxxxxxxx /bin/bash

//进入mysql控制台
mysql -u root -p

//显示master主数据库信息
show master status

//记录 File Position两列，例如：
File                        |   Position
replicas-mysql-bin.000003   |   753

```
```text
//切换到mysql slave容器,进入mysql控制台，步骤如上↑
//停止slave
stop slave

//连接主库 master
CHANGE MASTER TO 
 MASTER_HOST='主库ip地址', 
 MASTER_USER='root', 
 MASTER_PASSWORD='主库密码', 
 MASTER_LOG_FILE='主库File，如：replicas-mysql-bin.000003', 
 MASTER_LOG_POS=主库Position，如：753;
 
//启动slave
start slave

//查看从库状态，若File,Position与主库对应上，则主从同步配置完成
show slave status

//主库执行创建表，会同步到从库
```
