package com.zw.malldemo.service;

import com.zw.malldemo.dto.ImageHolder;
import com.zw.malldemo.dto.ProductExecution;
import com.zw.malldemo.entity.Product;
import com.zw.malldemo.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    /**
     * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态，店铺Id,商品类别
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    /**
     * 通过商品Id查询唯一的商品信息
     *
     * @param productId
     * @return
     */
    Product getProductById(Long productId);

    /**
     * 添加商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;

    /**
     *修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;
}
