package com.yohendrakumar.technologyassessment.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String BASE_URL="http://api.nytimes.com/svc/mostpopular/v2/viewed/";
    private static Retrofit retrofit=null;

    static  Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
