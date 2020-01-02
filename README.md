# spring cloud demo

### blogyg-server-eureka
> 服务注册及发现模块
### blogyg-server-client
> 服务提供者
### blogyg-server-ribbon | blogyg-server-feign
> 服务消费者/负载均衡
### blogyg-server-zuul | blogyg-server-gateway
> 网关
```text
网关配置涉及熔断、限流、负载、请求过滤拦截、路由匹配
1.熔断降级：在分布式系统中，网关作为流量的入口，大量请求进入网关，向后端远程系统或服务发起调用，后端服务不可避免的会产生调用失败（超时或者异常），失败时不能让请求堆积在网关上，需要快速失败并返回回去，这就需要在网关上做熔断、降级操作。
2.限流：网关上有大量请求，对指定服务进行限流，可以很大程度上提高服务的可用性与稳定性，限流的目的是通过对并发访问/请求进行限速，或对一个时间窗口内的请求进行限速来保护系统。一旦达到限制速率则可以拒绝服务、排队或等待、降级。

gateway：    
    支持WebSocket长连接

```
### blogyg-server-zipkin
> 链路追踪

### blogyg-server-monitor
> 服务监控 spring-boot-admin
```
支持日志实时监控
```
---
## Spring Cloud Security Oauth2 Demo
- 只整合了gateway网关，zuul不做整合
### auth-security-server
> 授权服务 spring security oauth2
```text
1.使用RedisTokenStore管理token
2.client_id、secret使用内存方式，写死在代码
```

### auth-security-client
> 资源服务
```text
spring security 资源服务示例
```
### auth-security-common
> 授权服务公共类，需要鉴权的服务引入这个模块即可
```text
spring security 资源鉴权公共模块配置
```
---
# 部署方式
> 使用docker push到私有镜像仓库 harbor，docker-compose部署
```text
// 去到对应的模块，如blogyg-server-eureka
cd blogyg-server-eureka

// 使用maven打包并且构建docker镜像
mvn clean package docker:build

// 登录到私有仓库,已经登录过的忽略
docker login xxxxx

//push镜像到私有仓库
docker push 构建的镜像名

//等待push完成，去到服务器执行
docker-compose -f xxx.yml up -d

```
> 基于Portainer的Docker容器管理部署更新停止等
```text
//安装Portainer docker.sock必须挂载出来，否则无法管理本地容器
docker run -d -p 9000:9000 --restart=always --name portainer -v /var/run/docker.sock:/var/run/docker.sock -v /Users/lee/dev/docker_file/portainer/data:/data docker.io/portainer/portainer

//第一次登陆需要设置账号密码

//创建账号完成后，选择模式，可以选择本地（适合单机管理）和集群（多机管理容器）模式
```
![微信图片_20191218103152.png](https://i.loli.net/2019/12/18/Jk9R1waZvxbpUT2.png)
```text
//首先配置registries仓库，上面我们使用harbor私有镜像仓库，把它配置进去

//选择registries->Custom registry 配置仓库名，连接，有认证的需要开启认证，然后填写账号密码
```
![image.png](https://i.loli.net/2019/12/18/asnPYO4TQvCpbiD.png)
```text
//之后选择Stacks->add Stacks

//将你的docker-compose文件内容复制进去，也可以通过上传等其他方式

//之后点击deploy the stack执行这个配置
```
![微信图片_20191218103521.png](https://i.loli.net/2019/12/18/spBHSQJY2ziX4jD.png)
```text
//之后就能进 stacks 里面对容器进行一系列的管理
```
