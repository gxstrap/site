package com.site.mapper.key;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.site.common.framework.key.model.Key;

@Repository
public interface KeyMapper {

    /**
     * @return 返回key集合
     */
    List<Key> getTableValues(List<Key> keys);

    /**
     * @return 返回key集合(只存储表名)
     */
    public List<Key> getTablesByOracle();
    
    /**
     * @return 返回key集合(只存储表名)
     */
    public List<Key> getTablesByMySQL();
    
    /**
     * @return 返回key集合(只存储表名)
     */
    public List<Key> getTablesBySQLite();

}
