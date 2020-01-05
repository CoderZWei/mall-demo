package com.zw.malldemo.service;

import com.zw.malldemo.dto.ImageHolder;
import com.zw.malldemo.dto.ShopExecution;
import com.zw.malldemo.entity.Shop;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     *
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 通过店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    public Shop getShopById(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     *
     * @param shop
     * @param thumbnail
     * @return
     */
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail);

    /**
     * 注册店铺信息，包括图片处理
     *
     * @param shop
     * @param thumbnail
     * @return
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail);
}
