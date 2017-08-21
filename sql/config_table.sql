
# 配置信息表
# 用于保存每个月的预算和mysql的安装路径（用于备份和还原）

# id 主键
# key_ 配置信息以键值对的形式
# value 配置信息的值
DROP TABLE  IF EXISTS  config;
CREATE TABLE config(
  id int,
  key_ VARCHAR(255),
  value VARCHAR(255)
  #PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

# 增加主键约束
ALTER TABLE config ADD CONSTRAINT pk_config_id PRIMARY KEY (id);
# 为id 添加自增长的插入数据策略
# 在新的数据添加入表中时，id会自行+1
ALTER TABLE config CHANGE id id int AUTO_INCREMENT;