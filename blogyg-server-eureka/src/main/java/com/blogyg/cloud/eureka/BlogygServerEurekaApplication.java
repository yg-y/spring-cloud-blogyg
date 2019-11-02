package com.blogyg.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BlogygServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogygServerEurekaApplication.class, args);
    }

}
