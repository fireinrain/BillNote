# 该表为消费分类的表
# 包含 id 主键
# name 消费的名称
DROP TABLE  IF EXISTS  category;
CREATE TABLE category(
  id INT,
  name VARCHAR(255)
  #PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

# 增加主键约束
ALTER TABLE category ADD CONSTRAINT pk_category_id PRIMARY KEY (id);
# 为id 添加自增长的插入数据策略
# 在新的数据添加入表中时，id会自行+1
ALTER TABLE category CHANGE id id int AUTO_INCREMENT;