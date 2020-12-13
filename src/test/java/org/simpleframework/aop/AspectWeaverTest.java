package org.simpleframework.aop;

import com.imooc.controller.MainPageController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.DependencyInjector;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:01 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AspectWeaverTest {

    @DisplayName("织入通用逻辑测试：doAop")
    @Test
    public void doAopTest(){
        //todo 9-11 有错误，代码不全？ 7分钟
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.imooc");
        new AspectWeaver(beanContainer).doAop();
        new DependencyInjector().doIoc();
        MainPageController mainPageController = (MainPageController)beanContainer.getBean(MainPageController.class);
        mainPageController.getMainPageInfo(null,null);
    }
}
