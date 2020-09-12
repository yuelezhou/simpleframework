## 实现容器
* 保存Class对象及其实例的载体
* 容器加载
* 容器的操作方式

## 实现容器的加载
#### 实现思路
* 配置的管理与获取
* 获取指定范围内的Class对象
* 依据配置提取Class对象，连同实例一并存入容器


## 实现容器的操作方式
#### 涉及到容器的增删改查
* 增加、删除操作
* 根据Class获取对应实例
* 获取所有的Class和实例
* 通过注解来获取被注解标注的Class
* 超过超类获取对应的子类Class
* 获取容器载体保存Class的数量

## Spring框架有多种作用域
@Scope()
* singleton #
* prototype #使用原型模式 ，每次使用getBean 获取prototype定义的Bean时，都产生一个Bean实例
* request #每个http请求，使用request定义的bean 都产生一个新实例
* session #对于每个httpsession ，使用session定义的bean 都产生一个新实例
* globalsession #