package com.steven.saar.common.entity.search.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * 项目名称:com.steven.saar.common.entity.search.exception
 * 类名称:SearchException
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:48
 */
public class SearchException extends NestedRuntimeException {

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
