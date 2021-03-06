package com.zw.malldemo.service;

import com.zw.malldemo.entity.HeadLine;

import java.util.List;

public interface HeadLineService {
    public static final String HLLISTKEY="headlinelist";

    /**
     * 根据传入的条件返回指定的头条列表
     *
     * @param headLineCondition
     * @return
     */
    List<HeadLine>getHeadLineList(HeadLine headLineCondition);
}
