package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/*
 * 该类的模板网址https://blog.csdn.net/elvishehai/article/details/78543060
 * 其实这个配置类，只要了解具体能配置哪些东西就好了，毕竟这个东西配置一次之后就不用再动了。 特别要注意的是里面配置了api文
 * 件也就是controller包的路径，不然生成的文档扫描不到接口。
 * 用@Configuration注解该类，等价于xml中配置beans;用@Bean标注方法等价于xml中配置bean
 */
/*
 * Docket对象主要包括三方面的信息：
 * 整个API的描述信息，即ApiInfo对象包括的信息，这部分信息会在页面上显示
 * 指定生成API文档的包名。
 * 指定生成API的路径。按路径生成API可支持4种模式（任何路径都生成、任何路径都不生成、正则匹配、ant匹配模式）
 */
/*创建swagger config的配置文件*/
@Configuration
public class SwaggerConfig {
	/*
	 * 1个Docket的bean对象代表一个api分组，
	 */
	@Bean(value="api1",name="api1")
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("api1")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.mymaven.maven_oper_stu_demo3.controller"))
				.paths(PathSelectors.regex("/api.*")).build();	//该正则表达式会匹配到/api2,因此api2分组也会在api1分组下出现
	}
	@Bean(value="api2",name="api2")
	public Docket createRestApi2(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("ap2")	//将api2改为了ap2
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.mymaven.maven_oper_stu_demo3.controller2"))
				.paths(PathSelectors.regex("/ap2.*")).build();
	}
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().version("1.0")
				.description("the part is apiInfo descript")
				.title("the part is apiInfo tittle")
				.build();		
	}
}
