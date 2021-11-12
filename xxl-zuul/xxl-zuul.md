#简介
zuul作为微服务架构中的API网关使用，支持动态路由与过滤功能
  
实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能。

#实现关键
在启动类上添加@EnableZuulProxy注解来启用Zuul的API网关功能

#查看路由信息
http://localhost:8801/actuator/routes查看简单路由信息  
访问http://localhost:8801/actuator/routes/details查看详细路由信息  


#过滤器类型
```
pre：在请求被路由到目标服务前执行，比如权限校验、打印日志等功能；
routing：在请求被路由到目标服务时执行，这是使用Apache HttpClient或Netflix Ribbon构建和发送原始HTTP请求的地方；
post：在请求被路由到目标服务后执行，比如给目标服务的响应添加头信息，收集统计数据等功能；
error：请求在其他阶段发生错误时执行。
```
#Ribbon和Hystrix的支持
由于Zuul自动集成了Ribbon和Hystrix，所以Zuul天生就有负载均衡和服务容错能力，我们可以通过Ribbon和Hystrix的配置来配置Zuul中的相应功能。  

```
hystrix:
  command: #用于控制HystrixCommand的行为
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 1000 #配置HystrixCommand执行的超时时间，执行超过该时间会进行服务降级处理


ribbon: #全局配置
  ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）

```