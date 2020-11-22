# doGetBean之populateBean
## 吃掉populateBean方法
* populateBean方法调用很深
* 千万不要恋战，只需要大致了解里面做的事情即可
* 战略上要掌握脉络，带着问题去理解细节

## 站在设计者的角度设计populateBean
* 调用Bean的Setter方法实例去给Bean设置上属性值
* 变量类型的转换，同时还要考虑处理集合类型的情况
* 处理显示自动装配的逻辑（autowire = byName/byType）
