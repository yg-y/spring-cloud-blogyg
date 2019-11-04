package com.blogyg.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BlogygServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogygServerClientApplication.class, args);
    }

}
