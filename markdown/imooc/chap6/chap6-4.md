# chap6-4 击破简单容器(下)
## 术语补充
* 组件扫描：自动发现应用容器中需要创建的Bean
* 自动装配：自动满足Bean之间的依赖

## BeanFactory的子接口与类
* AutowireCapableBeanFactory
* ConfigurableBeanFacotory
* AbstractactAutowireCapableBeanFacotry
* ConfigurableListableBeanFacotory 集大成
* DefaultListableBeanFactory ——重点
   * beanDefinitionMap 重点变量，存储容器实例的载体
   * registryBeanDefinition
   * support包一般存放实现类

