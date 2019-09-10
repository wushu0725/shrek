package com.shrek.nacos.auth.api.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.api.fegin.RemoteUserService;

/**
 * @ClassName RemoteAuthServiceFallBackImpl
 * @Description TODO
 * @Author 吴署
 * @Date 2019/9/9 16:41
 * @Version 1.0
 */

public class RemoteAuthServiceFallBackImpl implements RemoteUserService{
    @Override
    public JSONObject login(JSONObject jsonObject) {
        return null;
    }
}
