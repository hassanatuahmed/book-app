package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIncomingResponse();




    }

    private void getIncomingResponse(){
        if(getIntent().hasExtra("title")&& getIntent().hasExtra("price")
                && getIntent().hasExtra("author")&& getIntent().hasExtra("publisher")
                && getIntent().hasExtra("image")){
            //Log.d(TAG,"NOT FOUND");

            String title=getIntent().getStringExtra("title");
            String author=getIntent().getStringExtra("author");

            String publisher=getIntent().getStringExtra("publisher");
            String price=getIntent().getStringExtra("price");
            String image=getIntent().getStringExtra("image");


            setInfo(title,author,price,publisher,image);

        }

    }

    private void setInfo(String title,String author,String price,String publisher,String image){
        TextView bookTitle=findViewById(R.id.title);
        bookTitle.setText(title);

        TextView bookAuthor=findViewById(R.id.author);
        bookAuthor.setText(author);

        TextView bookPrice=findViewById(R.id.price);
        bookPrice.setText(price);

        TextView bookPublisher=findViewById(R.id.publisher);
        bookPublisher.setText(publisher);

        ImageView imageView=findViewById(R.id.imageView);

        Glide.with(this).asBitmap().load(image).into(imageView);

    }
}