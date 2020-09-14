package com.imooc.service.solo;

import com.imooc.dao.bo.HeadLine;
import com.imooc.dao.dto.Result;

import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:10 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLine(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,int pageIndex, int pageSize);


}
