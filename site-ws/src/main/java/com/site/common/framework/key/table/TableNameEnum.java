package com.site.common.framework.key.table;

public interface TableNameEnum {
    
    public enum Master implements TableNameEnum {
        /*表名请大写*/
        T_AUTH_PERMISSION,
        T_AUTH_ROLE,
        T_AUTH_ROLE_PERMISSION,
        T_AUTH_USER,
        T_AUTH_USER_ROLE,
        T_NEWS,
    }
    
    public enum Slave implements TableNameEnum {
        /*表名请大写*/
        T_AUTH_PERMISSION,
        T_AUTH_ROLE,
        T_AUTH_ROLE_PERMISSION,
        T_AUTH_USER,
        T_AUTH_USER_ROLE,
        T_NEWS,
    }

}
