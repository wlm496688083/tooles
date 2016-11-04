package com.rd.common.test.doit;

import com.rd.common.test.TestBase;
import com.rd.common.test.service.LoggableService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by wanglimin1 on 2016/11/1.
 */
public class RdLoggableAspectTest extends TestBase{

    @Resource
    private LoggableService loggableService ;

    @Test
    public void testThis(){
        Assert.assertNotNull(loggableService.queryName());
    }
}
