package com.imooc.dao.bo;

import java.util.Date;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:12 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ShopCategory {

    private Long shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDesc;

    private String shopCategoryImg;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private ShopCategory parent;
}
