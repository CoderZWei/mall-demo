package com.zw.malldemo.dao;

import com.zw.malldemo.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
       List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
//        Area area=new Area();
//        areaDao.insertArea(area);
    }
}
