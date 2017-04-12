package com.rd.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wanglimin1 on 2016/11/2.
 */

@Service
public class PropertiesSpringUtil {

    @Value("${deploy.app.name}")
    private  String deployAppName;

    @Value("${mail_to}")
    private  String mailTo;

    public  String getAppName() {
        return deployAppName;
    }

    public  String getMailTo() {
        return mailTo;
    }
}