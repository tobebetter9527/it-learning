package com.freedom.springsix.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import com.freedom.springsix.ioc.overview.domain.User;

/**
 * @since 2023/9/29 17:57
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectProviderDemo.class);
        context.refresh();

        lookupByObjectProvider(context);
        lookupIfAvailable(context);
        lookupBySteamOps(context);

    }

    private static void lookupBySteamOps(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
        beanProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
      //  User user = beanProvider.getIfAvailable(User::createUser);
        User user = beanProvider.getIfAvailable();
        System.out.println("current user: " + user);
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }


    @Bean
    @Primary
    public String helloWorld() { // 方法名就是 Bean 名称 = "helloWorld"
        return "Hello,World";
    }

    @Bean
    public String message() {
        return "Message";
    }
}

