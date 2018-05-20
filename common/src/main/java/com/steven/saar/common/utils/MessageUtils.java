package com.steven.saar.common.utils;

import org.springframework.context.MessageSource;

/**
 * 项目名称:com.steven.saar.common.utils
 * 类名称:MessageUtils
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:45
 */
public class MessageUtils {

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringUtils.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }
}
