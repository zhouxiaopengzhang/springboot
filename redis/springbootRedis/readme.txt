springboot使用Redis步骤：
1.导入依赖
<!-- springboot实现访问redis数据库 -->
		<!-- Redis -->
		<dependency>	
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		<!-- 转换json数据格式工具 -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			</dependency>
		<dependency>
2.创建实体类Student并实现序列化接口
3.创建持久层StudentRedis类
4.在配置文件中对redis进行配置
5.编写测试代码
