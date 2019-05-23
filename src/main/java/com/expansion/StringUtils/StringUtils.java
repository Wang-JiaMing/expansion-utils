package com.expansion.StringUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.StringUtils
 * @authorName:wangjiaming
 * @createDate:2019-05-22
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class StringUtils {

    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();


    /**
     * 获取随机字符串 Nonce Str
     *
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        char[] nonceChars = new char[32];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
