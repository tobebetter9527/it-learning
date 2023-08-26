package com.boge.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boge.mapper.UserMapper;
import com.boge.pojo.User;
import com.boge.pojo.UserDO;
import com.boge.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryX() {
        return userMapper.query();
    }
}
