package com.imooc.service.solo;

import com.imooc.dao.bo.ShopCategory;
import com.imooc.dao.dto.Result;

import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:11 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategory(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
    //todo 删查改
}
