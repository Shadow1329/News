package com.shadow1329.latestnews.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shadow1329.latestnews.R;
import com.shadow1329.latestnews.model.News;
import com.shadow1329.latestnews.presenter.NewsPresenter;

import java.util.List;


public class NewsFragment extends Fragment implements NewsView{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private NewsPresenter mNewsPresenter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);


        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.newsRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mNewsPresenter = new NewsPresenter();

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();

        mNewsPresenter.attachView(this);
        mNewsPresenter.getNewsList();
    }


    @Override
    public void onPause() {
        super.onPause();

        mNewsPresenter.detachView();
    }


    @Override
    public void setNewsList(List<News> newsList) {
        mAdapter = new NewsAdapter(newsList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
