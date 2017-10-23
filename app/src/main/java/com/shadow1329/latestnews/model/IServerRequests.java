package com.shadow1329.latestnews.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface IServerRequests {

    @GET("/v1/articles")
    Call<NewsResponse> getNews(
            @Query("source") String source,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey);
}
