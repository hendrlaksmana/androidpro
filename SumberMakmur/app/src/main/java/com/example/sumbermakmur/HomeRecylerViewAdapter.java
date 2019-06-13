package com.example.sumbermakmur;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class HomeRecylerViewAdapter extends RecyclerView.Adapter<HomeRecylerViewAdapter.HomeViewHolder> {

    Context mContext ;
    List<recom_item> mData ;
    Dialog mDialog ;

    public HomeRecylerViewAdapter(Context mContext, List<recom_item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_item, parent, false);
        final HomeViewHolder viewHolder = new HomeViewHolder(view);

        mDialog = new Dialog(mContext);
        mDialog.setContentView(R.layout.product_item);

        viewHolder.layout_recom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView recom_name = (TextView) mDialog.findViewById(R.id.recom_name);
                TextView recom_price = (TextView) mDialog.findViewById(R.id.recom_price);
                ImageView recom_image = (ImageView) mDialog.findViewById(R.id.recom_image);
                recom_name.setText(mData.get(viewHolder.getAdapterPosition()).getRecom_name());
                recom_price.setText(mData.get(viewHolder.getAdapterPosition()).getRecom_price());
                recom_image.setImageResource(mData.get(viewHolder.getAdapterPosition()).getRecom_image());
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int position) {
        homeViewHolder.recom_name.setText(mData.get(position).getRecom_name());
        homeViewHolder.recom_price.setText(mData.get(position).getRecom_price());
        homeViewHolder.recom_img.setImageResource(mData.get(position).getRecom_image());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layout_recom;
        private ImageView recom_img;
        private TextView recom_name;
        private TextView recom_price;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            recom_img = (ImageView) itemView.findViewById(R.id.recom_image);
            recom_name = (TextView) itemView.findViewById(R.id.recom_name);
            recom_price = (TextView) itemView.findViewById(R.id.recom_price);

            layout_recom = (RelativeLayout) itemView.findViewById(R.id.layout_recom);
        }
    }
}