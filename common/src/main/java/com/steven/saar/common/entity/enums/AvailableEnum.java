package com.steven.saar.common.entity.enums;

/**
 * 项目名称:com.steven.saar.common.entity.enums
 * 类名称:AvailableEnum
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:42
 */
public enum AvailableEnum {

    TRUE(Boolean.TRUE, "可用"), FALSE(Boolean.FALSE, "不可用");

    private final Boolean value;
    private final String info;

    private AvailableEnum(Boolean value, String info) {
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
