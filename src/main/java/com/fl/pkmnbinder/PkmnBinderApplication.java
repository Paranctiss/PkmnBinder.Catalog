package com.fl.pkmnbinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class},
        scanBasePackages = {"com.fl"}
)
@EnableMongoRepositories(basePackages = "com.fl.repository")
public class PkmnBinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkmnBinderApplication.class, args);
    }

}
