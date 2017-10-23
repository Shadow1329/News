package com.shadow1329.latestnews.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("author")
    final String author;

    @SerializedName("title")
    final String title;

    @SerializedName("description")
    final String description;

    @SerializedName("url")
    final String url;

    @SerializedName("urlToImage")
    final String urlToImage;

    @SerializedName("publishedAt")
    final String publishedAt;




    public News(String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }


    public String getAuthor(){
        return author;
    }


    public String getTitle(){
        return title;
    }


    public String getDescription(){
        return description;
    }


    public String getUrl(){
        return url;
    }


    public String getUrlToImage(){
        return urlToImage;
    }


    public String getPublishTime(){
        return publishedAt;
    }

}
