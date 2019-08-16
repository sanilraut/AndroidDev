package com.example.testroom.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.testroom.model.DataItem;

@Database(entities = {DataItem.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract DataItemDao dataItemDao();

    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "app-database").allowMainThreadQueries().build();
        }
        return instance;
    }
    public static void destroyInstance() {
        instance = null;
    }
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
