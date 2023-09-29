package com.freedom.springsix.bean.definition;

import com.freedom.springsix.bean.factory.DefaultUserFactory;
import com.freedom.springsix.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注册外部单例对象示例
 * @since 2023/9/29 11:32
 */
public class SingletonBeanRegistryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        UserFactory userFactory = new DefaultUserFactory();

        SingletonBeanRegistry singletonRegistry = context.getBeanFactory();
        singletonRegistry.registerSingleton("userFactory", userFactory);

        context.refresh();
        UserFactory userFactory2 = context.getBean(UserFactory.class);
        System.out.println("If it is equal: " + (userFactory2 == userFactory));

        context.close();

    }
}
