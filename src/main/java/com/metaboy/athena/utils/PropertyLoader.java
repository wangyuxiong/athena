package com.metaboy.athena.utils;

import org.apache.commons.configuration.ConversionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by metaboy on 16/5/12.
 */
public class PropertyLoader {

    private static final Log log = LogFactory.getLog(PropertyLoader.class);

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("conf/config");

    /**
     * 根据配置值
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            log.warn("无法加载配置,key:" + key, e);
            return null;
        }
    }

    /**
     * Get a string associated with the given configuration key.
     *
     * @param key The configuration key.
     * @return The associated string.
     * @throws ConversionException is thrown if the key maps to an object that is not a String.
     */
    public static String getString(final String key) {
        return getProperty(key);
    }
}
