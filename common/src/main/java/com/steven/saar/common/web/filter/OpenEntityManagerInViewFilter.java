package com.steven.saar.common.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称:com.steven.saar.common.web.filter
 * 类名称:OpenEntityManagerInViewFilter
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:27
 */
public class OpenEntityManagerInViewFilter extends BaseFilter {
    private org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter delegate =
            new org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter();


    @Override
    public void init() throws ServletException {
        super.init();
        delegate.init(getConfig());
    }

    @Override
    public void destroy() {
        super.destroy();
        delegate.destroy();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        delegate.doFilter(request, response, chain);
    }
}

