-- `mybatis-vip`.t_user definition

CREATE TABLE `t_user` (
                          `id` int NOT NULL,
                          `user_name` varchar(100) DEFAULT NULL,
                          `real_name` varchar(100) DEFAULT NULL,
                          `password` varchar(100) DEFAULT NULL,
                          `age` int DEFAULT NULL,
                          `d_id` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

INSERT INTO `mybatis-vip`.t_user
(id, user_name, real_name, password, age, d_id)
VALUES(1, 'zhangsan', '张三', '123456', 18, 1);
INSERT INTO `mybatis-vip`.t_user
(id, user_name, real_name, password, age, d_id)
VALUES(2, 'lisi', '李四', '123', 12, 2);
INSERT INTO `mybatis-vip`.t_user
(id, user_name, real_name, password, age, d_id)
VALUES(3, 'wangwu', '王五', '654', 21, 3);
