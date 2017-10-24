package com.shadow1329.latestnews.view;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shadow1329.latestnews.R;
import com.shadow1329.latestnews.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mDataset;
    private Context mContext;




    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(Context context, List<News> myDataset) {
        mContext = context;
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
        Log.d("NewsAdapter", "Bind " + position + " element");
        holder.mHeader.setText(mDataset.get(position).getTitle());
        holder.mDescription.setText(mDataset.get(position).getDescription());
        Picasso.with(mContext).load(mDataset.get(position).getUrlToImage()).into(holder.mImage);
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