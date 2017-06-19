package com.site.service.key.impl;

import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.common.framework.datasource.DataSource;
import com.site.common.framework.datasource.DataSourceEnum;
import com.site.common.framework.key.model.Key;
import com.site.mapper.key.KeyMapper;
import com.site.service.key.KeyService;

/**
 * 
 * 主键生成
 *
 */
@Service("keyService")
public class KeyServiceImpl implements KeyService {

    @Autowired
    private KeyMapper keyMapper;

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public List<Key> getMasterDBTableValues(List<Key> keys) {
        List<Key> keyList = new ArrayList<Key>();
        try {
            keyList = keyMapper.getTableValues(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyList;
    }

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public List<Key> getMasterDBTables() {
        List<Key> keyList = new ArrayList<Key>();
        try {
            keyList = keyMapper.getTablesByMySQL();
            // keyList = keyMapper.getTablesBySQLite();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyList;
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public List<Key> getSlaveDBTableValues(List<Key> keys) {
        List<Key> keyList = new ArrayList<Key>();
        try {
            keyList = keyMapper.getTableValues(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyList;
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public List<Key> getSlaveDBTables() {
        List<Key> keyList = new ArrayList<Key>();
        try {
            keyList = keyMapper.getTablesByMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyList;
    }
}
