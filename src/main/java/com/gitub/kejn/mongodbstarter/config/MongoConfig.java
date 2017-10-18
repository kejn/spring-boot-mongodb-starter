package com.gitub.kejn.mongodbstarter.config;

import com.gitub.kejn.mongodbstarter.model.Customer;
import com.gitub.kejn.mongodbstarter.repository.CustomerRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Bean
    public CommandLineRunner dataLoader(CustomerRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new Customer("Alice", "Smith"));
            repository.save(new Customer("Bob", "Smith"));
        };
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }

}
