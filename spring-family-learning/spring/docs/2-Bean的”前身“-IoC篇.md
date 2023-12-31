思考：我们知道Spring是bean的容器，管理很多bean。那么Spring实例化和初始化bean之前，bean的”前身“是什么？

# 1. 什么是BeanDefinition

BeanDefinition接口的解释: 一个BeanDefinition描述一个有属性值，有构造器参数值和更多具体实现信息的bean实例。可以利用接口BeanFactoryPostProcessor内省和修改属性值和其他bean元信息。

```java
/**
 * A BeanDefinition describes a bean instance, which has property values,
 * constructor argument values, and further information supplied by
 * concrete implementations.
 *
 * <p>This is just a minimal interface: The main intention is to allow a
 * {@link BeanFactoryPostProcessor} to introspect and modify property values
 * and other bean metadata.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 19.03.2004
 * @see ConfigurableListableBeanFactory#getBeanDefinition
 * @see org.springframework.beans.factory.support.RootBeanDefinition
 * @see org.springframework.beans.factory.support.ChildBeanDefinition
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {
    // ....省略
}
```

[官网的描述](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname)：

- A package-qualified class name: typically, the actual implementation class of the bean being defined.

- Bean behavioral configuration elements, which state how the bean should behave in the container (scope, lifecycle callbacks, and so forth).

- References to other beans that are needed for the bean to do its work. These references are also called collaborators or dependencies.

- Other configuration settings to set in the newly created object — for example, the size limit of the pool or the number of connections to use in a bean that manages a connection pool.

# 2. BeanDefinition有哪些重要属性值得关注的

| 属性                       | 描述                                                                   |
| ------------------------ | -------------------------------------------------------------------- |
| class                    | 这个属性是强制性的，并且指定用来创建 bean 的 bean 类。                                    |
| name                     | 这个属性指定唯一的 bean 标识符。在基于 XML 的配置元数据中，你可以使用 ID 和/或 name 属性来指定 bean 标识符。 |
| scope                    | 这个属性指定由特定的 bean 定义创建的对象的作用域，它将会在 bean 作用域的章节中进行讨论。                   |
| constructor-arg          | 它是用来注入依赖关系的，并会在接下来的章节中进行讨论。                                          |
| properties               | 它是用来注入依赖关系的，并会在接下来的章节中进行讨论。                                          |
| autowiring mode          | 它是用来注入依赖关系的，并会在接下来的章节中进行讨论。                                          |
| lazy-initialization mode | 延迟初始化的 bean 告诉 IoC 容器在它第一次被请求时，而不是在IoC容器启动时去创建一个 bean 实例。            |
| initialization 方法        | 在 bean 的所有必需的属性被容器设置之后，调用回调方法。它将会在 bean 的生命周期章节中进行讨论。                |
| destruction 方法           | 当包含该 bean 的容器被销毁时，使用回调方法。它将会在 bean 的生命周期章节中进行讨论。                     |

# 3. BeanDefinition体系结构

![image](.\image\4-BeanDefinition体系结构.png)

- `org.springframework.core.AttributeAccessor` 接口，用于获取元数据，在实现类中通过 LinkedHashMap 集合保存元数据，例如通过 XML 的 `<meta />` 标签定义的一些元信息会保存在其中

- `org.springframework.beans.BeanMetadataElement` 接口，用于获取定义 Bean 的源对象，在实现类中通过 Object 对象保存，所谓的源对象就是定义这个 Bean 的资源（XML 标签对象或者 .class 文件资源对象）

- `org.springframework.beans.factory.config.BeanDefinition` 接口，定义一个 Bean 的元信息

- `org.springframework.beans.factory.support.AbstractBeanDefinition` 抽象类，实现 BeanDefinition 接口，包含了一个 Bean 几乎所有的元信息

- `org.springframework.beans.factory.support.GenericBeanDefinition`，继承 AbstractBeanDefinition 抽象类，多了一个 `parentName`，表示有继承关系，是一个标准 Bean 元信息对象，通过 XML 定义的 Bean 会解析成该对象

- `org.springframework.beans.factory.annotation.AnnotatedBeanDefinition` 接口，继承 BeanDefinition 接口，定义注解类的元信息，例如通过 `@Component` 注解定义的 Bean，那么注解类的元信息会包含编译后的 .class 文件的所有信息

- `org.springframework.context.annotation.ScannedGenericBeanDefinition`，继承 GenericBeanDefinition，实现 AnnotatedBeanDefinition 接口，多了一个 AnnotationMetadata 注解类元信息对象，例如通过 `@Component` 注解定义的 Bean 会解析成该对象

- `org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition`，继承 GenericBeanDefinition，实现 AnnotatedBeanDefinition 接口，和 ScannedGenericBeanDefinition 类似，通过 `@Import` 导入的 `Configuration Class` 会解析成该对象

- `org.springframework.beans.factory.support.RootBeanDefinition`，继承 AbstractBeanDefinition 抽象类，表示合并后的 BeanDefinition 对象。在 Spring BeanFactory 初始化 Bean 的前阶段，会根据 BeanDefinition 生成一个 RootBeanDefinition（具有层次性则会进行合并），用于后续实例化和初始化

- `org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$ConfigurationClassBeanDefinition` 私有静态类，继承 RootBeanDefinition，实现了 AnnotatedBeanDefinition 接口，和 AnnotatedGenericBeanDefinition 类似，没有继承关系，通过 `@Bean` 定义的方法会解析成该对象

- `org.springframework.beans.factory.config.BeanDefinitionHolder`，包含 BeanDefinition、Bean 的名称以及别名（支持多个）

总结一下，BeanDefinition 接口的实现类主要根据 Bean 的定义方式进行区分，如下：

1. XML 定义 Bean >>>>> GenericBeanDefinition

2. @Component 以及派生注解定义 Bean >>>>> ScannedGenericBeanDefinition

3. 借助于 @Import 导入 Bean >>>>> AnnotatedGenericBeanDefinition

4. @Bean 定义的方法 >>>>> ConfigurationClassBeanDefinition

5. 在 Spring BeanFactory 初始化 Bean 的前阶段，会根据 BeanDefinition 生成一个合并后的 RootBeanDefinition 对象

# 4.BeanDefinition的构建
- 通过BeanDefinitonBuilder
- 通过AbstractBeanDefinition以及派生类
```java
public class BeanDefinitionCreationDemo {
  public static void main(String[] args) {
    // 1.通过 BeanDefinitionBuilder 构建
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
    // 通过属性设置
    beanDefinitionBuilder
        .addPropertyValue("id", 1)
        .addPropertyValue("name", "小马哥");
    // 获取 BeanDefinition 实例
    BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    // BeanDefinition 并非 Bean 终态，可以自定义修改

    // 2. 通过 AbstractBeanDefinition 以及派生类
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    // 设置 Bean 类型
    genericBeanDefinition.setBeanClass(User.class);
    // 通过 MutablePropertyValues 批量操作属性
    MutablePropertyValues propertyValues = new MutablePropertyValues();
    propertyValues
        .add("id", 1)
        .add("name", "小马哥");
    // 通过 set MutablePropertyValues 批量操作属性
    genericBeanDefinition.setPropertyValues(propertyValues);
  }
}
```










# 参考资料：

- [Spring Bean 定义_w3cschool](https://www.w3cschool.cn/wkspring/8kei1icc.html)

- [Bean Overview :: Spring Framework](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname)

- [死磕Spring之IoC篇 - Bean 的“前身” - 月圆吖 - 博客园](https://www.cnblogs.com/lifullmoon/p/14434009.html)
