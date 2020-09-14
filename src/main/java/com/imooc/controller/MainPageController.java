package com.imooc.controller;

import com.imooc.dao.dto.MainPageInfoDTO;
import com.imooc.dao.dto.Result;
import com.imooc.service.combine.HeadLineShopCategoryCombineServcie;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
