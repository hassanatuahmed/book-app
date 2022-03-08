package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addOnItemTouchListener();


        getBooksResponse();
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