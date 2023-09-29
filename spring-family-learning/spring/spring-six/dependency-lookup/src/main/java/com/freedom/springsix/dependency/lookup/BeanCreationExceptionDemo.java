package com.freedom.springsix.dependency.lookup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @since 2023/9/29 17:42
 */
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);

        context.registerBeanDefinition("errorBean", builder.getBeanDefinition());
        context.refresh();

        context.close();


    }

    static class POJO implements InitializingBean {
        @PostConstruct
        public void init() throws Throwable {
            throw new Throwable(" init() : for purpose");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterProperties : for purposes");
        }
    }
}
