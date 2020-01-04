package com.zw.malldemo.dto;

import com.zw.malldemo.entity.Area;
import com.zw.malldemo.enums.AreaStateEnum;

import java.util.List;

public class AreaExecution {
    //结果状态
    private int state;
    // 状态标识
    private String stateInfo;
    //店铺数量
    private int count;
    //操作的area(增删改商品的时候用)
    private Area area;
    //获取的area列表(查询商品列表的时候用)
    private List<Area> areaList;

    public AreaExecution() {
    }

    // 失败的构造器
    public AreaExecution(AreaStateEnum areaStateEnum) {
        this.state = areaStateEnum.getState();
        this.stateInfo = areaStateEnum.getStateInfo();
    }

    //成功的构造器
    public AreaExecution(AreaStateEnum areaStateEnum, Area area) {
        this.state = areaStateEnum.getState();
        this.stateInfo = areaStateEnum.getStateInfo();
        this.area = area;
    }

    //成功的构造器
    public AreaExecution(AreaStateEnum areaStateEnum, List<Area> areaList) {
        this.state = areaStateEnum.getState();
        this.stateInfo = areaStateEnum.getStateInfo();
        this.areaList = areaList;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
