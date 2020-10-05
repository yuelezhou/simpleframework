# chap6-6 弄清Resource、ResourceLoader、容器之间的微妙关系
## 容器初始化主要做的事情（主要脉络）
配置文件-（读取-ResourceLoader）->Resource -（解析）->BeanDefinition -（注册）->依赖注入
* 解析配置
* 定位与注册对象

## 源码类与接口——Resource家族
* Resource  -读操作
* EncodedResource
    * getReader()
* AbstractResource
* ServletContextResource
* ClassPathResource
    — 自动搜索WEB-INF/classes路径下的资源文件
* FileSystemResource

## 源码类与接口——ClassLoader家族



## 根据资源地址自动选择正确的Resource
强大的加载资源的方式
* 强大的加载资源的方式
* 支持自动解析Ant风格带通配符的资源地址

## Ant
路径匹配表达式，用来对URI进行匹配
* ？匹配任何单字符
* \* 匹配0或者任意数量的字符或目录
* \** 匹配0个或者更多的目录

## ResourceLoader
实现不同的Resource加载策略，按需返回特定类型的Resource

* PathMachingResourcePatternResolver
工厂模式和策略模式的区别

容器 实现了 ResourceLoader接口