package com.steven.saar.common.entity.search.exception;

import com.steven.saar.common.entity.search.SearchOperator;

/**
 * 项目名称:com.steven.saar.common.entity.search.exception
 * 类名称:InvlidSearchOperatorException
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:49
 */
public final class InvlidSearchOperatorException extends SearchException {

    public InvlidSearchOperatorException(String searchProperty, String operatorStr) {
        this(searchProperty, operatorStr, null);
    }

    public InvlidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
    }
}
