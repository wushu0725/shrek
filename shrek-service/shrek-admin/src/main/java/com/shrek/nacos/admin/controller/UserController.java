package com.shrek.nacos.admin.controller;

import com.shrek.nacos.admin.service.UserService;
import com.shrek.nacos.common.util.CommonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.alibaba.fastjson.JSONObject;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @PostMapping
    public JSONObject insert(@RequestBody JSONObject requestJson) {
        return userService.insert(requestJson);
    }

    @PutMapping
    public JSONObject update(@RequestBody JSONObject requestJson) {
        return userService.update(requestJson);
    }

    @DeleteMapping
    public JSONObject delete(HttpServletRequest request) {
        return userService.delete(Long.valueOf(request.getParameter("id")));
    }

    @GetMapping
    public JSONObject list(HttpServletRequest request) {
        JSONObject jsonObject= CommonUtil.request2Json(request);
        return userService.list(jsonObject);
    }

    @PostMapping("login")
    public JSONObject login(@RequestBody JSONObject requestJson) {
        System.out.println("1111111111111111111111");
        System.out.println(requestJson.getString("username"));;
        return userService.login(requestJson);
    }

}