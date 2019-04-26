package com.company.mynotes.database;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

}
