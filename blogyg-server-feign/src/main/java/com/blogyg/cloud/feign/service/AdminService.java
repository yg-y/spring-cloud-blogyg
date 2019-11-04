package com.blogyg.cloud.feign.service;

import com.blogyg.cloud.feign.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "blogyg-server-client", fallback = AdminServiceFallback.class)
@Service
public interface AdminService {

    @RequestMapping(value = "hi")
    String sayHi();
}
