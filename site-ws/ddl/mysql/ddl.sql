create table t_auth_permission
(
   id                   varchar(32) not null comment '主健',
   menu_name            varchar(50) comment '菜单名',
   menu_code            varchar(50) not null comment '菜单编号',
   url                  varchar(32) comment '菜单URL',
   lev                  bigint(10) comment '菜单级别',
   sort                 bigint(10) comment '菜单排序',
   parent_id            varchar(32) comment '父菜单ID',
   business_system      varchar(20) comment '所属系统',
   remark               varchar(200) comment '备注',
   create_time          datetime not null comment '创建时间',
   update_time          datetime comment '更新时间',
   is_del               bigint(10) not null default 0 comment '是否删除:1=已删除;0=未删除',
   primary key (id)
) comment '菜单许可表';

create table t_auth_role
(
   id                   varchar(32) not null comment '主健',
   role_name            varchar(50) comment '角色名',
   role_code            varchar(50) not null comment '角色编码',
   business_system      varchar(20) comment '所属系统',
   parent_id            varchar(32) not null comment '父角色ID',
   remark               varchar(200) comment '备注',
   create_time          datetime not null comment '创建时间',
   update_time          datetime comment '更新时间',
   is_del               bigint(10) not null default 0 comment '是否删除:1=已删除;0=未删除',
   primary key (id)
) comment '角色表';

create table t_auth_role_permission
(
   id                   varchar(32) not null comment '主健',
   role_id              varchar(32) not null comment '角色ID',
   permission_id        varchar(32) comment '菜单ID',
   business_system      varchar(20) comment '所属系统',
   create_time          datetime not null comment '创建时间',
   update_time          datetime comment '更新时间',
   is_del               bigint(10) not null default 0 comment '是否删除:1=已删除;0=未删除',
   primary key (id)
) comment '角色菜单许可关系表';

create table t_auth_user
(
   id                   varchar(32) not null comment '主健',
   email                varchar(50) comment '邮箱地址',
   login_name           varchar(50) not null comment '登录账号',
   user_name            varchar(50) not null comment '用户名',
   pass_word            varchar(50) not null comment '登录密码',
   salt                 varchar(50) comment 'salt值',
   create_time          datetime not null comment '创建时间',
   update_time          datetime comment '更新时间',
   is_del               bigint(10) not null default 0 comment '是否删除:1=已删除;0=未删除',
   primary key (id)
) comment '后台用户表';

create table t_auth_user_role
(
   id                   varchar(32) not null comment '主健',
   role_id              varchar(32) comment '角色ID',
   user_id              varchar(32) not null comment '用户ID',
   create_time          datetime not null comment '创建时间',
   update_time          datetime comment '更新时间',
   is_del               bigint(10) not null default 0 comment '是否删除:1=已删除;0=未删除',
   primary key (id)
) comment '用户角色关系表';
