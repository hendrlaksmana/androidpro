package com.example.sumbermakmur;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AJISETYA.
 */
public class AdapterArtikel extends RecyclerView.Adapter<AdapterArtikel.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterArtikel(Context artikel, ArrayList<HashMap<String, String>> list_data) {
        this.context = artikel;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_artikel, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load("http://192.168.43.4/rest_sm/foto_artikel" + list_data.get(position).get("foto"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
        holder.Judul.setText(list_data.get(position).get("judul_artikel"));
        holder.Deskripsi.setText(list_data.get(position).get("deskripsi"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Judul;
        TextView Deskripsi;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            Judul = (TextView) itemView.findViewById(R.id.judul);
            Deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
