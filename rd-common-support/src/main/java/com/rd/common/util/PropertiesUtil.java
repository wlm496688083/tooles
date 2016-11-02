package com.rd.common.util;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wanglimin1 on 2016/11/2.
 */
public class PropertiesUtil {

    private static String umpAppName = null;
    private static final String DEPLOY_APP_NAME = "deploy.app.name";
    private static final String DEF_DEPLOY_APP_NAME = "pop.rd.man";

    static {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("ump_aspect.properties"));
            String deployAppName = System.getProperty(DEPLOY_APP_NAME);
            if (StringUtils.isEmpty(deployAppName)) {
                umpAppName = properties.getProperty(DEPLOY_APP_NAME, DEF_DEPLOY_APP_NAME);
            } else {
                umpAppName = deployAppName;
            }
        } catch (IOException e) {
            umpAppName = DEF_DEPLOY_APP_NAME;
        }
    }

    public static String getAppName() {
        return umpAppName;
    }
}
