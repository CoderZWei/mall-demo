package com.zw.malldemo.enums;

public enum PersonInfoStateEnum {
    SUCCESS(0,"创建成功"),INNER_ERROR(-1001,"操作失败"), EMPTY(-1002, "用户信息为空");

    private int state;
    private String stringInfo;

    private PersonInfoStateEnum(int state, String stringInfo) {
        this.state = state;
        this.stringInfo = stringInfo;
    }

    public int getState() {
        return state;
    }

    public String getStringInfo() {
        return stringInfo;
    }

    public static PersonInfoStateEnum stateOf(int index){
        for(PersonInfoStateEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
