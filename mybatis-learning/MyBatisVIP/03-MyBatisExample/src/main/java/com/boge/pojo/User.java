package com.boge.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7921383484808339193L;

    private Integer id;

    private String userName;

    private String password;

    private String realName;

    private  Integer age;

    private  Integer dId;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", dId=").append(dId);
        sb.append('}');
        return sb.toString();
    }
}
