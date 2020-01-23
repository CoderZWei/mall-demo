package com.zw.malldemo.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
    /**
     * 首页路由
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index(){
        return "frontend/index";
    }

    /**
     * 商品列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    private String showShopList(){
        return "frontend/shoplist";
    }

    /**
     * 店铺详情页路由
     *
     * @return
     */
    @RequestMapping(value = "/shopdetail.css", method = RequestMethod.GET)
    private String showShopDetail(){
        return "frontend/shopdetail.css";
    }

    /**
     * 商品详情页路由
     *
     * @return
     */
    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String showProductDetail(){
        return "frontend/productdetail";
    }
}
