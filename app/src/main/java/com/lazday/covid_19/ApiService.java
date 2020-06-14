package com.lazday.covid_19;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static String BASE_URL = "https://demo.lazday.com/rest-api-sample/";
    private static Retrofit retrofit = null;
    public static ApiEndpoint endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( ApiEndpoint.class );
    }

}
