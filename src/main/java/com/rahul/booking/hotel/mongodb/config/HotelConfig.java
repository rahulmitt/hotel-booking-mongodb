package com.rahul.booking.hotel.mongodb.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
public class HotelConfig {

    @Autowired
    Environment environment;

    @Bean
    public Properties applicationProperties(Environment environment) {
        Properties properties = new Properties();
        //TODO: populate properties by iterating over all the properties in the environment
        return properties;
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

}
