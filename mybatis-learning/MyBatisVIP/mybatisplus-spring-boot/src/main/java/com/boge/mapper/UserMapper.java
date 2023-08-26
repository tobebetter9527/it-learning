package com.boge.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.pojo.User;
import com.boge.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    List<User> query();
}
