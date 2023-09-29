package com.freedom.springsix.bean.definition;

import com.freedom.springsix.bean.factory.DefaultUserFactory;
import com.freedom.springsix.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * bean初始化示例
 * @since 2023/9/29 13:00
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationDemo.class);
        System.out.println("start context");
        UserFactory bean = context.getBean(UserFactory.class);
        System.out.println(bean);
        System.out.println("stop context");

        context.close();
        System.out.println("close context");

    }

   @Lazy(value = false)
    @Bean(initMethod = "initUserFactory" , destroyMethod = "doDestroy")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
