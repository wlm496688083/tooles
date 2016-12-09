package com.rd.common.util;


import com.rd.common.exception.CommonError;
import com.rd.common.exception.ErrorCode;
import com.rd.common.exception.ValidateException;

import java.util.Collection;


public class Assert {
    private Assert() {

    }

    public static void assertTrue(boolean condition, ErrorCode code, String msg) {
        if (!condition) {
            throw new ValidateException(code, msg);
        }
    }

    public static void assertFalse(boolean condition, ErrorCode code, String msg) {
        if (condition) {
            throw new ValidateException(code, msg);
        }
    }

    public static void assertNotNull(Object obj, ErrorCode code, String msg) {
        assertFalse(obj == null, code, msg);
    }

    public static void assertNull(Object obj, ErrorCode code, String msg) {
        assertTrue(obj == null, code, msg);
    }


    public static void isRequired(Object obj) {
        isRequired(obj, "");
    }

    public static void isRequired(Collection<?> collection, String fieldName) {
        assertTrue(collection != null && !collection.isEmpty(), CommonError.PARAMETER_EMPTY, fieldName);
    }

    public static void isRequired(Object obj, String fieldName) {
        assertNotNull(obj, CommonError.PARAMETER_EMPTY, fieldName);
    }

    public static void isBusinessLimit(boolean condition, String msg) {
        assertTrue(condition, CommonError.BUSINESS_LIMIT, msg);
    }
}
