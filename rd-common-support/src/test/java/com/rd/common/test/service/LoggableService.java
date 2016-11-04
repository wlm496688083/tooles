package com.rd.common.test.service;

import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.Loggable;
import com.rd.common.annotation.UMP;
import com.rd.common.exception.CommonError;
import com.rd.common.exception.SystemUnavailableException;
import com.rd.common.rdenum.Key;

/**
 * Created by wanglimin1 on 2016/11/1.
 */
@Loggable
@UMP(Key.SERVICE)
@ConvertException
public class LoggableService {

    private String name;

    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String queryName(){
        throw new SystemUnavailableException(CommonError.SYSTEM_ERROR);
    }

}
