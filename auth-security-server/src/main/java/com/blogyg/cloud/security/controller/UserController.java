package com.blogyg.cloud.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * UserController
 *
 * @author young
 * @date 2020/1/2
 * @desc
 **/
@AllArgsConstructor
@RestController
public class UserController {

    private final TokenStore tokenStore;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /**
     * 退出token
     *
     * @param authHeader Authorization
     */
    @GetMapping("/removeToken")
    public Object logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StringUtils.hasText(authHeader)) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            if (accessToken == null || StringUtils.isEmpty(accessToken.getValue())) {
                return "not token";
            }
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                //清除认证
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            tokenStore.removeAccessToken(accessToken);
        }
        return "success";
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
