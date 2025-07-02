package com.studentmgmt.util;

public class ValidationUtil {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}
