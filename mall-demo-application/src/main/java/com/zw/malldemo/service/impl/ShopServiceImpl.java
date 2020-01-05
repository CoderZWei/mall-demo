package com.zw.malldemo.service.impl;

import com.zw.malldemo.dao.ShopDao;
import com.zw.malldemo.dto.ImageHolder;
import com.zw.malldemo.dto.ShopExecution;
import com.zw.malldemo.entity.Shop;
import com.zw.malldemo.enums.ShopStateEnum;
import com.zw.malldemo.exceptions.ShopOperationException;
import com.zw.malldemo.service.ShopService;
import com.zw.malldemo.util.ImageUtil;
import com.zw.malldemo.util.PageCalculator;
import com.zw.malldemo.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        //List<Shop> shopList = shopDao.queryShopList(shopCondition, row)
        // 将页码转换成行码
        int rowIndex= PageCalculator.calculateRowIndex(pageIndex,pageSize);
        // 依据查询条件，调用dao层返回相关的店铺列表
        List<Shop>shopList=shopDao.queryShopList(shopCondition,rowIndex,pageSize);
        // 依据相同的查询条件，返回店铺总数
        int count=shopDao.queryShopCount(shopCondition);
        ShopExecution se=new ShopExecution();
        if(shopList!=null){
            se.setShopList(shopList);
            se.setCount(count);
        }else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    @Override
    public Shop getShopById(long shopId) {
        return null;
    }

    @Override
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) {
        return null;
    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if (effectNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if(thumbnail.getImage()!=null){
                    //存储图片
                    try {
                        addShopImg(shop,thumbnail);
                    }catch (Exception e){
                        throw new ShopOperationException("添加店铺图片失败");
                    }
                    //更新店铺的图片地址 设置shopimg字段
                    effectNum=shopDao.updateShop(shop);
                    if(effectNum<=0){
                        throw new ShopOperationException("添加店铺图片失败");
                    }
                }
            }
        }catch (Exception e){
            throw new ShopOperationException("创建店铺失败，请联系相关管理员");
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop,ImageHolder thumbnail){
        // 获取shop图片目录的相对值路径
        String dest= PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr= ImageUtil.generateThumbnail(thumbnail,dest);
        shop.setShopImg(shopImgAddr);
    }
}
