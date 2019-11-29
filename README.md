# spring-cloud-demo

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
