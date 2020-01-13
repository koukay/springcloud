package com.houkai.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author yueyi2019
 */
public class Sha1Util {

    /**
     * 将输入源 转换成 密文
     * @param src
     * @return
     */
    public static String encode(String src) {
        if (StringUtils.isEmpty(src)) {
            return null;
        } else {
            return DigestUtils.sha1Hex(src);

        }
    }
}
