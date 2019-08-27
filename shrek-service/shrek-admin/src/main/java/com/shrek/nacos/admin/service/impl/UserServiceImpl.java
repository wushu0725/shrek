package com.shrek.nacos.admin.service.impl;


import com.shrek.nacos.admin.dao.mysql.UserDao;
import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.admin.service.UserService;

import java.util.List;

import com.shrek.nacos.common.util.CommonUtil;
import com.shrek.nacos.common.util.constants.ErrorEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${comments}
 *
 * @author Wushu
 * @email 156810150@qq.com
 * @date 2019-08-21 10:51:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public JSONObject update(JSONObject jsonObject){
        userDao.update(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject insert(JSONObject jsonObject){
        userDao.insert(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject list(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count = userDao.count(jsonObject);
        List<JSONObject> list = userDao.listByPage(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject delete (Long id){
        userDao.delete(id);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject login(JSONObject jsonObject) {
        String username = jsonObject.getString("username");

        String returnPassword = userDao.login(username);
        //加密匹配之后做
        if(StringUtils.isNotBlank(returnPassword)){
            return CommonUtil.successJson(returnPassword);
        }

        //用户名密码失败 直接返回400
        return CommonUtil.errorJson(ErrorEnum.E_400);
    }
}