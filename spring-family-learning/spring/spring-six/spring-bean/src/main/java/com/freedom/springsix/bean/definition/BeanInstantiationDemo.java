package com.freedom.springsix.bean.definition;

import com.freedom.springsix.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.PushbackReader;

/**
 * bean 实例化示例
 * @since 2023/9/29 12:50
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user1 = beanFactory.getBean("user-by-static-method", User.class);
        User user2 = beanFactory.getBean("user-by-instance-method", User.class);
        User user3 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        System.out.println(user1 == user2);
        System.out.println(user1 == user3);

    }
}
