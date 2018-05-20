package com.steven.saar.common.web.filter;

import com.steven.saar.common.utils.IpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

/**
 * 项目名称:com.steven.saar.common.web.filter
 * 类名称:DebugRequestAndResponseFilter
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:27
 */
public class DebugRequestAndResponseFilter extends BaseFilter {

    private static final Logger log = LoggerFactory.getLogger("debugRequest");

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (log.isDebugEnabled()) {
            debugRequest(request);
        }
        chain.doFilter(request, response);

        if (log.isDebugEnabled()) {
            debugResponse(response);
        }
    }

    private void debugRequest(HttpServletRequest request) {
        log.debug("=====================request begin==========================");
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            uri = uri + "?" + queryString;
        }
        log.debug("{}:{}", request.getMethod(), uri);
        log.debug("remote ip:{}  sessionId:{}  ", IpUtils.getIpAddr(request), request.getRequestedSessionId());
        log.debug("===header begin============================================");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = headersToString(request.getHeaders(name));
            log.debug("{}={}", name, value);
        }
        log.debug("===header   end============================================");
        log.debug("===parameter begin==========================================");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = StringUtils.join(request.getParameterValues(name), "||");
            log.debug("{}={}", name, value);
        }
        log.debug("===parameter   end==========================================");
        log.debug("=====================request   end==========================");
    }

    private String headersToString(Enumeration<String> headers) {
        StringBuilder s = new StringBuilder();
        int index = 0;
        while (headers.hasMoreElements()) {
            if (index > 0) {
                s.append("||");
            }
            s.append(headers.nextElement());
        }
        return s.toString();
    }

    private void debugResponse(HttpServletResponse response) {
        log.debug("=====================response begin==========================");
        log.debug("status:{}", response.getStatus(), response.getContentType());
        log.debug("contentType:{}, characterEncoding:{}", response.getContentType(), response.getCharacterEncoding());
        log.debug("===header begin============================================");
        Collection<String> headerNames = response.getHeaderNames();
        for (String name : headerNames) {
            String value = StringUtils.join(response.getHeaders(name), "||");
            log.debug("{}={}", name, value);
        }
        log.debug("===header   end============================================");
        log.debug("=====================response   end==========================");
    }
}
