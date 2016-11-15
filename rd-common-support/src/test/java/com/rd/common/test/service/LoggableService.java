package com.rd.common.test.service;

import com.rd.common.annotation.pack.RdService;

/**
 * Created by wanglimin1 on 2016/11/1.
 */
@RdService(logName = "asd")
public class LoggableService {

    private String name;

    private int age;

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

    public String queryName() {
        System.out.println(111);
        return "111234";
    }

}
