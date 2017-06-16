package com.site.service.key;

import java.util.List;

import com.site.common.framework.key.model.Key;

/**
 * 
 * 主键生成
 *
 */
public interface KeyService {

    /**
     * 查询表名及表的主键字段名
     * 
     * @param keys
     * @return 返回key集合
     */
    public List<Key> getMasterDBTableValues(List<Key> keys);

    /**
     * 查询表名及表的主键字段名
     * 
     * @param keys
     * @return 返回key集合
     */
    public List<Key> getSlaveDBTableValues(List<Key> keys);

    /**
     * @return 返回key集合(只存储表名,主键最大值)
     */
    public List<Key> getMasterDBTables();

    /**
     * @return 返回key集合(只存储表名,主键最大值)
     */
    public List<Key> getSlaveDBTables();

}