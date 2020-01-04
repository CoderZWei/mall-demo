package com.zw.malldemo.service;

import com.zw.malldemo.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AreaServiceTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area>areaList=areaService.getAreaList();
        assertEquals("西院", areaList.get(0).getAreaName());
    }
}
