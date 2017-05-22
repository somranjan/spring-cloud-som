package com.som.springboot.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig extends AbstractCloudConfig{
	
	@Bean
	public CachingConnectionFactory  cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("lemur.cloudamqp.com");
		  connectionFactory.setUsername("vzpfjola");
		  connectionFactory.setPassword("fGfyADThftxx0EGbHxLEGdIj3aLs5rQW");
		  connectionFactory.setVirtualHost("vzpfjola");
		  connectionFactory.setRequestedHeartBeat(30);
		  connectionFactory.setConnectionTimeout(30000);
		  return connectionFactory;
		
	}

}
