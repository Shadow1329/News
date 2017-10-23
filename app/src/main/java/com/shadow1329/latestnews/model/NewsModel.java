package com.shadow1329.latestnews.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsModel {

    private Retrofit mRetrofit;
    private IServerRequests mServerRequests;




    // Create model
    public NewsModel() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mServerRequests = mRetrofit.create(IServerRequests.class);
    }


    // Get news
    public void getNews(final NewsModelCallback modelResponse) {
        Call<NewsResponse> result = mServerRequests.getNews("google-news", "top", "0993a9ebfae54ae9b0e9f44b62fd3cd3");
        result.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                if (response.body() != null) {
                    NewsResponse newsResponse = response.body();
                    modelResponse.onSuccess(newsResponse.getNewsList());
                } else {
                    modelResponse.onFailed();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                modelResponse.onFailed();
            }
        });
    }
}
