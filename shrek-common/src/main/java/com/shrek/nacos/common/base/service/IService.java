package com.shrek.nacos.common.base.service;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 顶级 Service
 * </p>
 *
 * @author hubin
 * @since 2018-06-23
 */
public interface IService {

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    boolean save(JSONObject entity);

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     */
    default boolean saveBatch(List<JSONObject> entityList) {
        return saveBatch(entityList, 1000);
    }

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    boolean saveBatch(List<JSONObject> entityList, int batchSize);

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     */
    default boolean saveOrUpdateBatch(List<JSONObject> entityList) {
        return saveOrUpdateBatch(entityList, 1000);
    }

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(List<JSONObject> entityList, int batchSize);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    boolean removeById(Serializable id);

    /**
     * <p>
     * 根据 columnMap 条件，删除记录
     * </p>
     *
     * @param columnMap 表字段 map 对象
     */
    boolean removeByMap(Map<String, Object> columnMap);


    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    boolean removeByIds(Collection<? extends Serializable> idList);

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    boolean updateById(JSONObject entity);

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     */
    default boolean updateBatchById(List<JSONObject> entityList) {
        return updateBatchById(entityList, 1000);
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(List<JSONObject> entityList, int batchSize);

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     *
     * @param entity 实体对象
     */
    boolean saveOrUpdate(JSONObject entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    JSONObject getById(Serializable id);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param queryJson         分页查询条件（可以为 RowBounds.DEFAULT）
     */
    List<JSONObject> selectPage(JSONObject queryJson);

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryJson 实体对象封装操作类（可以为 null）
     */
    Integer selectCount(JSONObject queryJson);
}
