package org.simpleframework.inject;

import com.imooc.controller.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 19:13 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
class DependencyInjectorTest {

    @DisplayName("依赖注入doIoc")
    @Test
    public void doIocTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.imooc");
        Assertions.assertEquals(true,beanContainer.isLoaded());
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        Assertions.assertNull(mainPageController.getHeadLineShopCategoryCombineServcie());
        new DependencyInjector().doIoc();
        Assertions.assertNotNull(mainPageController.getHeadLineShopCategoryCombineServcie());
        //todo 5-11 15:00
    }

}