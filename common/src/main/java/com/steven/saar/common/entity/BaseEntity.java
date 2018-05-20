package com.steven.saar.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称:com.steven.saar.common.entity
 * 类名称:BaseEntity
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:38
 */
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<ID> {

    private ID id;
    private Date createTime;// 创建时间

    private Date modifyTime;// 修改时间

    private Integer isDelete; // 数据逻辑删除状态

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
