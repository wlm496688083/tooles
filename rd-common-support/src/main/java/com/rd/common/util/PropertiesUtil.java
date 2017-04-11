package com.rd.common.util;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wanglimin1 on 2016/11/2.
 */
public class PropertiesUtil {

    private static final String DEPLOY_APP_NAME = "deploy.app.name";
    private static final String DEF_DEPLOY_APP_NAME = "ebao";
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        } catch (IOException e) {
            ;
        }
    }

    public static String getAppName() {
        String deployAppName = System.getProperty(DEPLOY_APP_NAME);
        String umpAppName;
        if (StringUtils.isEmpty(deployAppName)) {
            umpAppName = properties.getProperty(DEPLOY_APP_NAME, DEF_DEPLOY_APP_NAME);
        } else {
            umpAppName = deployAppName;
        }
        return umpAppName;
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}