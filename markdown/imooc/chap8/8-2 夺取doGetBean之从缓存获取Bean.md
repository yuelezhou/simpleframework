# 8-2 夺取doGetBean之从缓存获取Bean

## doGetBean

1. 尝试从缓存获取Bean
2. 循环依赖的判断
3. 递归去父容器获取Bean实例
4. 从当前容器获取BeanDefinition实例
5. 递归实例化显示依赖的Bean
6. 根据不同的Scope才用不同的策略创建Bean实例
7. 对Bean进行类型检查

## 分条讲解

### 01:02 循环依赖-使用三级缓存的原因

### 敲代码：todo

### doGetBean源码

#### 03；57

 transformedBeanName-通过三种形式获取beanName，一个是原始的beanName,一个是加了&的，一个是别名

#### 06:25

getSingleton-尝试从单例缓存集合里获取bean实例

* 在DefaultSingletonBeanRegistry文件下，负责对容器创建出来的单例进行注册
* 尝试从一级缓存（singletonObjects = new ConcurrentHashMap<>）里面获取完备的Bean
* 如果完备的单例的单例还没有创建出来，创建中的Bean的名字会被保存在singletonsCurrentlyInCreation中，因此看看是否正在创建
* 尝试给一级缓存对象枷锁，因为接下来要对缓存对象操作了
* 尝试从二级缓存earlySingletonObjects这个存储还没进行属性添加操作的Bean实例缓存中获取
* 如果还没有获取到并且第二个参数为true，为true则表示bean允许被循环引用
* 从三级缓存singletonFactories这个ObjectFactory实例的缓存里尝试获取创建此Bean的单例工厂实例，如果获取到工厂实例，调用单例工厂的getObject方法返回对象的实例，将实例放入二级缓存里，从三级缓存里移除。
  * 一级缓存：单例对象缓存池，beanName->Bean,其中存储的就是实例化，属性复制成功之后的单例对象
  * 二级缓存：早期的单例对象beanName->Bean，其中存储的是实例化后，属性未赋值的单例对象，执行了工厂方法生产出来的Bean，bean被放进去之后，那么当bean在创建过程中，就可以通过getBean方法取到
  * 三级缓存：单例工厂的缓存，beanName->ObjectFactory,添加进去的时候单例还未具备属性，用于保存beanName和创建bean的工厂之间的关系map，单例Bean在创建之初过早的暴露出去的Factory，为什么采用工厂方式，是因为有些Bean是需要被代理的，总不能把代理前的暴露出去那就毫无意义了
  * 实例只能存在三层中的某一层里

### 13:46

如果先前已经创建过单例Bean实例，并且调用的getBean方法传入的参数为空，则执行if里面的逻辑，args之所以要求为空是因为如果有args，则需要做进一步的赋值，因此无法直接返回 。

如果Bean还在创建中，则说明是循环引用

如果是普通bean，直接返回，如果是FactoryBean，则返回他的getObject

### 15：36 
getObjectForInstance - getObjectFromFactoryBean
Synthetic属性

### 17：45
getObjectFromFactoryBean ：FactoryBeanRegistrySupport.java
factoryBeanObjectCache
doGetObjectFromFactoryBean
factory.getObject

###

