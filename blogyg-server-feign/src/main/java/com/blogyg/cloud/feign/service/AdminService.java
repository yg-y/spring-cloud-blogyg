package com.blogyg.cloud.feign.service;

import com.blogyg.cloud.feign.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "blogyg-server-client", fallback = AdminServiceFallback.class)
public interface AdminService {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHi();
}
