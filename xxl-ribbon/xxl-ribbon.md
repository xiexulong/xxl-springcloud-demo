#简介
Ribbon 是Spring Cloud Netflix 子项目的核心组件之一，主要给服务间调用及API网关转发提供负载均衡的功能  


RestTemplate是一个HTTP客户端，使用它我们可以方便的调用HTTP接口  

#实现负载均衡的方式：  
使用@LoadBalanced注解赋予RestTemplate负载均衡的能力  

#使用到的模块
├── xxl-register-center-eureka -- eureka注册中心
├── xxl-business-b -- 提供象CRUD接口的服务
└── xxl-ribbon -- ribbon服务调用测试服务

#Ribbon的常用配置
##全局配置
```
ribbon:
  ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
  OkToRetryOnAllOperations: true #对超时请求启用重试机制
  MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
  MaxAutoRetries: 1 # 切换实例后重试最大次数
  NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
```

#指定服务进行配置
与全局配置的区别就是ribbon节点挂在服务名称下面，如下是对ribbon-service调用xxl-business-b时的单独配置。
```
xxl-business-b:
  ribbon:
    ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
    ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
    OkToRetryOnAllOperations: true #对超时请求启用重试机制
    MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
    MaxAutoRetries: 1 # 切换实例后重试最大次数
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法

```
##Ribbon的负载均衡策略
随机、轮询（可设置重试和权重）、并发最小（可设置过滤故障和不是同一区域的实例）
```
com.netflix.loadbalancer.RandomRule：从提供服务的实例中以随机的方式；

com.netflix.loadbalancer.RoundRobinRule：以线性轮询的方式，就是维护一个计数器，从提供服务的实例中按顺序选取，第一次选第一个，第二次选第二个，以此类推，到最后一个以后再从头来过；
com.netflix.loadbalancer.RetryRule：在RoundRobinRule的基础上添加重试机制，即在指定的重试时间内，反复使用线性轮询策略来选择可用实例；
com.netflix.loadbalancer.WeightedResponseTimeRule：对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择；

com.netflix.loadbalancer.BestAvailableRule：选择并发较小的实例；
com.netflix.loadbalancer.AvailabilityFilteringRule：先过滤掉故障实例，再选择并发较小的实例；
com.netflix.loadbalancer.ZoneAwareLoadBalancer：采用双重过滤，同时过滤不是同一区域的实例和故障实例，选择并发较小的实例。
```