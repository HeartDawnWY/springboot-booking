package com.jingen.booking.biz.common.utils;

import java.util.regex.Pattern;

public class StringUtils {

    // 验证手机号
    private static final String REGEX_PHONE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    // 验证邮箱
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    // 验证身份证
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
    // 验证URL
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    // 验证IP
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    public static boolean isEmptyOrNull(Object data){
        if (data == null){
            return true;
        }else {
            return data.toString().length() > 0 ? false : true;
        }
    }


    public static boolean overLength(Object data, int minLen, int maxLen) {
        if (isEmptyOrNull(data)) {
            return true;
        }
        int len = data.toString().length();
        if (len >= minLen && len <= maxLen){
            return true;
        }
        return false;
    }

    public static boolean isEmail(Object data){
        if (isEmptyOrNull(data)) {
            return false;
        }
        return Pattern.matches(REGEX_EMAIL, data.toString());
    }

    public static boolean isPhone(Object data){
        if (isEmptyOrNull(data)) {
            return false;
        }
        return Pattern.matches(REGEX_PHONE, data.toString());
    }

    public static boolean isMatch(Object data, String pattern) {
        if (isEmptyOrNull(data)) {
            return false;
        }
        return Pattern.matches(pattern, data.toString());
    }
}
