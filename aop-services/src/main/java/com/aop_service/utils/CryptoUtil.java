// CryptoUtil.java
package com.aop_service.utils;

import java.util.Base64;

public class CryptoUtil {

    public static String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    public static String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
