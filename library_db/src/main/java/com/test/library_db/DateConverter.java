package com.test.library_db;

import android.util.Log;

import java.util.Date;

import androidx.room.TypeConverter;

public class DateConverter {

    @TypeConverter
    public static Date revertDate(long value) {
        return new Date(value);
    }

    @TypeConverter
    public static long converterDate(Date value) {
        if (value == null) {
            value = new Date();
        }
        Log.i("DateConverter", "converterDate=" + value.getTime() + "");
        return value.getTime();
    }
}