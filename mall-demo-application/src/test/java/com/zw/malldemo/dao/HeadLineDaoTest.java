package com.zw.malldemo.dao;

import com.zw.malldemo.entity.HeadLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HeadLineDaoTest {
    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryArea(){
        List<HeadLine>headLineList=headLineDao.queryHeadLineByCondition(new HeadLine());
        assertEquals(0, headLineList.size());
    }
}
