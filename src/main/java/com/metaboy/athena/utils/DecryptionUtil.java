package com.metaboy.athena.utils;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Created by metaboy on 16/5/12.
 */
public class DecryptionUtil {

    private static final BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    static {
        try {
            String pwdSalt = PropertyLoader.getString("athena.user.password.salt");
            textEncryptor.setPassword(pwdSalt);
        } catch (Exception e) {
            throw new RuntimeException("getPasswordSalt exception", e);
        }
    }

    public static String decrypt(String msg) {
        return textEncryptor.decrypt(msg);
    }

    public static String encrypt(String msg) {
        return textEncryptor.encrypt(msg);
    }
}
