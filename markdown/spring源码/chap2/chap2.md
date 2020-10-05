# 2.4 Spring结构的组成
## 核心接口的引子
### 0. BeanDefinition
> * 描述了Bean的实例，以及属性值和构造器值
```
getScope()
getParentName()
isLazyInit()
isSingleton()
//明确用来使用的工厂Bean
set/getFactoryBeanName()
//明确使用的生成Bean实例的构造器方法
set/getFactoryMethodName()
```
### 1.BeanDefinitionRegistry 
> * 持有Bean Definition注册处的接口，
> * 概括了Bean Definition的注册
> * 在该接口的是实现上进行Bean Definition Reader的工作
```
//BeanDefinition的增删改查，contans操作等
registerBeanDefinition():void
removeBeanDefinition():void
getBeanDefinition():BeanDefinition
...

```

### 2. BeanFactory
> * 访问Spring bean容器的基础接口，客户视角的Bean容器，该接口被持有许多BeanDefinition的对象所实现;
> * 通过bean Definition（singleton或prototype），可以返回不同的实例;
> * 从configuration中加载bean definition
* 以BeanFactory为核心的简单容器, 以ApplicationContext为核心的高级容器
```
getBean():Object
getType():Class<?>
```

### 3. ResourceLoader
> * 负责加载 Resource的策略接口
> * 实际子接口有ApplicationContext/ResourcePatternResolver
```
getResource():Resource
```

### 4. BeanFactoryReader
> * 明确了通过资源或定位字符串加载Bean的方法
```
//传入Resource获取BeanDefinition,返回BeanDefinition的个数
loadBeanDefinitions():int
//返回ResourceLoader,对于一个特定的resource pattern，可以返回多个 Resource，例如ResourcePatternResolver 
getResourceLoader():ResourceLoader
getBeanClassLoader()
//返回一个Bean Factory
getRegistry():BeanDefinitionRegistry
```
### 5. EnvironmentCapable
> * 该接口表明，某部件含有或暴露环境的引用
> * 该接口的首要任务是，执行在（接收Bean Factory实例的）框架方法中，执行instanceof检查
```
getEnvironment()
```






## 2.4.2 核心类介绍
### 1. DefualtListableBeanFactory
#### 源码注释
* BeanDefinitionRegistry和ConfigurableListableBeanFactory接口的默认实现，一个合格的Bean factory
* 典型功能是注册所有的BeanDefinition，在本地Bean Definiton表中查找是个不昂贵的操作
* 特殊格式的Bean Definition Reader有特殊的实现类
#### 书讲解
* 整个bean加载的核心部分，是Spring注册及加载bean的默认实现
### 2. xmlBeanDefinitionReader
1. 将资源路径文件转换为Resouce文件（参与：BeanFactoryReader/ResourceLoader）
2. 将Resource文件转换文Document文件（参与：DocumentLoader）
3. 对Document进行解析，得到Element（参与：BeanDefinitionDocumentReader/BeanDefinitionParserDelegate）

# 2.5 容器的基础XmlBeanFactory
## 2.5.1 配置文件封装
通过ClassPathResouce类对配置文件进行封装
将不同来源的资源抽象成URL，通过注册不同的handler(URLStreamHandler)来处理不同来源的资源的读取逻辑，一般handler的类型使用不同前缀（协议， Protocol）来识
别，如“file：”“ http：” “jar:"

