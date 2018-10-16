# spring-boot-actuator

>@author Simon

​	actuator模块测试demo，项目非工程化，功能基础，仅仅为了测试监控内容，前后端传值json形式，restful接口。

##依赖模块 
druid监控 http://localhost:9999/druid/api.html
系统性能监控 http://localhost:9999/monitoring
系统健康以及自定义监控 http://localhost:8888/actuator
自定义节点获取  http://localhost:8888/actuator/person/ignored?person=mike
###springboot依赖

1. spring-boot-starter-parent
2. spring-boot-starter
3. spring-boot-starter-actuator
4. spring-boot-starter-data-jpa
5. spring-boot-starter-web
6. spring-boot-starter-test
7. spring-boot-starter-security
8. spring-context-support

###其他依赖

1. com.alibaba
2. jolokia-core
3. org.hsqldb
4. mysql-connector-java

##application.yml

```yml
#项目路径和端口
server.servlet.context-path=/ds
server.port=9999
#监控配置
management.server.port=8888
#开启全部端点
management.endpoints.web.exposure.include=*
#health
management.endpoints.web.path-mapping.health=healthcheck
management.endpoint.health.show-details=always
management.health.db.enabled=true
management.health.diskspace.enabled=true
management.health.defaults.enabled=true
#配置详情信息
info.app.encoding=UTF-8
info.app.java.source=1.8
info.app.java.target=1.8
#数据库连接
spring.datasource.url=jdbc:mysql://localhost:3306/db_ebuy?useUnicode=true&characterEncoding=utf8
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#数据库参数配置
spring.datasource.initialSize=5  
spring.datasource.minIdle=5  
spring.datasource.maxActive=20  
spring.datasource.maxWait=60000  
spring.datasource.timeBetweenEvictionRunsMillis=60000  
spring.datasource.minEvictableIdleTimeMillis=300000  
spring.datasource.validationQuery=SELECT 'x'  
spring.datasource.testWhileIdle=true  
spring.datasource.testOnBorrow=false  
spring.datasource.testOnReturn=false  
spring.datasource.poolPreparedStatements=true  
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20  
spring.datasource.filters=stat,wall,log4j  
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000  
```

### actuator 提供的端点信息

> 监控检查url：  http://localhost:8888/ + 端点


| 端点           | 描述                                                         | HTTP 方法 |
| -------------- | ------------------------------------------------------------ | --------- |
| auditevents    | 显示通用的监控信息                                           | GET       |
| beans          | 显示应用程序上下文所有的Spring bean                          | GET       |
| configprops    | 显示所有 `@ConfigurationProperties` 的配置属性列表           | GET       |
| dump           | 显示线程活动的快照                                           | GET       |
| env            | 显示应用的环境变量                                           | GET       |
| health         | 显示应用程序的健康指标，这些值由HealthIndicator的实现类提供。常见取值：`UP` / `DOWN` / `UNKNOWN` / `OUT_OF_SERVICE` | GET       |
| info           | 显示应用的信息，可使用 `info.*` 属性自定义info端点公开的数据 | GET       |
| mappings       | 显示所有的URL路径                                            | GET       |
| metrics        | 显示应用的度量标准信息                                       | GET       |
| shutdown       | 关闭应用（默认情况下不启用，如需启用，需设置`endpoints.shutdown.enabled=true`） | POST      |
| sessions       | 程序sessions的信息                                           | GET       |
| conditions     | 显示配置的条件和原因                                         | GET       |
| httptrace      | 显示http追踪信息                                             | GET       |
| loggers        | 显示修饰和配置的日志                                         | GET       |
| scheduledtasks | 显示程序中预定的任务                                         | GET       |

## 实时查看性能状态

### 访问方式

> http://localhost:8888/actuator/metrics + { name }

###性能查询

```
   "http.server.requests",
   "jvm.memory.max",
   "jdbc.connections.active",
   "jvm.gc.memory.promoted",
   "tomcat.cache.hit",
   "tomcat.cache.access",
   "jvm.memory.used",
   "jvm.gc.max.data.size",
   "jdbc.connections.max",
   "jdbc.connections.min",
   "jvm.memory.committed",
   "system.cpu.count",
   "logback.events",
   "tomcat.global.sent",
   "jvm.buffer.memory.used",
   "tomcat.sessions.created",
   "jvm.threads.daemon",
   "system.cpu.usage",
   "jvm.gc.memory.allocated",
   "tomcat.global.request.max",
   "hikaricp.connections.idle",
   "hikaricp.connections.pending",
   "tomcat.global.request",
   "tomcat.sessions.expired",
   "hikaricp.connections",
   "jvm.threads.live",
   "jvm.threads.peak",
   "tomcat.global.received",
   "hikaricp.connections.active",
   "hikaricp.connections.creation",
   "process.uptime",
   "tomcat.sessions.rejected",
   "process.cpu.usage",
   "tomcat.threads.config.max",
   "jvm.classes.loaded",
   "hikaricp.connections.max",
   "hikaricp.connections.min",
   "jvm.gc.pause",
   "jvm.classes.unloaded",
   "tomcat.global.error",
   "tomcat.sessions.active.current",
   "tomcat.sessions.alive.max",
   "jvm.gc.live.data.size",
   "tomcat.servlet.request.max",
   "hikaricp.connections.usage",
   "tomcat.threads.current",
   "tomcat.servlet.request",
   "hikaricp.connections.timeout",
   "jvm.buffer.count",
   "jvm.buffer.total.capacity",
   "tomcat.sessions.active.max",
   "hikaricp.connections.acquire",
   "tomcat.threads.busy",
   "process.start.time",
   "tomcat.servlet.error"
```

##druid实时信息监控

>Druid是Java语言中最好的数据库连接池。
>
>Druid能够提供强大的监控和扩展功能。 

###访问地址

> http://localhost:9999/ds/druid/login.html
>
> 账号：admin
>
> 密码：admin

###资源引入

```
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>druid</artifactId>
		<version>${druid-version}</version>
	</dependency>
```

##自定义监控端点

> 工程化项目需要对自身项目进行监控，本demo是对功能信息考察

###访问地址

> http://localhost:8888/actuator/metrics/get-time