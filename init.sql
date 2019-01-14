create table tbl_User (
  user_id varchar(8) primary key comment '用户工号',
  user_name varchar(8) comment '用户姓名',
  sex varchar(2) comment '性别',
  department varchar(32) comment '部门(学院)',
  phone varchar(16) comment '电话',
  mail varchar(32) comment '邮箱',
  position varchar(8) comment '职称',
  major varchar(32) comment '专业',
  identity int not null default 1 comment '用户身份
                                 1普通用户 2业务员 3审核专家
                                 4领导 5系统管理员',
  is_able_login int not null default 1 comment '是否可以登录
                                                1可以登录 2不可登录'
  leader_id varchar(8) comment '业务员对应的领导的id'
) comment '用户表'
  charset = utf8;

create table tbl_ProjectCategory (
  project_category_id int primary key comment '标识id',
  project_category_name varchar(32) not null comment '项目大类的名字',
  project_category_description varchar(4096) comment '项目大类的简介
                  业务员可以选择填写简介也可以选择上传包含介绍文件的ｚｉｐ文件',
  project_category_description_address varchar(128) comment '项目大类介绍的ｚｉｐ文件',
  project_type int not null comment '项目类别 1 2 3 4对应不同项目，日后更新',
  principal_id varchar(8) not null comment '项目业务员id',
  principal_name varchar(16) not null comment '业务员姓名',
  principal_phone varchar(16) comment '业务员联系方式',
  applicant_type varchar(64) not null comment '此项目允许的申请人类别，1234对应不同学院 不同学院用|分割，日后更新',
  max_money varchar(16) comment '项目经费预算上限',
  review_leader_id varchar(8) comment '审核领导id',
  review_leader_name varchar(16) comment '审核领导名字',
  is_exist_meeting_review int not null comment '是否存在会评
                                       1存在 2不存在',
  project_application_download_address varchar(128) comment '项目申报书地址',
  application_start_time timestamp default current_timestamp comment '项目申请开始时间',
  application_end_time timestamp default current_timestamp comment '项目申请结束时间',
  project_start_time timestamp default current_timestamp comment '项目开始时间',
  project_end_time timestamp default current_timestamp comment '项目结束时间',
  is_interim_report_activated int not null default 2 comment '中期报告是否启动
                                                              1启动 2未启动 默认为2',
  interim_report_start_time timestamp default current_timestamp comment '中期报告开始时间',
  interim_report_end_time timestamp default current_timestamp comment '中期报告结束时间',
  interim_report_download_address varchar(128) comment '中期报告模板地址',
  is_concluding_report_activated int not null default 2 comment '结题报告是否启动
                                                              1启动 2未启动 默认为2',
  concluding_report_start_time timestamp default current_timestamp comment '结题报告开始时间',
  concluding_report_end_time timestamp default current_timestamp comment '结题报告结束时间',
  concluding_report_download_address varchar(128) comment '结题报告模板地址',
  statistics int not null default 0 comment '此类别的项目完结成功的项目总数 默认为0',
  is_approved int comment '项目是否通过审核
                          1通过 2未通过',
  failure_reason varchar(256) comment '申请失败的时候的失败原因'
) comment '业务员开通项目大类表'
  charset = utf8;


-- auto-generated definition
create table tbl_ProjectApplication
(
  project_application_id             int(64) auto_increment comment '标识id'
    primary key,
  project_category_id                int                                 not null comment '对应项目大类的id',
  project_name                       varchar(32)                         not null comment '项目名称',
  project_member                     varchar(128)                        null comment '项目成员,用|隔开。例如12|35中的12和35是项目成员表的project_member_id',
  project_description                varchar(256)                        not null comment '项目简介',
  user_id                            varchar(8)                          not null comment '申请人工号',
  user_name                          varchar(16)                         not null comment '申请人姓名',
  sex                                varchar(2)                          null comment '申请人性别',
  department                         varchar(32)                         null comment '申请人部门(学院)',
  phone                              varchar(16)                         null comment '电话',
  mail                               varchar(32)                         null comment '邮箱',
  position                           varchar(8)                          null comment '职称',
  major                              varchar(32)                         null comment '专业',
  project_application_upload_address varchar(128)                        null comment '项目申请书上传地址',
  is_meeting                         int                                 not null comment '是否上会 1上会 2不上会',
  meeting_review_message             varchar(256)                        null comment '会评意见',
  review_phase                       int       default 1                 not null comment '项目申请审核阶段
                            1业务员审核阶段 2评审专家审核阶段 3会评阶段
                            4领导审核阶段 5审核通过 6审核失败',
  failure_reason                     varchar(256)                        null comment '申请失败的时候的失败原因',
  application_time                   timestamp default CURRENT_TIMESTAMP not null comment '申请递交时间',
  application_deadline               timestamp default CURRENT_TIMESTAMP null,
  middle_deadline                    timestamp default CURRENT_TIMESTAMP null,
  final_deadline                     timestamp default CURRENT_TIMESTAMP null,
  project_deadline                   timestamp default CURRENT_TIMESTAMP null
)
  comment '项目申请表' charset = utf8;



