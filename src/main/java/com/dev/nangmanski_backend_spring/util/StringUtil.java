package com.dev.nangmanski_backend_spring.util;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class StringUtil extends StringUtils {

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        if (str == null) {
            return false;
        } else if (str.getClass() == String.class && "".equals(((String) str).trim())) {
            return false;
        } else if ("".equals(str.toString().trim())) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(ArrayList list) {
        final int strLen = list.size();
        if (strLen != 0) {
            return true;
        }else {
            return false;
        }
    }

    public static String nvl(String str) {
        return nvl(str, "");
    }

    public static String nvl(String str, String defaultStr) {
        if (str == null)
            return defaultStr;
        else
            return str;
    }
}
