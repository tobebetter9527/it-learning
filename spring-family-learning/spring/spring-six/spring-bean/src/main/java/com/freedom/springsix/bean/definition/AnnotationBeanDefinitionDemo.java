package com.freedom.springsix.bean.definition;

import com.freedom.springsix.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解BeanDefinition示例
 *
 * @since 2023/9/29 10:28
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationBeanDefinitionDemo.class);


        // 1.命名方式注册
        registerUserBeanDefinition(context, "mercy-user");

        // 2.非命名方式注册
        registerUserBeanDefinition(context, null);

        context.refresh();

        System.out.println("Config 类型的所有 Beans" + context.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + context.getBeansOfType(User.class));

        context.close();

    }

    private static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1L).addPropertyValue("name", "freeman");

        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }


    @Component
    public static class Config {
        @Bean(name = {"user", "freeman"})
        public User user() {
            User user = new User();
            user.setId(234L);
            user.setName("user");
            return user;
        }
    }
}
