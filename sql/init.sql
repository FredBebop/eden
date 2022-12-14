drop table if exists sys_user;
create table sys_user(
  user_id           bigint(20)      not null auto_increment                  comment '用户ID',
  user_name         varchar(30)     not null                                 comment '用户账号',
  nick_name         varchar(30)     not null                                 comment '用户昵称',
  user_type         varchar(2)      default '00'                             comment '用户类型（00系统用户）',
  email             varchar(50)     default ''                               comment '用户邮箱',
  phone_number       varchar(11)     default ''                              comment '手机号码',
  sex               char(1)         default '0'                              comment '用户性别（0男 1女 2未知）',
  avatar            varchar(100)    default ''                               comment '头像地址',
  password          varchar(100)    default ''                               comment '密码',
  status            char(1)         default '0'                              comment '帐号状态（0正常 1停用）',
  del_flag          char(1)         default '0'                              comment '删除标志（0代表存在 1代表删除）',
  login_ip          varchar(50)     default ''                               comment '最后登录IP',
  login_date        datetime                                                 comment '最后登录时间',
  create_by         varchar(64)     default ''                               comment '创建者',
  create_time       timestamp       not null default current_timestamp       comment '创建时间',
  update_by         varchar(64)     default ''                               comment '更新者',
  update_time       timestamp       not null default current_timestamp on update current_timestamp     comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表' ;

drop table if exists sys_role;
create table sys_role (
  role_id           bigint(20)      not null auto_increment                                           comment '角色ID',
  role_name         varchar(30)     not null                                                          comment '角色名称',
  role_key          varchar(100)    not null                                                          comment '角色权限字符串',
  role_sort         int(4)          not null                                                          comment '显示顺序',
  data_scope        char(1)         default '1'                                                       comment '数据范围（1：全部数据权限 2：自定数据权限',
  status            char(1)         not null                                                          comment '角色状态（0正常 1停用）',
  del_flag          char(1)         default '0'                                                       comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                                                        comment '创建者',
  create_time       datetime        not null default current_timestamp                                comment '创建时间',
  update_by         varchar(64)     default ''                                                        comment '更新者',
  update_time       datetime        not null default current_timestamp on update current_timestamp    comment '更新时间',
  remark            varchar(500)    default null                                                      comment '备注',
  primary key (role_id)
) engine=innodb auto_increment=100 comment = '角色信息表';

drop table if exists sys_user_role;
create table sys_user_role (
  user_id   bigint(20) not null comment '用户ID',
  role_id   bigint(20) not null comment '角色ID',
  primary key(user_id, role_id)
) engine=innodb comment = '用户和角色关联表';

drop table if exists sys_res;
create table sys_res (
  res_id           bigint(20)      not null auto_increment    comment '资源ID',
  res_name         varchar(50)     not null                   comment '资源名称',
  parent_id        bigint(20)      default 0                  comment '父ID',
  order_num        int(4)          default 0                  comment '显示顺序',
  `path`           varchar(200)    default ''                 comment '路由地址',
  component        varchar(255)    default null               comment '组件路径',
  is_frame         int(1)          default 1                  comment '是否为外链（0是 1否）',
  res_type        char(1)          default ''                 comment '资源类型（M目录 C菜单 F按钮）',
  `visible`        char(1)         default 0                  comment '状态（0显示 1隐藏）',
  perms            varchar(100)    default null               comment '权限标识',
  icon             varchar(100)    default '#'                comment '图标',
  create_by        varchar(64)     default ''                 comment '创建者',
  create_time      datetime        not null default current_timestamp                                 comment '创建时间',
  update_by        varchar(64)     default ''                 comment '更新者',
  update_time      datetime        not null default current_timestamp on update current_timestamp     comment '更新时间',
  remark           varchar(500)    default ''                 comment '备注',
  primary key (res_id)
) engine=innodb auto_increment=2000 comment = '资源权限表';

drop table if exists sys_role_res;
create table sys_role_res (
  role_id   bigint(20) not null comment '角色ID',
  res_id   bigint(20) not null comment '资源ID',
  primary key(role_id, res_id)
) engine=innodb comment = '角色和资源关联表';