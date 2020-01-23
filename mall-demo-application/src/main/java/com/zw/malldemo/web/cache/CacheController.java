package com.zw.malldemo.web.cache;

import com.zw.malldemo.service.AreaService;
import com.zw.malldemo.service.CacheService;
import com.zw.malldemo.service.HeadLineService;
import com.zw.malldemo.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CacheController {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;

    /**
     * 清除区域信息相关的所有redis缓存
     *
     * @return
     */
    @RequestMapping(value = "/clearcache4area",method = RequestMethod.GET)
    private String clearCache4Area(){
        cacheService.removeFromCache(areaService.AREALISTKEY);
        return "shop/operationsuccess";
    }

    /**
     * 清除头条相关的所有redis缓存
     *
     * @return
     */
    @RequestMapping(value = "/clearcache4headline", method = RequestMethod.GET)
    private String clearCache4Headline(){
        cacheService.removeFromCache(headLineService.HLLISTKEY);
        return "shop/operationsuccess";
    }

    /**
     * 清除店铺类别相关的所有redis缓存
     *
     * @return
     */
    private String clearCache4ShopCategory(){
        cacheService.removeFromCache(shopCategoryService.SCLISTKEY);
        return "shop/operationsuccess";
    }
}
