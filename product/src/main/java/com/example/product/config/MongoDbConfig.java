package com.example.product.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages ="com/example/product/repository")
public class MongoDbConfig  extends AbstractReactiveMongoConfiguration {

    @Value("${dbport")
    private String port;

    @Value("${dbname}")
    private String dbname;


    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
    @Override
    protected String getDatabaseName() {
        return dbname;
    }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        return new ReactiveMongoTemplate(reactiveMongoClient(),getDatabaseName());
    }
}
