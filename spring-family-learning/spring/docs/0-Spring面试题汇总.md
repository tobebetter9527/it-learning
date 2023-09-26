# 1.Spring整体

## 1.1 什么是Spring Framework
Spring Framework 是一个功能强大的 Java 应用程序框架，旨在提供高效且可扩展的开发环境。Spring是一个轻量级的IoC和AOP容器框架，可以很方便集成其他框架，简化Java应用的开发。此外还提供事务管理，对象/关系映射，jdbc等其他技术支持。

## 1.2 Spring Framework 有哪些核心模块?
- spring-core: Spring 基础 API 模块，如资源管理，泛型处理 
- spring-bean: Spring Bean 相关，如依赖查找，依赖注入 
- spring-aop : Spring AOP 处理，如动态代理，AOP 字节码提升 
- spring-context : 事件驱动、注解驱动，模块驱动等 
- spring-expression: Spring 表达式语言模块

## 1.3 Spring Framework的优点和缺点是什么？
有点：
- 轻量级IoC容器，便于快速开发和发布
- 面向切面编程：AOP，可以对方法增强，将业务逻辑和非业务逻辑代码分离
- 低代码侵入性，提供丰富灵活的扩展点
- 集成主流框架：Spring没有闭门造车，而是保持开放性
- 事务管理：

缺点：
- Spring体系比较复杂，有一定学习成本
- 封装的太好，以至于离开Spring就不知道怎么开发了