package com.shrek.nacos.codegen.controller;

import com.alibaba.fastjson.JSONObject;
import com.shrek.nacos.codegen.service.CodeGenService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CodeGenController {


    @Autowired
    private CodeGenService codeGenService;

    /**
     * 生成代码
     */
    @GetMapping("/code")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tablename = request.getParameter("tablename");
        System.out.println(tablename);
        byte[] data = codeGenService.generatorCode(tablename);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"shrek-admin-code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());

    }


    /**
     * 生成代码
     */
    @GetMapping("/queryAllTable")
    public JSONObject queryAllTable(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return codeGenService.queryAllTable();
    }
}
