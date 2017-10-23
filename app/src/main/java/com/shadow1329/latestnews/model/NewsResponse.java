package com.shadow1329.latestnews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("status")
    final String status;

    @SerializedName("source")
    final String source;

    @SerializedName("sortBy")
    final String sortBy;

    @SerializedName("articles")
    final List<News> news;




    public NewsResponse(String status, String source, String sortBy, List<News> news) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.news = news;
    }


    public List<News> getNewsList(){
        return news;
    }
}
