package com.zw.malldemo.web.superadmin;

import com.zw.malldemo.entity.Area;
import com.zw.malldemo.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    AreaService areaService;

    Logger logger= LoggerFactory.getLogger(AreaController.class);

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>listArea(){
        logger.info("-----start-----");
        Map<String, Object> modelMap = new HashMap<>();
        List<Area>list=new ArrayList<>();
        try {
            list=areaService.getAreaList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        logger.error("ha");
        logger.debug("haha");
        logger.info("-----end-----");
        return modelMap;
    }
}
