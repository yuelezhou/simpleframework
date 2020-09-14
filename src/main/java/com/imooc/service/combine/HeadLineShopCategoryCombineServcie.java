package com.imooc.service.combine;

import com.imooc.dao.dto.MainPageInfoDTO;
import com.imooc.dao.dto.Result;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:21 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public interface HeadLineShopCategoryCombineServcie {
    Result<MainPageInfoDTO> getMainPageInfo();
}
