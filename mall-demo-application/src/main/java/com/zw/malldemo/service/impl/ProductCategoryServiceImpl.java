package com.zw.malldemo.service.impl;

import com.zw.malldemo.dao.ProductCategoryDao;
import com.zw.malldemo.dao.ProductDao;
import com.zw.malldemo.dto.ProductCategoryExecution;
import com.zw.malldemo.entity.ProductCategory;
import com.zw.malldemo.enums.ProductCategoryStateEnum;
import com.zw.malldemo.exceptions.ProductCategoryOperationException;
import com.zw.malldemo.exceptions.ProductOperationException;
import com.zw.malldemo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) {
        if(productCategoryList!=null && productCategoryList.size()>0){
            try {
                int effectNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectNum<=0){
                    throw new ProductCategoryOperationException("店铺类别创建失败");
                }else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            }catch (Exception e){
                throw new ProductOperationException("batchAddProductCategory error: " + e.getMessage());
            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) {
        return null;
    }
}
