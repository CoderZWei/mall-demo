package com.zw.malldemo.service;

import com.zw.malldemo.dto.ImageHolder;
import com.zw.malldemo.dto.ShopExecution;
import com.zw.malldemo.entity.Area;
import com.zw.malldemo.entity.PersonInfo;
import com.zw.malldemo.entity.Shop;
import com.zw.malldemo.entity.ShopCategory;
import com.zw.malldemo.enums.ShopStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShopServiceTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop()  {
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        owner.setUserId(1L);

        Area area=new Area();
        area.setAreaId(2);

        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("D:\\webapp\\heihei.jpg");
        InputStream is = null;
        try {
            is = new FileInputStream(shopImg);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
            e.printStackTrace();
        }
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
        ShopExecution se = shopService.addShop(shop, imageHolder );
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
