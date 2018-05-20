package com.steven.saar.common.web.filter;

import com.steven.saar.common.utils.LogUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称:com.steven.saar.common.web.filter
 * 类名称:AccessLogFilter
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:21
 */
public class AccessLogFilter extends BaseFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        LogUtils.logAccess(request);
        chain.doFilter(request, response);
    }
}
