# chap6-7 ResourceLoader的使用者-BeanDefinitionReader

## BeanDefinitionReader
利器的使用者
* 读取BeanDefinition——利用ResourceLoader或ResourcePatternResolver将配置信息，解析成BeanDefinition
* BeanDefinitionRegistry ，将BeanDefinition注册到容器

## 框架中的类和接口 BeanDefinitionReader-体系结构
* BeanDefinitionReader
    * getRegistry->BeanDefinitionRegistry
* AbstractBeanDefinitionReader
* PropertiesBeanDefinitionReader
* XmlBeanDefinitionReader
* AnnotatedBeanDefinition

## 框架源码
* XmlBeanDefinitionReader
    * loadBeanDefinition方法的实现
        * ThreadLocal resourcesCurrentlyBeingLoaded的用法
        * ThreadLocalMap 的用法
        * InputStream 与 InputSource的使用
        
    