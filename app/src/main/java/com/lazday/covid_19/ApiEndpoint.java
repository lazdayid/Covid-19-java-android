package com.lazday.covid_19;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("indonesia")
    Call<List<MainModel>> getData();
}
