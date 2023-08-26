package com.boge;

import com.boge.pojo.User;
import com.boge.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisSpringBootApplicationTests {
    @Autowired
    private IUserService iUserService;

    @Test
    void contextLoads() {
        for (User user : iUserService.query()) {
            System.out.println(user);
        }
    }

}
