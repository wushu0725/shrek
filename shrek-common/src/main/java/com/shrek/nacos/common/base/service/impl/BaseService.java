package com.shrek.nacos.common.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.common.base.dao.BaseMapper;
import com.shrek.nacos.common.base.service.IService;
import com.shrek.nacos.common.util.CommonUtil;
import com.shrek.nacos.common.util.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BaseService <M extends BaseMapper> implements IService{

    @Autowired
    protected M baseMapper;

    @Override
    public boolean save(JSONObject entity) {
        return SqlHelper.retBool(baseMapper.insert(entity));
    }

    @Override
    public boolean saveBatch(List<JSONObject> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(List<JSONObject> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return SqlHelper.delBool(baseMapper.deleteById(id));
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(JSONObject entity) {
        return SqlHelper.retBool(baseMapper.deleteById(entity));
    }

    @Override
    public boolean updateBatchById(List<JSONObject> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(JSONObject entity) {
        return false;
    }

    @Override
    public JSONObject getById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<JSONObject> selectPage(JSONObject queryJson) {
        return baseMapper.selectPage(queryJson);
    }

    @Override
    public Integer selectCount(JSONObject queryJson) {
        return baseMapper.selectCount(queryJson);
    }
}
