package com.example.sumbermakmur;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class katalog extends Fragment {


    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    Button btnBuy;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.katalog,container,false);




        listView=(ListView) view.findViewById(R.id.list);


        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Clurit","Rp 50.000",R.drawable.alatpertanian1));
        dataModels.add(new DataModel("Spatula","Rp 50.000",R.drawable.alatpertanian2));
        dataModels.add(new DataModel("Benih Bayam","Rp 50.000",R.drawable.benih1));
        dataModels.add(new DataModel("Benih Kangkung","Rp 65.000",R.drawable.benih2));
        dataModels.add(new DataModel("Bibit Padi","Rp 50.000",R.drawable.bibit1));
        dataModels.add(new DataModel("Bibit Timun","Rp 30.000",R.drawable.bibit2));
        dataModels.add(new DataModel("Pupuk","100.000",R.drawable.pupuk));


        adapter= new CustomAdapter(dataModels,getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(btnBuy, dataModel.getItem_name()+" Harga "+dataModel.getItem_price(), Snackbar.LENGTH_LONG)
                        .setAction("Check Out", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();

            }
        });

return view;
    }


    }

