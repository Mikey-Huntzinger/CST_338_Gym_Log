package com.example.hw04_gymlog_v300.database.typeConverters;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTypeConverter {

    @TypeConverter
    public long convertLongToDate(LocalDateTime date){
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.from(date), ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

    @TypeConverter
    public LocalDateTime convertLongToDate(long epochMilli){

        Instant instant = Instant.ofEpochMilli(epochMilli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    }
}
