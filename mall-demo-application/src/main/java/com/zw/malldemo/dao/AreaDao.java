package com.zw.malldemo.dao;

import com.zw.malldemo.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area>queryArea();

    /**
     * 插入区域信息
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

    /**
     * 批量删除区域列表
     * @param areaList
     * @return
     */
    int batchDeleteArea(List<Long>areaList);
}
