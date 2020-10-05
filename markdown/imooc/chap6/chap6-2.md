# chap6-2
## 全面掌握核心接口和类
解决了关键的问题:将对象之间的关系转而用配置来管理
* 依赖注入-依赖关系在Spring的IoC容器中管理
* 通过把对象包装在Bean中以达到管理对象和进行额外操作的目的

## Bean与BeanDefinition
Bean是Spring的一等公民
* Bean的本质是java对象,只是这个对象的生命周期由容器来管理
* 不需要为了创建Bean而在原来的java类上添加额外的限制
* 对java对象的控制方式体现在配置上

## BeanDefinition-Bean的定义
根据配置,生成用来描述Bean的BeanDefinition,常用属性:
* 作用范围scope(@Scope)
    >　Spring框架有多种作用域 @Scope()
    
      * singleton #单例模式
      * prototype #使用原型模式 ，每次使用getBean 获取prototype定义的Bean时，都产生一个Bean实例
      * request #每个http请求，使用request定义的bean 都产生一个新实例
      * session #对于每个httpsession ，使用session定义的bean 都产生一个新实例
      * globalsession #
* 懒加载lazy-init(@Lazy):决定Bean实例是否延迟加载
* 首选primary(@Primary):设置为true的bean会是优先的实现类
* factory-bean和factory-method(@Configuration和@Bean//没讲括号里的)


##　容器初始化要做的事情（主要脉络）
> 配置文件->（动作）读取->Resource->（动作）解析->BeanDefinition->（动作）注册->容器

* 解析配置
* 定位与注册对象


## 框架中类/接口的讲解
* BeanDefinition - 描述了类的实例
* AttributeAccessor - 从一个任意对象访问元数据的通用协议
* BeanMetadataElement - 返回Bean元数据的Configuration source的接口
* AbstractBeanDefinition - 实现BeanDefinition的基类（有具体方法，也有抽象方法）
    * <b>GenericBeanDefinition(主要用这个)</b>，RootBeanDefinition，ChildBeanDefinition 三个子类
    * Spring中 通过设置parent来设置实际的继承关系
    

