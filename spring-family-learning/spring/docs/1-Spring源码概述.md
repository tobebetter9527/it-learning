# 1. spring两大功能

- IOC，控制反转

- AOP，面向切面编程

# 2. 典型bean的生命周期（不包括销毁）

![image](.\image\1-典型bean的生命周期.png)

注意：创建bean不仅仅是反射一种方式，还有其他方式，比如通过FactoryBean接口创建。

## 2.1两个重要接口及Aware接口

![image](.\image\2-Spring的两个重要的PostProcessor接口.png)

## 2.2 创建对象过程

对象要先实例化，然后才是初始化。

- 实例化：在堆中开辟一块空间 -> 对象的属性值都是默认值

- 初始化：给属性设置值 -> 填充属性|执行初始化方法

## 2.3 bean的作用域scope

- singleton

- prototype

- request

- session

# 3. 重要接口汇总

![image](.\image\3-Spring重要接口汇总.png)
