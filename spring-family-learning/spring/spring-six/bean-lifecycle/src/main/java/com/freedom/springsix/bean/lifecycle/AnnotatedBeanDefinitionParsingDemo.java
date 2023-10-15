package com.freedom.springsix.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @since 2023/10/14 15:47
 */
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);

        int countBefore = factory.getBeanDefinitionCount();
        reader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int countAfter = factory.getBeanDefinitionCount();
        int count = countAfter - countBefore;
        System.out.println("加载的数量： " + count);

        AnnotatedBeanDefinitionParsingDemo bean = factory.getBean(AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(bean);


    }
}
