package com.steven.saar.common.plugin.entity;

/**
 * 项目名称:com.steven.saar.common.plugin.entity
 * 类名称:LogicDeleteable
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-20 00:31
 */
public interface LogicDeleteable {

    public Boolean getDeleted();

    public void setDeleted(Boolean deleted);

    /**
     * 标识为已删除
     */
    public void markDeleted();

}
