package com.example.books.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.books.BookEntity;

import java.util.List;

@Dao
public interface BookDao {

//    @Query("SELECT * FROM book_entity")
//    LiveData<List<BookEntity>>getAllBooEntity;

    @Insert
    void insertBooks(BookEntity bookEntity);


    @Delete
    void delete(BookEntity bookEntity);

    @Query("SELECT * FROM book_entity")
    List<BookEntity> getAllBookEntity();
}
