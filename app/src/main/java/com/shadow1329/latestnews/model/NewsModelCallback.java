package com.shadow1329.latestnews.model;

import java.util.List;

public interface NewsModelCallback {
    void onSuccess(List<News> newsList);
    void onFailed();
}
