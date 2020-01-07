package com.zw.malldemo.dao;

import com.zw.malldemo.entity.ProductCategory;
import com.zw.malldemo.entity.ShopCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId(){
        long shopId=1;
        List<ProductCategory>productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
    }

    @Test
    public void testBatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setPriority(2);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testDeleteProductCategory(){
        long shopId=1;
        List<ProductCategory>productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
        for(ProductCategory productCategory:productCategoryList){
            if ("商品类别1".equals(productCategory.getProductCategoryName()) || "商品类别2".equals(productCategory.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(),
                        shopId);
                assertEquals(1, effectedNum);
            }
        }

    }

}
