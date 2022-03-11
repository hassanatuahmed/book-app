package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.books.db.AppDatabase;
import com.example.books.db.BookDao;

import java.util.List;

public class BookmarkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    BookDao bookDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookDao=AppDatabase.getInstance(this.getApplicationContext()).bookDao();



        Adapter adapter=new Adapter(BookmarkActivity.this, bookDao.getAllBookEntity());
        recyclerView.setAdapter(adapter);


        init();
        loadData();
        eventListeners();
        //loadBooks();
    }

    private void init(){

    }

    private void loadData(){

    }

    private void eventListeners(){

    }

    public List<BookEntity> loadBooks() {
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        List<BookEntity> books = db.bookDao().getAllBookEntity();
        Log.d("BOOKS PULLED", "TRUE");
        finish();
        return books;
    }
}