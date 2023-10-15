## 8.2 BeanFactoryPostProcessor 与





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

优点：

- 轻量级IoC容器，便于快速开发和发布
- 面向切面编程：AOP，可以对方法增强，将业务逻辑和非业务逻辑代码分离
- 低代码侵入性，提供丰富灵活的扩展点
- 集成主流框架：Spring没有闭门造车，而是保持开放性
- 事务管理：

缺点：

- Spring体系比较复杂，有一定学习成本
- 封装的太好，以至于离开Spring就不知道怎么开发了

# 2.Spring IoC

## 2.1 什么是IoC

IoC，Inversion of Control，控制反转，类似好莱坞原则，“不要call我们，我们call你”，主要有依赖查找和依赖注入两种实现方式。

个人简单理解：比如有A和B两个Service，A需要调用B的服务，那就需要在A的类中写new Bservice，这样耦合严重，不利维护。如果有IoC容器，可以通过IoC容器将B服务注入A中，这样耦合不严重，维护简便。

## 2.2 依赖查找和依赖注入的区别

- 依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准的API实现。
- 依赖注入则是手动或自动依赖绑定方式，无需依赖特定的容器和API

| 类型   | 依赖处理 | 实现便利性 | 代码侵入性  | API 依赖性   | 可读性 |
| ---- | ---- | ----- | ------ | --------- | --- |
| 依赖查找 | 主动获取 | 相对繁琐  | 侵入业务逻辑 | 依赖容器 API  | 良好  |
| 依赖注入 | 被动提供 | 相对便利  | 低侵入性   | 不依赖容器 API | 一般  |

## 2.3 Spring作为IoC容器的优势

- 典型的IoC管理，依赖查找和依赖注入

- AOP抽象

- 事务抽象

- 事件机制

- SPI扩展

- 强大的第三方整合

- 易测试性

- 更好的面向对象

## 2.4 BeanFactory 与 FactoryBean的区别

- BeanFactory是IoC底层容器

- FactoryBean是创建Bean的一种方式，帮助实现复杂的初始化逻辑

## 2.5 Spring IoC容器启动时做了哪些准备

IoC配置元信息读取和解析，IoC容器生命周期，Spring事件发布，国际化等

# 3. Spring bean基础

## 3.1 如何注册一个Spring bean

- 通过注册BeanDefinition

- 通过外部单例对象来注册

## 3.2 什么时Spring BeanDefinition

- BeanDefinition 是 Spring Framework 中定义 Bean 的配置元信息接口。

## 3.3 Spring容器是如何管理注册bean

比如：IoC 配置元信息读取和解析、依赖查找和注入以及 Bean 生命周期等。

# 4. 依赖查找

## 4.1 ObjectFactory 与 BeanFactory 的区别

- ObjectFactory 与 BeanFactory 均提供依赖查找的能力。

- 不过 ObjectFactory 仅关注一个或一种类型的 Bean 依赖查找，并且自身不具备依赖查找的能力，能力则由 BeanFactory 输出。

- BeanFactory 则提供了单一类型、集合类型以及层次性等多种依赖查找方式。

## 4.2 BeanFactory.getBean 操作是否线程安全?

BeanFactory.getBean 方法的执行是线程安全的，操作过程中会增加互
斥锁.

# 5. 依赖注入

## 5.1 有多少种依赖注入的方式?

- 构造器注入

- Setter 注入

- 字段注入

- 方法注入

- 接口回调注入

## 5.2 你偏好构造器注入还是 Setter 注入?

两种依赖注入的方式均可使用，如果是必须依赖的话，那么推荐使用构造器注入，Setter 注入用于可选依赖。



# 6. 依赖注入来源

## 6.1 注入和查找的依赖来源是否相同?

否，依赖查找的来源仅限于 Spring BeanDefinition 以及单例对象，而依赖注入的来源还包括 Resolvable Dependency 以及@Value 所标注的外部化配置.

## 6.2 单例对象能在 IoC 容器启动后注册吗?

可以的，单例对象的注册与 BeanDefinition 不同，BeanDefinition会被 ConfigurableListableBeanFactory#freezeConfiguration() 方法影响，从而冻结注册，单例对象则没有这个限制。

## 6.3 Spring 依赖注入的来源有哪些?

- Spring BeanDefinition

- 单例对象  

- Resolvable Dependency

- @Value 外部化配置



# 7. spring bean作用域

## 7.1 Spring 內建的 Bean 作用域有几种?

singleton、prototype、request、session、application 以及websocket

## 7.2 singleton Bean 是否在一个应用是唯一的

否则，singleton bean 仅在当前 Spring IoC 容器(BeanFactory)中是单例对象。

## 7. 3 “application”Bean 是否被其他方案替代

可以的，实际上，“application” Bean 与“singleton” Bean 没有本质区别

# 8. spring bean生命周期

## 8.1 BeanPostProcessor 的使用场景有哪些?

BeanPostProcessor 提供 Spring Bean 初始化前和初始化后的生命周期回调，分别对应 postProcessBeforeInitialization 以及postProcessAfterInitialization 方法，允许对关心的 Bean 进行扩展，甚至是替换。



加分项:其中，ApplicationContext 相关的 Aware 回调也是基于BeanPostProcessor 实现，即 ApplicationContextAwareProcessor

## 8.2 BeanFactoryPostProcessor 与

BeanFactoryPostProcessor 是 Spring BeanFactory(实际为ConfigurableListableBeanFactory) 的后置处理器，用于扩展BeanFactory，或通过 BeanFactory 进行依赖查找和依赖注入。



加分项:BeanFactoryPostProcessor 必须有 Spring ApplicationContext
执行，BeanFactory 无法与其直接交互。



而 BeanPostProcessor 则直接与BeanFactory 关联，属于 N 对 1 的关系。



另外的回答：

BeanFactoryPostProcessor 和 BeanPostProcessor 都是服务于 bean 的生命周期中的，只是使用场景和作用略有不同。**BeanFactoryPostProcessor 作用于 bean 实例化之前，读取配置元数据，并且可以修改；而 BeanPostProcessor 作用于 bean 的实例化过程中，然后可以改变 bean 实例（例如从配置元数据创建的对象）。**



## 8.3 BeanFactory 是怎样处理 Bean 生命周期?

BeanFactory 的默认实现为 DefaultListableBeanFactory，其中 Bean生命周期与方法映射如下:

- BeanDefinition 注册阶段 - registerBeanDefinition

- BeanDefinition 合并阶段 - getMergedBeanDefinition

- Bean 实例化前阶段 - resolveBeforeInstantiation

- Bean 实例化阶段 - createBeanInstance

- Bean 实例化后阶段 - populateBean

- Bean 属性赋值前阶段 - populateBean

- Bean 属性赋值阶段 - populateBean

- Bean Aware 接口回调阶段 - initializeBean

- Bean 初始化前阶段 - initializeBean

- Bean 初始化阶段 - initializeBean

- Bean 初始化后阶段 - initializeBean

- Bean 初始化完成阶段 - preInstantiateSingletons

- Bean 销毁前阶段 - destroyBean

- Bean 销毁阶段 - destroyBean



## 
