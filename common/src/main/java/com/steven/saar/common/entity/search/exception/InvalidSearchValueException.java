package com.steven.saar.common.entity.search.exception;

/**
 * 项目名称:com.steven.saar.common.entity.search.exception
 * 类名称:InvalidSearchValueException
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:52
 */
public final class InvalidSearchValueException extends SearchException {

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value) {
        this(searchProperty, entityProperty, value, null);
    }

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value, Throwable cause) {
        super("Invalid Search Value, searchProperty [" + searchProperty + "], " +
                "entityProperty [" + entityProperty + "], value [" + value + "]", cause);
    }

}
