package com.site.common.framework.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态数据源持有者
 */
public class DynamicDataSourceHolder {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceHolder.class);

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     * 设置数据源的对应的key
     * 
     * @param key
     *            数据源的对应的key(数据源枚举常量类中对应的key)
     */
    public static void setDataSourceKey(String key) {
        if (log.isDebugEnabled())
            log.debug(" ========= 数据源切换至:{}", key);
        threadLocal.set(key);
    }

    /**
     * 获取数据源对应的key
     * 
     * @return String 数据源对应的key
     */
    public static String getDataSourceKey() {
        return threadLocal.get();
    }
}
