package com.yohendrakumar.technologyassessment.Api;

import com.yohendrakumar.technologyassessment.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("{period}.json")
    Call<ApiResponse> readResponse(
            @Path("period") String period
            , @Query("api-key") String key);
}
