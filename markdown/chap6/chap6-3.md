# chap6-3  击破简单容器（上）


## FactoryBean接口
* 生产单个Object的BeanFacory 内的对象要实现的接口,
* 实现这个接口的bean不能被当作一个普通的bean，getObect（）方法，返回的是它创建的Bean
* 这个接口频繁被用在框架内，例如aop。在基建类代码中比较常见
* 容器只管理FactoryBean的生命周期，而不管理它生产的Bean的生命周期，因此它生产的Bean应该实现销毁Bean的接口



_____________
##　BeanFactory接口
访问Spring bean 容器的基础接口，Bean容器的基本客户视角，
该接口被持有许多BeanDefinition的对象所实现

* &的作用，用户得到工厂本身(FactoryBeanPrefix = &)
>   如果 userFactoryBean是一个FactoryBean
    applicationContext.getBean(&userFactoryBean) 返回工厂
    applicationContext.getBean(userFactoryBean) 返回工厂创建的实例
* getBean(String name)方法
* isSingleton(String)
* isPrototype(String)
* Class<?> getType(String)
* String[] getAliases(String)

## BeanFactory的家族体系
###　以BeanFactory为核心的简单容器, 以ApplicationContext为核心的高级容器
高级容器能以配置来

###　BeanFactory中的子接口的常用接口
1. HierarchicalBeanFactory //允许容器分层,作用：让容器A/B/C 分层管理 三层架构
    * getParenetFactory
    * containsLocalBean
2. ListableBeanFactory
    
3. AutowireCapableBeanFactory //使工厂能够给实例提供自动注入的功能

