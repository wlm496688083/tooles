package com.rd.common.test.service;

import com.rd.common.annotation.Loggable;
import org.springframework.stereotype.Service;

/**
 * Created by wanglimin1 on 2016/11/1.
 */
@Service
@Loggable
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

    public String queryName() throws Exception {
       throw new Exception("miii");
    }

}
