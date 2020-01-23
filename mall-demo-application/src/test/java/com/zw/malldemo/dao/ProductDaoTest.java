package com.zw.malldemo.dao;

import com.zw.malldemo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testQueryProductList(){
        Product productCondition=new Product();
        // 分页查询，预期返回三条结果
        List<Product>productList=productDao.queryProductList(productCondition,0,3);
        assertEquals(3, productList.size());
        // 查询名称为测试的商品总数
        int count = productDao.queryProductCount(productCondition);
        assertEquals(4, count);
        // 使用商品名称模糊查询，预期返回两条结果
        productCondition.setProductName("测试");
        productList = productDao.queryProductList(productCondition, 0, 3);
        assertEquals(2, productList.size());
        count = productDao.queryProductCount(productCondition);
        assertEquals(2, count);
    }
}
