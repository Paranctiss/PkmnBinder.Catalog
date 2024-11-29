package com.fl.pkmnbinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.fl")
@EnableMongoRepositories(basePackages = {"com.fl.repository.extension", "com.fl.repository.serie", "com.fl.repository.pokemon"})
public class PkmnBinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkmnBinderApplication.class, args);
    }

}
