package com.blogyg.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class BlogygServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogygServerZipkinApplication.class, args);
    }

}
