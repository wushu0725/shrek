package com.shrek.nacos.codegen.service;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.codegen.dao.CodeGenDao;
import com.shrek.nacos.codegen.util.GeneratorUtils;
import com.shrek.nacos.common.util.CommonUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
@Controller
public class CodeGenService {

    @Autowired
    private CodeGenDao codeGenDao;

    public Map<String, String> queryTable(String tableName) {
        return codeGenDao.queryTable(tableName);
    }

    public byte[] generatorCode(String tableName) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        List clomes = codeGenDao.queryColumns(tableName);


        Map<String, String> table = queryTable(tableName);
        //查询列信息
        List<Map<String, String>> columns = queryColumns(tableName);

        GeneratorUtils.generatorCode(table, columns, zip);

        System.out.println(clomes.size());



        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


    public List<Map<String, String>> queryColumns(String tableName) {
        return codeGenDao.queryColumns(tableName);
    }



    public JSONObject queryAllTable() {
        List<JSONObject> jsonArray = codeGenDao.queryAllTable();
        return CommonUtil.successPage(jsonArray);
    }
}
