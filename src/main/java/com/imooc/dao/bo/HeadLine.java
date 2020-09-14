package com.imooc.dao.bo;

import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:12 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Data
public class HeadLine {

    private Long lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    private Integer enableStatus;

    private Date createTime;

    private Date lastEditTime;
}
