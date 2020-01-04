package com.zw.malldemo.service;

import com.zw.malldemo.dto.AreaExecution;
import com.zw.malldemo.entity.Area;

import java.util.List;

public interface AreaService {
    public static final String AREALISTKEY="arealist";

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Area>getAreaList();

    /**
     * 增加区域信息
     *
     * @param area
     * @return
     */
    AreaExecution getArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    AreaExecution modifyArea(Area area);

}
