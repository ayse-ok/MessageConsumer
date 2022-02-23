package com.example.rabbitMQ.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.example.rabbitMQ" })
public class RabbitMQConfig {
	
	@Bean
	public Jackson2JsonMessageConverter converter() {
	    return new Jackson2JsonMessageConverter();
	}
	
}
