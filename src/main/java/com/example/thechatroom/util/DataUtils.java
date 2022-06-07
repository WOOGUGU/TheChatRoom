package com.example.thechatroom.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 数据相关工具类
 *
 * @author WOOGUGU
 */
public class DataUtils {
    public static String get16uuid() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String dayTime = sdf.format(new Date());
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return dayTime + String.format("%010d", hashCode);
    }
}
