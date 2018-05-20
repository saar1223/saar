package com.steven.saar.common.web.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称:com.steven.saar.common.web.bind.annotation
 * 类名称:PageableDefaults
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:40
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageableDefaults {


    /**
     * The default-size the injected {@link org.springframework.data.domain.Pageable} should get if no corresponding
     * parameter defined in request (default is 10).
     */
    int value() default 10;

    /**
     * The default-pagenumber the injected {@link org.synyx.hades.domain.Pageable} should get if no corresponding
     * parameter defined in request (default is 0).
     */
    int pageNumber() default 0;

    /**
     * 默认的排序 格式为{"a=desc, a.b=desc"}
     */
    String[] sort() default {};
}
