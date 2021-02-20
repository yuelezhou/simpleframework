# 第七章讲解容器的初始化
# 进攻Refresh方法前必会知识之PostProcessor
## 容器初始化主要做的事 （主要脉络）
配置文件->(读取)->Resource ->(解析)->BeanDefinition->(注册)->依赖注入
* Abstract
ApplicationContext.refresh()

## 后置处理器PostProcessor
本身也是一种需要注册到容器里的Bean
* 其里面的方法会在特定的实际被容器调用
* 实现不改变容器或者bean核心逻辑的情况下对bean进行扩展
* 对Bean进行包装，影响其行为，修改Bean的内容

## Postprocessor的种类
大部分为容器级别的后置处理器以及Bean级别的后置处理器
### BeanDefinitionRegistryPostProcessor(容器级别)
在BeanFactoryPostProcessor检测开始前注册BeanDefinition
#### 实际编程
BeanDefinitionRegistryPostProcessor
容器初始化后，再修改BeanDefinition
#### 作用
搜索第三方框架，并加载，比如mybatis

### BeanFactoryPostProcessor(容器级别)
无


### BeanPostProcessor(Bean级别)
#### 作用
增强每一个Bean
ignorexxx 忽略增强一些Bean
无法增强@Configuration的Bean
对Bean进行包装，使其带有部分通用的能力

## 回归到Refresh方法()
PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()
* 设计模式 责任链模式


##
讲解了BeanDefinitonRegistryPostProcessor的使用,能够向容器中注册BeanDefinition


