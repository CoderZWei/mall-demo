package com.zw.malldemo.service;

import com.zw.malldemo.dto.ImageHolder;
import com.zw.malldemo.dto.ProductExecution;
import com.zw.malldemo.entity.Product;
import com.zw.malldemo.entity.ProductCategory;
import com.zw.malldemo.entity.Shop;
import com.zw.malldemo.enums.ProductStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct()throws FileNotFoundException {
        // 创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(41L);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        // 创建缩略图文件流
        File thumbnailFile = new File("D:\\webapp\\heihei.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
        // 创建两个商品详情图文件流并将他们添加到详情图列表中
        File productImg1 = new File("D:\\webapp\\pic.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("D:\\webapp\\pic.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
        productImgList.add(new ImageHolder(productImg1.getName(), is1));
        productImgList.add(new ImageHolder(productImg2.getName(), is2));
        // 添加商品并验证
        ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
    }

    @Test
    public void testModifyProduct() throws FileNotFoundException {
        // 创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(41L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("正式的商品l");
        product.setProductDesc("正式的商品");
        // 创建缩略图文件流
        File thumbnailFile = new File("D:\\webapp\\heihei.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
        // 创建两个商品详情图文件流并将他们添加到详情图列表中
        File productImg1 = new File("D:\\webapp\\pic.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("D:\\webapp\\pic.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
        productImgList.add(new ImageHolder(productImg1.getName(), is1));
        productImgList.add(new ImageHolder(productImg2.getName(), is2));
        // 添加商品并验证
        ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
    }
}
