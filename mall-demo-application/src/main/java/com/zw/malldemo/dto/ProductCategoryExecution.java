package com.zw.malldemo.dto;

import com.zw.malldemo.entity.ProductCategory;
import com.zw.malldemo.enums.ProductCategoryStateEnum;

import java.util.List;

public class ProductCategoryExecution {
    // 结果状态
    private int state;
    // 状态标识
    private String stateInfo;

    private List<ProductCategory>productCategoryList;

    public ProductCategoryExecution() {
    }

    // 操作失败的时候使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum productCategoryStateEnum) {
        this.state = productCategoryStateEnum.getState();
        this.stateInfo=productCategoryStateEnum.getStateInfo();
    }

    // 操作成功的时候使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum productCategoryStateEnum,List<ProductCategory>productCategoryList) {
        this.state = productCategoryStateEnum.getState();
        this.stateInfo=productCategoryStateEnum.getStateInfo();
        this.productCategoryList=productCategoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
