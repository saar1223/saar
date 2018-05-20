package com.steven.saar.common.entity.enums;

/**
 * 项目名称:com.steven.saar.common.entity.enums
 * 类名称:BooleanEnum
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:42
 */
public enum BooleanEnum {

    TRUE(Boolean.TRUE, "是"), FALSE(Boolean.FALSE, "否");

    private final Boolean value;
    private final String info;

    private BooleanEnum(Boolean value, String info) {
        this.value = value;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public Boolean getValue() {
        return value;
    }
}
