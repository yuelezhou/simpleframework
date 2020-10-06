# 通过document对象解析出BeanDefinition实例
## 源码讲解

* do开头的方法表示真正做事情的方法
        * SAX XML工具
        * 
* DefaultBeanDefinitionDocumentReader
    * BeanDefinitionDocumentReader的默认实现 
    * doRegisterBeanDefinitions
        * parseBeanDefinitions
        * BeanDefinitionReaderUtils.registerBeanDefinition
    
    
    
* fire开头的方法，表示事件

## BeanDefinitionReader学习过程中的关键词
* location
* Resource
* Resourceloader
* BeanDefinitionReader
* BeanDefinitionRegistry
* DefaultListableBeanFactory

完成某项动作，发送事件，fire开头的方法
## 源码讲解

### 5：10
* XmlBeanDefinitionReader 的 registerBeanDefinitions()

### 5：17
* DefaultBeanDefinitionDocumentReader 的 registerBeanDefinitions()

### 5：19
* DefaultBeanDefinitionDocumentReader 的 doRegisterBeanDefinitions()

    ### 8：13
    * DefaultBeanDefinitionDocumentReader 的 parseBeanDefinitions()

        ### 8：24
        * DefaultBeanDefinitionDocumentReader 的 parseDefaultElement()
    
            ### 10：17
            * DefaultBeanDefinitionDocumentReader 的 processBeanDefinition()

                ### 11:22
                * BeanDefinitionHolder 是 BeanDefinition的包装类
                
                ### 11:56
                * BeanDefinitionParserDelegate 的 parseBeanDefinitionElement()

                    ### 13：08
                    * BeanDefinitionParserDelegate 的 parseBeanDefinitionElement(Element,BeanDefinition)

                        ### 13：44
                        * BeanDefinitionParserDelegate 的 createBeanDefinition(ClassName,ParentName)

                            ### 14:00     生成BeanDefinition实例
                            * BeanDefinitionReaderUtils 的 createBeanDefinition()

                            ### 15：06    设置   BeanDefinition实例 中的属性
                            * BeanDefinitionParserDelegate 的 parseBeanDefinitionElement(Element,BeanDefinition)

            ### 16：32 下一节要讲解的重点
            * BeanDefinitionReaderUtils 的 registerBeanDefinition(）
            
            