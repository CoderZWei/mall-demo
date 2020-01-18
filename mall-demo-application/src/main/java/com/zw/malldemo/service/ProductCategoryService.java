package com.zw.malldemo.service;

import com.zw.malldemo.dto.ProductCategoryExecution;
import com.zw.malldemo.entity.ProductCategory;
import com.zw.malldemo.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return
     */
    List<ProductCategory>getProductCategoryList(long shopId);

    /**
     * 批量添加商品类别信息
     *
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList);

    ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId);

}
