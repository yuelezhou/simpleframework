# BeanDefinition的注册
## 源码讲解
### 00：00 本小节要讲解的重点
* BeanDefinitionReaderUtils 的 registerBeanDefinition(）

### 00：44 
* BeanDefinitionRegistry讲解

### 1：55 
* DefaultListableBeanFactory实现了BeanDefinitionRegistry接口
* <String DeanDefinition> beanDefinitionMap concurrentHashMap

### 3:38
AbstractBeanDefinitionReader 的 构造方法 需要一个 BeanDefinitionRegistry

### 4：33 本小节要讲解的重点
* BeanDefinitionReaderUtils 的 registerBeanDefinition(）
* 委派模式，方法的参数为一个实例，在方法中再调用实例的方法

### 5：33 
* DefaultListableBeanFactory 的 registerBeanDefinition()

### 10:57
* DefaultListableBeanFactory 的 resetBeanDefinition()