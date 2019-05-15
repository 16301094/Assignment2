小组成员 16301093黄镇海  16301094黄琛深  16301103谢俊
A2-report文档截图
basic requirment:restful services实现
Rate Limiting:
依赖:
	<groupId>com.google.guava</groupId>
	<artifactId>guava</artifactId>
创建AccessLimitService,
每秒发放5个令牌		RateLimiter rateLimiter = RateLimiter.create(5);
在需要限速的controller(url)处,使用accessLimitService.tryAcquire() 尝试取得令牌

实测每秒会放行六次

测试方法:编写一个并发访问的测试类

Cache:
spring boot

在UserServiceImpl 服务中,对需要缓存的返回结果 对应的函数做@Cacheable("users")注解
下次调用该方法是便可直接返回缓存的查找结果



Hateos:
<groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-hateoas</artifactId>
 
 使用linkTo(UserController.class).slash(result.getUserId()).withSelfRel();
 进行add后即可为返回结果添加self 链接
 
