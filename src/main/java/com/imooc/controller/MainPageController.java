package com.imooc.controller;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 19:17 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Getter
public class MainPageController {
    //todo
    private HeadLineShopCategoryCombineServcie headLineShopCategoryCombineServcie;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest request, HttpServletResponse response){
        return headLineShopCategoryCombineServcie.getMainPageInfo();
    }
}
