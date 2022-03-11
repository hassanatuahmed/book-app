package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private View action_bookmarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        action_bookmarks=findViewById(R.id.action_bookmarks);



        getBooksResponse();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent=new Intent(MainActivity.this,BookmarkActivity.class);
        startActivity(intent);
        return false;
    }

    private void getBooksResponse() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<SampleResponse> call = requestInterface.getSampleRespone();

        call.enqueue(new Callback<SampleResponse>() {
            @Override
            public void onResponse(Call<SampleResponse> call, Response<SampleResponse> response) {
                if (response.isSuccessful()) {

                    Log.d("INTERCEPTED DATA", response.body().toString());

                    SampleResponse booksList = response.body();
                    Results results = booksList.getResults();

                    PostAdapter postAdapter= new PostAdapter(MainActivity.this,  results.getBooks());
                    recyclerView.setAdapter(postAdapter);
                }

            }

            @Override
            public void onFailure(Call<SampleResponse> call, Throwable t) {
                Log.d("error message", t.getMessage());


                Toast.makeText(MainActivity.this,
                        "I am hungry",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}