package com.boge.mapper;

import com.boge.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUserList(User user);

    User selectUserById(Integer id);

    int updateById(User user);
}
