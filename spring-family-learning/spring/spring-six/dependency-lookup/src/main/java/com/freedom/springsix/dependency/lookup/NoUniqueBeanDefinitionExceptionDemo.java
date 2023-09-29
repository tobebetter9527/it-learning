package com.freedom.springsix.dependency.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @since 2023/9/29 17:53
 */
public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoUniqueBeanDefinitionExceptionDemo.class);
        context.refresh();

        try {
            context.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.err.printf(" Spring 应用上下文存在%d个 %s 类型的 Bean，具体原因：%s%n",
                    e.getNumberOfBeansFound(),
                    String.class.getName(),
                    e.getMessage());
        }

        context.close();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }

    @Bean
    public String bean3() {
        return "3";
    }
}
