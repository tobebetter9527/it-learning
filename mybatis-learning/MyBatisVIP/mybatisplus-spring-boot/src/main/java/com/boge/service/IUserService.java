package com.boge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boge.pojo.User;
import com.boge.pojo.UserDO;

import java.util.List;

public interface IUserService extends IService<UserDO> {
    List<User> queryX();
}
