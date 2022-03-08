package com.example.books;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("hardcover-fiction.json?api-key=yZJuQbRHEqs82XPM9Ad9H0vFWQkwb0Sk")
    Call<SampleResponse> getSampleRespone();
}
