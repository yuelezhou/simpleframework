# 通过document对象解析出BeanDefinition实例
## 源码讲解

* do开头的方法表示真正做事情的方法
        * SAX XML工具
        * 
* DefaultBeanDefinitionDocumentReader
    * BeanDefinitionDocumentReader的默认实现 
    * doRegisterBeanDefinitions
        * parseBeanDefinitions
        * BeanDefinitionReaderUtils.registerBeanDefinition
    
    
    
* fire开头的方法，表示事件

## BeanDefinitionReader学习过程中的关键词
* location
* Resource
* Resourceloader
* BeanDefinitionReader
* BeanDefinitionRegistry
* DefaultListableBeanFactory
