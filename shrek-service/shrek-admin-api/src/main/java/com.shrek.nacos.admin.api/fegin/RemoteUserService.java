package com.shrek.nacos.admin.api.fegin;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.api.fegin.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "shrek-admin", fallbackFactory = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {

    @PostMapping(value = "/user/login")
    JSONObject login(@RequestBody JSONObject jsonObject);
}
