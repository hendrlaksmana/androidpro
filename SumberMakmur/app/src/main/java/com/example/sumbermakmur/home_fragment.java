package com.example.sumbermakmur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class home_fragment extends Fragment {

    private int[] carouselImages = new int[] {
            R.drawable.toko, R.drawable.toko, R.drawable.toko
    };

    private RecyclerView homerecyclerview;
    private List<recom_item> recom_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        //Carousel
        CarouselView carouselView = view.findViewById(R.id.carousel);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(carouselImages[position]);
            }
        });

        //Recycler
        homerecyclerview = (RecyclerView) view.findViewById(R.id.horizontal_recycler_view);
        HomeRecylerViewAdapter homerecyclerAdapter = new HomeRecylerViewAdapter(getContext(), recom_list);
        homerecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        homerecyclerview.setAdapter(homerecyclerAdapter);
        homerecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), recomendation_item.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        recom_list = new ArrayList<>();
        recom_list.add(new recom_item("Clurit","Rp 50.000",R.drawable.alatpertanian1));
        recom_list.add(new recom_item("Spatula","Rp 75.000",R.drawable.alatpertanian2));
        recom_list.add(new recom_item("Benih Ruah","Rp 150.000",R.drawable.benih1));
        recom_list.add(new recom_item("Benih Engkok","Rp 95.000",R.drawable.benih2));
        recom_list.add(new recom_item("Bibit Bebet","Rp 73.000",R.drawable.bibit1));
        recom_list.add(new recom_item("Bibit Bobot","Rp 66.000",R.drawable.bibit2));
        recom_list.add(new recom_item("Pupuk","135.000",R.drawable.pupuk));
    }
}
