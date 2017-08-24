# 本表用于记录消费记录的
# id 主键
# spend 本次的花费
# cid 对应的是category表中的id（表示本次消费属于哪一类消费）
# comment 对应本次消费你想记下的文字(评论)
# date 消费的时间 日期
DROP TABLE  IF EXISTS  record;
CREATE TABLE record (
  id INT,
  spend INT,
  cid INT,
  comment VARCHAR(255),
  date DATE
  # PRIMARY KEY (id)
)ENGINE =InnoDB DEFAULT CHARSET =utf8;
# 修改表（增加主键约束）
ALTER TABLE record add CONSTRAINT pk_record_id PRIMARY KEY (id);
# 为id 添加自增长的插入数据策略
# 在新的数据添加入表中时，id会自行+1
ALTER TABLE record CHANGE id id int AUTO_INCREMENT;

# 为外键增加约束来保持数据的一致性
ALTER TABLE record ADD CONSTRAINT fk_record_category FOREIGN KEY (cid) REFERENCES category(id);
# DROP TABLE record;