# 8-3 
## 00：48
scope为prototype或者单例模式但是缓存还不存在Bean
prototypesCurrentlyInCreation - ThreadLocal
针对prototype的循环依赖基本无解，抛出异常

## 03：55
从当前容器中找不到指定名称的bean，此时递归去parentFactory中查找
如果parent容器依旧是AbstractBeanFactory的实例
