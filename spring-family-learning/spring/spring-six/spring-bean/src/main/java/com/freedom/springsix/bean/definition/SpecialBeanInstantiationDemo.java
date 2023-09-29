package com.freedom.springsix.bean.definition;

import com.freedom.springsix.bean.factory.DefaultUserFactory;
import com.freedom.springsix.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @since 2023/9/29 14:39
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory beanFactory =  context.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);

        demoServiceLoader();

        DefaultUserFactory bean = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(bean.createUser());


    }

    private static void demoServiceLoader() {
        ServiceLoader<UserFactory> loader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(loader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
