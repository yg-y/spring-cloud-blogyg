package com.blogyg.cloud.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@EnableEurekaClient
@SpringBootApplication
public class BlogygServerClientApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(BlogygServerClientApplication.class)
                .properties("server.port=" + port).run(args);
//        SpringApplication.run(BlogygServerClientApplication.class, args);
    }

}
