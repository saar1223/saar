package com.steven.saar.common.entity.search.exception;

/**
 * 项目名称:com.steven.saar.common.entity.search.exception
 * 类名称:InvalidSearchPropertyException
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:52
 */
public final class InvalidSearchPropertyException extends SearchException {

    public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }


}