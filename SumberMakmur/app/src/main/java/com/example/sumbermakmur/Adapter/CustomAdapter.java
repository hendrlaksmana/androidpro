package com.example.sumbermakmur.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sumbermakmur.R;
import com.example.sumbermakmur.katalog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AJISETYA.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public CustomAdapter(Context Katalog, ArrayList<HashMap<String, String>> list_data) {
        this.context = Katalog;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load("http://192.168.43.4/rest_sm/foto_produk" + list_data.get(position).get("nama_file"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageproduk);
        holder.txtnama.setText(list_data.get(position).get("nama_produk"));
        holder.txtharga.setText(list_data.get(position).get("harga"));
        holder.txtdeskripsi.setText(list_data.get(position).get("deskripsi"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtnama;
        TextView txtharga;
        TextView txtdeskripsi;
        ImageView imageproduk;

        public ViewHolder(View itemView) {
            super(itemView);

            txtnama = (TextView) itemView.findViewById(R.id.nama_produk);
            txtharga = (TextView) itemView.findViewById(R.id.harga);
            txtdeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            imageproduk = (ImageView) itemView.findViewById(R.id.imgproduk);
        }
    }
}
