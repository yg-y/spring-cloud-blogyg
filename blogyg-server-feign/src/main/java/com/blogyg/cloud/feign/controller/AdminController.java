package com.blogyg.cloud.feign.controller;

import com.blogyg.cloud.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("hi")
    public String sayHi() {
        return adminService.sayHi();
    }
}