create table tbl_ProjectMember (
  project_member_id int  primary key comment '标识id',
  type int not null comment '判断是修改申请表修改的member还是项目申请表的member
                            1是项目申请表 2是项目修改申请表',
  user_id varchar(8) not null comment '用户工号',
  user_name varchar(16) not null comment '用户姓名',
  sex varchar(2) comment '性别',
  department varchar(32) comment '部门(学院)',
  phone varchar(16) comment '电话',
  mail varchar(32) comment '邮箱',
  position varchar(8) comment '职称',
  major varchar(32) comment '专业'
) comment '项目成员表'
  charset = utf8;


create table tbl_ProjectProgress (
  project_progress_id int primary key comment '标识id',
  user_id varchar(8) not null comment '申请人工号',
  project_application_id int not null  comment '对应的项目id',
  interim_report_upload_address varchar(128) comment '上传中期报告文档的地址',
  interim_report_time timestamp default current_timestamp comment '中期报告上传时间',
  is_finished_interim_report int default 2 comment '是否完成中期报告
                                    1 完成 2未完成 3审核中 4审核未通过',
  interim_report_failure_reason varchar(256) comment '中期报告审核失败的原因',
  concluding_report_upload_address varchar(128) comment '上传结题报告文档的地址',
  concluding_report_time timestamp default current_timestamp comment '结题报告上传时间',
  is_finished_concluding_report int default 2 comment '是否完成结题报告
                                    1 完成 2未完成 3审核中 4审核未通过',
  concluding_report_failure_reason varchar(256) comment '结题报告审核失败的原因',
  project_process int default 1 not null comment '项目的整体进度
                            1立项 2中期报告审核阶段 3中期报告通过
                            4结题报告审核阶段 5项目完成'
) comment '项目进度表'
  charset = utf8;


create table tbl_ReviewExpert (
  review_expert_id int primary key comment '标识id',
  expert_id varchar(8) not null comment '专家id',
  expert_name varchar(16) not null comment '专家姓名',
  project_application_id int not null comment '对应项目申请书的id',
  score varchar(4) comment '专家打分',
  review_opinion varchar(256) comment '评审意见',
  final_opinion int comment '最终意见
                            1优先支持 2支持 3反对',
  is_finished int not null default 2 comment '是否完成评审 1完成 2未完成'
) comment '专家表'
  charset = utf8;


create table tbl_ProjectModificationApplication (
  project_modification_application_id int primary key comment '标识id',
  user_id varchar(8) not null comment '申请人工号',
  modification_reason varchar(256) not null comment '申请修改的理由',
  project_application_id int not null comment '对应的项目id',
  review_phase int not null default 1 comment '审核阶段
                                    1业务员审核阶段 2领导审核阶段 3通过',
  failure_reason varchar(256) comment '修改申请失败时的失败理由'
) comment '项目修改申请表'
  charset = utf8;


create table tbl_ProjectModification (
  project_modificaiton_id int primary key comment '标识id',
  project_modification_application_id int not null comment '对应项目修改申请表的申请id',
  project_application_id int not null comment '对应项目申请id',
  project_name varchar(32) comment '项目名称',
  project_member varchar(128) comment '项目成员,用|隔开。例如12|35中的12和35是项目成员表的project_member_id',
  project_description varchar(256) not null comment '项目简介',
  user_id varchar(8) not null comment '申请人工号',
  user_name varchar(16) comment '申请人姓名',
  sex varchar(2) comment '申请人性别',
  department varchar(32) comment '申请人部门(学院)',
  phone varchar(16) comment '电话',
  mail varchar(32) comment '邮箱',
  position varchar(8) comment '职称',
  major varchar(32) comment '专业',
  project_application_upload_address varchar(128) comment '项目申请书上传地址',
  failure_reason varchar(256) comment '如果失败修改审核，失败的原因',
  is_passed int not null default 2 comment '审核是否通过
                                  1通过 2审核中 3未通过',
  modification_message varchar(64) not null comment '修改部分的备注，使用int来指定修改的部分，不同数字对应不同块，之间用|连接
                        1项目名称 2项目成员 3项目简介 4申请人性别 5申请人部门(学院)
                        6电话 7邮箱 8职称 9专业 10项目申请书上传地址'
) comment '项目修改表'
  charset = utf8;


create table tbl_Notice (
  notice_id int primary key comment '标识id',
  principal_id varchar(8) not null comment '发布公告的业务员id',
  title varchar(32) not null comment '公告标题',
  content varchar(1024) not null comment '公告内容',
  publish_time timestamp default current_timestamp comment '发布公告时间'
) comment '公告表'
  charset = utf8;


create table tbl_News (
  news_id int primary key comment '标识id',
  principal_id varchar(8) not null comment '发布新闻的业务员id',
  title varchar(32) not null comment '新闻标题',
  content varchar(4096) not null comment '新闻内容',
  publish_time timestamp default current_timestamp comment '新闻发布时间'
) comment '新闻表'
  charset = utf8;