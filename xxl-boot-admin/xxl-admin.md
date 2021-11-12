#1、actuator 暴露指标  
SpringBoot应用可以通过Actuator来暴露应用运行过程中的各项指标，

#2、admin 界面监控 
界面：http://localhost:9301  
关键代码
```java
@EnableAdminServer
@SpringBootApplication
public class XxlAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxlAdminApplication.class, args);
    }
}
```
 
Spring Boot Admin通过这些指标来监控SpringBoot应用，然后通过图形化界面呈现出来。

Spring Boot Admin 可以提供应用的以下监控信息：

监控应用运行过程中的概览信息；  
度量指标信息，比如JVM、Tomcat及进程信息；  
环境变量信息，比如系统属性、系统环境变量以及应用配置信息；  
查看所有创建的Bean信息；  
查看应用中的所有配置信息；  
查看应用运行日志信息；  
查看JVM信息；  
查看可以访问的Web端点；  
查看HTTP跟踪信息。  
#3、admin + 注册中心
Spring Boot Admin不仅可以监控单体应用，还可以和Spring Cloud的注册中心相结合来监控微服务应用。