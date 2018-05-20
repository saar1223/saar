package com.steven.saar.common.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * 项目名称:com.steven.saar.common.entity
 * 类名称:AbstractEntity
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:25
 */
public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID> {

    @Override
    public abstract ID getId();

    public abstract void setId(final ID id);

    @Override
    public boolean isNew(){
        return null == getId();
    }

    @Override
    public boolean equals(Object obj){
        if(null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if(!getClass().equals(obj.getClass())){
            return false;
        }
        AbstractEntity<?> that = (AbstractEntity<?>) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    @Override
    public int hashCode(){
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
