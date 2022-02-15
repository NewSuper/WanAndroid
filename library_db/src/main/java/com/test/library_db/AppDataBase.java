package com.test.library_db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@TypeConverters(value = {DateConverter.class})
@Database(entities = {SearchHistoryEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract SearchHistoryDao searchHistoryDao();
}

