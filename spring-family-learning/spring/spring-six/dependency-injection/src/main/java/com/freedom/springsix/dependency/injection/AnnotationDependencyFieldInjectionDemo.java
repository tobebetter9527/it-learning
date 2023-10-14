package com.freedom.springsix.dependency.injection;

import com.freedom.springsix.ioc.overview.domain.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于java注解的依赖字段注入示例
 *
 * @since 2023/10/14 10:34
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        context.refresh();

        AnnotationDependencyFieldInjectionDemo bean = context.getBean(AnnotationDependencyFieldInjectionDemo.class);
        UserHolder userHolder1 = bean.userHolder;
        UserHolder userHolder2 = bean.userHolder2;
        System.out.println(userHolder1);
        System.out.println(userHolder2);
        System.out.println(userHolder1 == userHolder2);

        context.close();

    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
