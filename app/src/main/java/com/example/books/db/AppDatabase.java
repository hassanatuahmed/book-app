package com.example.books.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.books.BookEntity;

@Database(entities = BookEntity.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
    private  static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE== null){
            INSTANCE= Room.databaseBuilder(context
                            .getApplicationContext(),AppDatabase.class,"DB_NAME")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }

}
