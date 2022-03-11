package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.books.db.AppDatabase;
import com.example.books.db.BookDao;

public class DetailActivity extends AppCompatActivity {
    boolean doubleClick = false;
    int count = 0;
    ImageView imageViewBook;
    BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageViewBook = findViewById(R.id.imageViewBook);
        bookDao = AppDatabase.getInstance(this.getApplicationContext()).bookDao();
        getIncomingResponse();


    }

    private void getIncomingResponse() {
        if (getIntent().hasExtra("title") && getIntent().hasExtra("price")
                && getIntent().hasExtra("author") && getIntent().hasExtra("publisher")
                && getIntent().hasExtra("image")) {
            //Log.d(TAG,"NOT FOUND");

            String title = getIntent().getStringExtra("title");
            String author = getIntent().getStringExtra("author");

            String publisher = getIntent().getStringExtra("publisher");
            String price = getIntent().getStringExtra("price");
            String image = getIntent().getStringExtra("image");


            setInfo(title, author, price, publisher, image);

        }

    }

    private void setInfo(String title, String author, String price, String publisher, String image) {
        TextView bookTitle = findViewById(R.id.title);
        bookTitle.setText(title);

        TextView bookAuthor = findViewById(R.id.author);
        bookAuthor.setText(author);

        TextView bookPrice = findViewById(R.id.price);
        bookPrice.setText(price);

        TextView bookPublisher = findViewById(R.id.publisher);
        bookPublisher.setText(publisher);

        ImageView imageView = findViewById(R.id.imageView);

        Glide.with(this).asBitmap().load(image).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count == 2) {
                    if (imageViewBook.getVisibility() == view.VISIBLE) {
                        imageViewBook.setVisibility(view.INVISIBLE);
                        //0delete(title, author, publisher, price, image);
                        Toast.makeText(DetailActivity.this,
                                "Item removed from bookmarks", Toast.LENGTH_SHORT).show();

                    } else {
                        imageViewBook.setVisibility(view.VISIBLE);

                        saveItem(image, author, title, publisher, price);
                        Toast.makeText(DetailActivity.this,
                                "Item added to bookmark", Toast.LENGTH_SHORT).show();
                    }
                    count = 0;
                }
            }
        });
    }

    public void saveItem(String image, String author, String title, String publisher, String price) {
//        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        BookEntity bookEntity = new BookEntity();
        bookEntity.bookAuthor = author;
        bookEntity.bookTitle = title;
        bookEntity.bookPublisher = publisher;
        bookEntity.bookPrice = price;
        bookEntity.book_image = image;

        bookDao.insertBooks(bookEntity);
        Log.d("NEW BOOK SAVE", "TRUE");

//        finish();

    }

    public void delete(String author, String title, String publisher, String price, String image) {
//        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        BookEntity bookEntity = new BookEntity();
        bookEntity.bookAuthor = author;
        bookEntity.bookTitle = title;
        bookEntity.bookPublisher = publisher;
        bookEntity.bookPrice = price;
        bookEntity.book_image = image;


        bookDao.delete(bookEntity);
//        db.bookDao().delete(bookEntity);
        Log.d("BOOK DELETED", "TRUE");
        finish();
    }


}