package com.shrek.nacos.admin.api.fegin.fallback;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.api.fegin.RemoteUserService;
import com.shrek.nacos.common.util.CommonUtil;
import com.shrek.nacos.common.util.constants.ErrorEnum;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService{


    @Override
    public JSONObject login(JSONObject jsonObject) {
        System.out.println("调用用户验证密码失败");

        log.error("调用用户验证密码失败 {}",jsonObject.toJSONString());
        return CommonUtil.errorJson(ErrorEnum.E_400);
    }
}
