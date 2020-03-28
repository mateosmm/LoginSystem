package com.example.loginsystem;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EventDao eventDao();
}


