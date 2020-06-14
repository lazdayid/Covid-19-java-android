package com.lazday.covid_19;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("data.php")
    Call<MainModel> getData();
}
