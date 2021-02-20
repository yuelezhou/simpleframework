## 9-12 裹上AspectJ的外衣
### 改进自研框架的调研
* SpringAOP1.0是由Spring自研的
* 使用起来不是很方便，需要实现各种接口，并继承指定的类
* SpringAOP2.0集成了AspectJ,复用AspectJ的语法树
### AspectJ框架
提供了完整的AOP解决方案，是AOP的Java实现版本
* 定义切面语法以及切面语法的解析机制
* 提供了强大的织入工具
AspectJ框架的织入时机：静态织入和LTW
* 编译时织入(静态)：利用ajc,将切面逻辑织入到类里生成class文件
* 编译后织入(静态)：利用ajc,修改javac编译出来的class文件
* 类加载期织入(LTW,jvm中修改字节码)：利用java agent，在类加载的时候织入切面逻辑
仅仅用到了AspectJ的切面语法，并没有使用ajc编译工具
* 避免增加用户的学习成本
* 只是默认不适用,如果想使用还是可以引入的
* 织入机制沿用自己的cglib和jdk动态代理机制
## 9-13
### 折衷方案改进框架里的AOP
使用最小的改造成本，换取尽可能大的收益---理清核心诉求
* pointcutParser
* PointcutExpression

