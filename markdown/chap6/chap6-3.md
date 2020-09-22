# 击破简单容器


## FactoryBean接口
* 目的是生成Bean,getObject方法
&的作用
_____________
##　BeanFactory接口
* getBean(String name)方法

　isSingleton(String)
　isPrototype(String)
　Class<?> getType(String)
　String[] getAliases(String)

##　以BeanFactory为核心的简单容器,以ApplicationContext为核心的高级容器


###　BeanFactory中的子接口的常用接口
1. HierarchicalBeanFactory //允许工厂分层
    * getParenetFactory
    * containsLocalBean
2. ListableBeanFactory
