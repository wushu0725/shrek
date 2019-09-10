package com.shrek.nacos.auth.api.feign;


import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.auth.api.feign.fallback.RemoteAuthServiceFallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shrek-auth-server", fallbackFactory = RemoteAuthServiceFallBackImpl.class)
public interface RemoteAuthService {

    @PostMapping(value = "/oauth/token")
    public JSONObject login(@RequestParam JSONObject jsonObject);
}
