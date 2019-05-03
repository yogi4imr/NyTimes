package com.yohendrakumar.technologyassessment.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.yohendrakumar.technologyassessment.Api.ApiClient;
import com.yohendrakumar.technologyassessment.Api.ApiInterface;
import com.yohendrakumar.technologyassessment.model.ApiResponse;
import com.yohendrakumar.technologyassessment.utils.AppConstatant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {
    MutableLiveData<ApiResponse> apiResponseLiveData = new MutableLiveData<>();

    public LiveData<ApiResponse> getApiResponseLiveData() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<ApiResponse> apiResponseCall = apiInterface.readResponse("7", AppConstatant.API_KEY);
        apiResponseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                apiResponseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
        return apiResponseLiveData;
    }
}
