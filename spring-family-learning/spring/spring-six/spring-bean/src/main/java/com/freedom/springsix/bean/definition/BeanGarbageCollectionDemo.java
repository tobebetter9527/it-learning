package com.freedom.springsix.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @since 2023/9/29 14:29
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanInitializationDemo.class);
        context.refresh();
        context.close();

        Thread.sleep(3000L);
        System.gc();
        Thread.sleep(3000L);

    }
}
