## 9-4 AOP的子民们
### AOP的子民们
* 切面 Aspect:将横切关注点逻辑进行模块化封装的实体对象
* 通知 Advice: 好比是Class里面的方法，还定义了织入逻辑的时机
* 连接点Joinpoint: 允许使用Advice的地方（非自定义）
* SpringAOP默认只支持方法级别的Joinpoint
* 切入点Pointcut:定义一系列规则对Joinpoint进行筛选
* 目标对象Target：符合Pointcut条件，要被织入横切逻辑的对象

### Advice的种类
* BeforeAdvice：在JoinPoint前被执行的Advice

* AfterAdvice：类似于finally的Advice

* AfterReturningAdvice : 在JoinPoint执行流程正常返回后被执行

* AfterThrowingAdvice: Joinpoint执行过程中抛出异常才会触发

* AroundAdvice: 在Joinpoint前和后都执行，最常用的Advice

  ![](https://md-pic-store.oss-cn-beijing.aliyuncs.com/img/211606636621_.pic.jpg)

* 用户登录名称 yuelezhou@1096316514347377.onaliyun.com
  AccessKey ID LTAI4GLCdxKis7hhCjX7qEYX
  AccessKey Secret fD75jMYQajkazyRHHK6tJZehq6XADP

### Introduction-引入型Advice
* 为目标类引入新接口，而不需要目标类做任何实现
* 使得当前目标类在使用的过程中转型成新接口对象，调用新接口的方法

### AOP是OOP里的寄生虫

aop需要oop理解自己的语意，所以不像单独使用这么灵活

- 织入:将aspect模块化的横切关注点集成到OOP里
- 织入器：完成织入过程的执行者，如ajc
- Spring AOP则会使用一组类来作为织入器以完成最终的织入操作