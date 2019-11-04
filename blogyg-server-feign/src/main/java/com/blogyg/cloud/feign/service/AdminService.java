package com.blogyg.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "blogyg-server-client")
@Service
public interface AdminService {

    @RequestMapping(value = "hi")
    String sayHi();
}
