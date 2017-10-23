package com.shadow1329.latestnews.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shadow1329.latestnews.R;
import com.shadow1329.latestnews.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mDataset;




    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(List<News> myDataset) {
        mDataset = myDataset;
    }




    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mHeader.setText(mDataset.get(position).getTitle());
        holder.mDescription.setText(mDataset.get(position).getDescription());
        //new DownloadImageTask(holder.mImage).execute(mDataset.get(position).getUrlToImage());
    }




    @Override
    public int getItemCount() {
        return mDataset.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mHeader;
        private TextView mDescription;
        private ImageView mImage;

        public ViewHolder(View  v) {
            super(v);
            mHeader = (TextView) v.findViewById(R.id.news_header);
            mDescription = (TextView) v.findViewById(R.id.news_description);
            mImage = (ImageView) v.findViewById(R.id.news_image);
        }
    }
}