package com.shrek.nacos.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.api.fegin.RemoteUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",userName);
        return  getUserDetails(userName,remoteUserService.login(jsonObject));
    }

    /**
     * 构建userdetails
     *
     * @param result 用户信息
     * @return
     */
    private UserDetails getUserDetails(String userName,JSONObject result) {
//        if (result == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }

//        return User.withUsername(result.getString("username")).password(result.getString("password")).authorities("USER").build();
        System.out.println("密码==="+result.getString("returnData"));
        return User.withUsername(userName).password(result.getString("returnData")).authorities("USER").build();
    }
}
