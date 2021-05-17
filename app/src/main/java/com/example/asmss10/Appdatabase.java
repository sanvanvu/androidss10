package com.example.asmss10;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {UserEntity.class},version = 2)
public abstract class Appdatabase  extends RoomDatabase {
    private  static Appdatabase appdatabase;
    public abstract UserDao userDao();
    public static Appdatabase getAppDatabase(Context context){
        if(appdatabase==null){
                appdatabase= Room.databaseBuilder(context,
                    Appdatabase.class,"User.db").allowMainThreadQueries().build();

        }
        return  appdatabase;
    }
}
