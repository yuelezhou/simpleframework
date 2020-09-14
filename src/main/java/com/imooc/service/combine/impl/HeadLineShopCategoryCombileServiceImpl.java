package com.imooc.service.combine.impl;

import com.imooc.dao.bo.HeadLine;
import com.imooc.dao.bo.ShopCategory;
import com.imooc.dao.dto.MainPageInfoDTO;
import com.imooc.dao.dto.Result;
import com.imooc.service.combine.HeadLineShopCategoryCombineServcie;
import com.imooc.service.solo.HeadLineService;
import com.imooc.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:23 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class HeadLineShopCategoryCombileServiceImpl implements HeadLineShopCategoryCombineServcie {

    private HeadLineService headlineService;

    private ShopCategoryService shopCategoryService;

    public Result<MainPageInfoDTO> getMainPageInfo() {

        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headlineService.queryHeadLine(headLineCondition,1,10);

        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition,1,100);
        //3.合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult,shopCategoryResult);
        return result;

    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
