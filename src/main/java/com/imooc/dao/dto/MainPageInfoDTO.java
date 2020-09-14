package com.imooc.dao.dto;

import com.imooc.dao.bo.HeadLine;
import com.imooc.dao.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:22 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Data
public class MainPageInfoDTO {

    private List<HeadLine> headLineList;

    private List<ShopCategory> shopCategoryList;
}
