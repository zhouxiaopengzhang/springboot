本项目的用于实现springboot缓存技术
spring boot配置ehcache的步骤：
1.在pom.xml中配置2个依赖，添加spring-boot-starter-cache启动器，以及ehcache。
2.在resources目录下创建ehcache.xml配置文件。
3.在application.properties文件中指定ehcache的配置文件，设置spring.cache.ehcache.config=ehcache.xml。
4.在主类上添加自动配置并启动缓存的注解@EnableCaching。
5..在类上配置缓存策略（通常在service层）。

　　@CacheConfig：配置用于指定ehcache.xml文件配置的缓存策略；该注解用在类上。

　　@Cacheable：存取缓存；主要用在查找方法上。

　　@CachePut：修改缓存，如果不存在就创建；主要用在修改方法上。

　　@CacheEvict：删除缓存，当数据删除时，如果缓存还在，就必须删除；主要用在删除方法上。

　　注意：缓存的pojo类需要实现序列化

程序设计思路：通过在测试类StudentServiceTest中注入私有StudentServiceImpl类型成员变量，并定义一些增删
改查的方法测试ehcache是否配置成功。