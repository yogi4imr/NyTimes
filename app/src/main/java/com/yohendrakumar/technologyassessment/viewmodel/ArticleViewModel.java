package com.yohendrakumar.technologyassessment.viewmodel;
import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import com.yohendrakumar.technologyassessment.Api.ApiClient;
import com.yohendrakumar.technologyassessment.Api.ApiInterface;
import com.yohendrakumar.technologyassessment.model.ApiResponse;
import com.yohendrakumar.technologyassessment.utils.AppConstatant;

public class ArticleViewModel extends ViewModel {
    MutableLiveData<ApiResponse> apiResponseLiveData = new MutableLiveData<>();

    /*public LiveData<ApiResponse> getApiResponseLiveData() {
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
    }*/

    public LiveData<ApiResponse> getTask() {

         ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
         apiInterface.readResponse("7", AppConstatant.API_KEY)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<ApiResponse>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(ApiResponse apiResponse) {
                        apiResponseLiveData.setValue(apiResponse);
                     }

                     @Override
                     public void onError(Throwable e) {
                         Log.d("RXError" , e.getMessage());
                     }

                     @Override
                     public void onComplete() {

                     }
                 });


        return apiResponseLiveData;
    }
}
