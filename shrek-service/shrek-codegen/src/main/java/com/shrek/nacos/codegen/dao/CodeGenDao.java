package com.shrek.nacos.codegen.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;



public interface CodeGenDao {

    /**
     * 查询表信息
     *
     * @param tableName 表名称
     * @return
     */
    Map<String, String> queryTable(String tableName);

    /**
     * 查询表列信息
     *
     * @param tableName 表名称
     * @return
     */
    List<Map<String, String>> queryColumns(String tableName);


    /**
     * 查询所有表信息
     *
     * @return
     */
    List<JSONObject> queryAllTable();
}
