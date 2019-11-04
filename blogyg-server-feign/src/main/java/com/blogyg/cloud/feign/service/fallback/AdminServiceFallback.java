package com.blogyg.cloud.feign.service.fallback;

import com.blogyg.cloud.feign.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String sayHi() {
        return "http hi error, into fallback";
    }
}
