package com.boge;

import com.boge.mapper.UserMapper;
import com.boge.pojo.User;
import com.boge.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisSpringBootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> query = userMapper.query();
        List<User> query2 = userMapper.query();
        System.out.println(query);
    }

}
