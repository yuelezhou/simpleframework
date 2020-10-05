# chap6-5 高级容器
## 高级容器一般被成为context或上下文
* BeanFactory是Spring框架的基础设施，面向Spring本身
* ApplicationContext 面向开发者

## ApplicationContext常用容器
传统的基于XML配置的经典容器
* FileSystemXmlApplicationContext：从文件系统加载配置
* ClassPathXmlApplicationContext:从classpath加载配置
* XmlWebApplicationContext:用于Web应用程序的容器

目前比较流行的容器
* AnnotationConfigServletWebServerApplicationContext -在Springboot中
* AnnotationConfigReactiveWebServerApplicationContext -满足响应式编程，在Springboot中
* AnnotationConfigApplicationContext

## 主要学习容器的共性
refresh()大致功能——IoC容器的启动方法
 * 容器初始化、配置解析
 * BeanFactoryPostProcessor和BeanPostProcessor的注册和激活
 * 国际化配置
 * web内置同期的构造
 
 
## 模版方法模式
围绕抽象类，实现通用逻辑，定义模板结构，部分逻辑由子类实现
* 复用代码
* 反向控制，父类调用子类的操作，复合开闭原则

模式设计的方法种类
* 模版方法
* 具体方法
* 钩子方法——在特定事件或者条件发生时，由抽象类的调用方进行调用，子类可以依据实际情况实现的方法
* 抽象方法——必须让子类实现的方法




 
## 类或接口
* EnvironmentCapable /Environment 获取容器的启动参数

* ApplicationConetext的子接口
   * ConfigurableApplicationContext:继承liftcycle
   * AbstractApplicationConetext -重要
        * refresh方法
   
   