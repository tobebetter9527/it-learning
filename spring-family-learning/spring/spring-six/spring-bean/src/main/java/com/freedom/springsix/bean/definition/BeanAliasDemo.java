package com.freedom.springsix.bean.definition;

import com.freedom.springsix.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean别名示例
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User bean = beanFactory.getBean("xiaomage-user", User.class);
        System.out.println("是否相同：" + (user == bean));

    }
}
