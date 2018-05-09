package com.zy.selfmanagement.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * <pre>
 *    @author : https://blog.csdn.net/H176Nhx7/article/details/79649250
 *     time   : 2018/05/09
 *     desc   : 将Date类型的数据转换成Long类型来存储
 *     version: 1.0
 * </pre>
 */
public class ConversionFactory {

    @TypeConverter
    public static Long fromDateToLong(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Date fromLongToDate(Long value) {
        return value == null ? null : new Date(value);
    }
}
