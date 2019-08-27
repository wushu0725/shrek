package com.shrek.nacos.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","admin");
        String pwd = userService.login(jsonObject).toJSONString();
        System.out.println(pwd);
    }
}
