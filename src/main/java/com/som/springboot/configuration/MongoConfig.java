package com.som.springboot.configuration;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig extends AbstractCloudConfig {

	@Bean
    public MongoDbFactory mongoDbFactory() {
        /*CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        MongoServiceInfo serviceInfo = (MongoServiceInfo) cloud.getServiceInfo("mLab");
        String serviceID = serviceInfo.getId();
        return (MongoDbFactory) cloud.getServiceConnector(serviceID, DataSource.class, null);*/
		return connectionFactory().mongoDbFactory();
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
	
	
}
