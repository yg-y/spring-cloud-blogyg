package com.blogyg.cloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    public String sayHi() {
        return restTemplate.getForObject("http://BLOGYG-SERVER-CLIENT/hi", String.class);
    }
}
