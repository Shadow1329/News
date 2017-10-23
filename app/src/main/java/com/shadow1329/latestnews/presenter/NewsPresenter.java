package com.shadow1329.latestnews.presenter;

import android.util.Log;

import com.shadow1329.latestnews.model.News;
import com.shadow1329.latestnews.model.NewsModel;
import com.shadow1329.latestnews.model.NewsModelCallback;
import com.shadow1329.latestnews.view.NewsView;

import java.util.List;

public class NewsPresenter {

    private static final String TAG = "NewsPresenter";

    private NewsView view;




    public void attachView(NewsView mvpView) {
        view = mvpView;
    }




    public void detachView() {
        view = null;
    }




    public void getNewsList() {

        NewsModel newsModel = new NewsModel();
        newsModel.getNews(new NewsModelCallback() {
            @Override
            public void onSuccess(List<News> newsList) {
                Log.d(TAG, "Getting news has succeeded!");
                if (view != null)
                    view.setNewsList(newsList);
            }

            @Override
            public void onFailed() {
                Log.d(TAG, "Getting news has failed!");
            }
        });
    }
}
