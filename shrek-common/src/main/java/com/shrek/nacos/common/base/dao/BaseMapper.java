/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.shrek.nacos.common.base.dao;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
 * </p>
 * <p>
 * 这个 Mapper 支持 id 泛型
 * </p>
 *
 * @author hubin
 * @since 2016-01-23
 */
public interface BaseMapper {

    /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     */
    int insert(JSONObject entity);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    int deleteById(Serializable id);

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     */
    int updateById(JSONObject entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    JSONObject selectById(Serializable id);

    /**
     * <p>
     * 查询结果
     * </p>
     *
     */
    List<JSONObject> selectList(@Param("et") JSONObject queryJson);

    /**
     * <p>
     * 根据 entity 条件，查询一条记录
     * </p>
     *
     */
    JSONObject selectOne(@Param("et") JSONObject queryJson);

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryJson 实体对象封装操作类（可以为 null）
     */
    Integer selectCount(@Param("et") JSONObject queryJson);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param queryJson         分页查询条件（可以为 RowBounds.DEFAULT）
     */
    List<JSONObject> selectPage(@Param("et") JSONObject queryJson);

}
