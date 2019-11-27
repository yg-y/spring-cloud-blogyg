package com.blogyg.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String sayHi() {
        return String.format("Hi，your message is : client i am from port : %s", port);
    }

    @GetMapping("timeout")
    public String timeout() {
        try {
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "timeout";
    }
}
