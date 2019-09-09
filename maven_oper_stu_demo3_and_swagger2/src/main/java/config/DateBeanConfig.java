package config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateBeanConfig {
	@Bean
	public Date getDateBean(){
		return new Date();
	}
}
