package com.boge.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class UserDO implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    private String userName;

    private String password;

    private String realName;

    private Integer age;

    private Integer dId;

}
