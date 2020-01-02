package com.blogyg.cloud.security.service;

import com.blogyg.cloud.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * UserService
 *
 * @author young
 * @date 2019/12/31
 * @desc
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = SecurityUtils.getAuthentication() != null ? SecurityUtils.getAuthentication().getName() : "";
        String redisKey = clientId + ":" + username;
        UserDetails userDetails;
        userDetails = (UserDetails) redisTemplate.opsForValue().get(redisKey);
        if (userDetails == null) {
            for (User user : getUser()) {
                if (user.getUsername().equals(username)) {
                    userDetails = user;
                }
            }
            redisTemplate.opsForValue().set(redisKey, userDetails, 12, TimeUnit.HOURS);
        }
        return userDetails;
    }

    /**
     * 用户名密码建议通过feign远程调用获取，本地测试使用固定用户
     *
     * @return
     */
    private List<User> getUser() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        List<User> userList = new ArrayList<>();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        for (String role : roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            grantedAuthorities.add(grantedAuthority);
        }
        User admin = new User("admin", password, grantedAuthorities);
        userList.add(admin);
        User user = new User("user", password, grantedAuthorities);
        userList.add(user);
        return userList;
    }

}
