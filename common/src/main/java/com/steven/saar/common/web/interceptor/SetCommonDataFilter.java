package com.steven.saar.common.web.interceptor;

import com.steven.saar.common.web.filter.BaseFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称:com.steven.saar.common.web.interceptor
 * 类名称:SetCommonDataFilter
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-20 00:20
 */
public class SetCommonDataFilter extends BaseFilter {

    private SetCommonDataInterceptor setCommonDataInterceptor = new SetCommonDataInterceptor();

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //使用Filter时 文件上传时 getParameter时为null 所以改成Interceptor
            setCommonDataInterceptor.preHandle(request, response, null);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        chain.doFilter(request, response);
    }
}
