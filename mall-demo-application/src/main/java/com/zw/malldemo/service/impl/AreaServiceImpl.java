package com.zw.malldemo.service.impl;

import com.zw.malldemo.dao.AreaDao;
import com.zw.malldemo.dto.AreaExecution;
import com.zw.malldemo.entity.Area;
import com.zw.malldemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;


    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public AreaExecution getArea(Area area) {
        return null;
    }

    @Override
    public AreaExecution modifyArea(Area area) {
        return null;
    }
}
