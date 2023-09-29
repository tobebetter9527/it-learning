package com.freedom.springsix.bean.definition;

import com.freedom.springsix.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * bean definition创建示例
 */
public class BeanDefinitonCreationDemo {

    public static void main(String[] args) {
        // 1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitonBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitonBuilder.addPropertyValue("id", 2).addPropertyValue("name", "freeman");
        AbstractBeanDefinition beanDefinition = beanDefinitonBuilder.getBeanDefinition();


        // 2.通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1).add("name", "Freeman");
        genericBeanDefinition.setPropertyValues(propertyValues);


    }
}
