package com.zw.malldemo.util;

public class PathUtil {
    private static String seperator=System.getProperty("file.separator");

    public static String getImageBasePath(){
        String os=System.getProperty("os.name");
        String basePath="";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/webapp/imgDir";
        }else {
            basePath = "/Users/baidu/work/image";
        }
        basePath=basePath.replace("/",seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId){
        String imagePath= "/upload/images/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}