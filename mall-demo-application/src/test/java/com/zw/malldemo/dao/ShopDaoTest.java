package com.zw.malldemo.dao;

import com.zw.malldemo.entity.Area;
import com.zw.malldemo.entity.PersonInfo;
import com.zw.malldemo.entity.Shop;
import com.zw.malldemo.entity.ShopCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShopDaoTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop(){
        Shop shop=new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);

        Area area=new Area();
        area.setAreaId(2);

        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");

        int effectedNum=shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testUpdateShop(){
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum=shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testQueryByShopId(){
        Shop shop=shopDao.queryShopById(1L);
        System.out.println("areaId:" + shop.getArea().getAreaId());
        System.out.println("areaName" + shop.getArea().getAreaName());
    }

    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition=new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(12L);
        childCategory.setParent(parentCategory);

        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小：" + shopList.size());
        System.out.println("店铺总数：" + count);
        ShopCategory sc=new ShopCategory();
        sc.setShopCategoryId(2L);
        shopCondition.setShopCategory(sc);
        count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺总数：" + count);
    }

    @Test
    public void testQueryShopList(){
        Shop shopCondition=new Shop();
        PersonInfo owner=new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList=shopDao.queryShopList(shopCondition,0,5);
        System.out.println(shopList.size());
        int count=shopDao.queryShopCount(shopCondition);
        System.out.println(count);
    }
}
