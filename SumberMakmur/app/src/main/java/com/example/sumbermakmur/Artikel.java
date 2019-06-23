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

public class Artikel extends Fragment {


    ArrayList<ModelArtikel> Models;
    ListView listView;
    private static AdapterArtikel adapter;
    Button btnBuy;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.artikel,container,false);




        listView=(ListView) view.findViewById(R.id.list);


        Models= new ArrayList<>();

        Models.add(new ModelArtikel("MANGGA","Mangga (Mangifera indica) adalah salah satu komoditas unggulan Indonesia yang telah lama dikenal masyarakat baik dalam negeri maupun luar negeri...",R.drawable.mangga));
        Models.add(new ModelArtikel("KACANG","Kacang panjang (Vigna Sinensis L.) merupakan jenis tanaman sayur yang populer dikalangan masyarakat...",R.drawable.kacang));
        Models.add(new ModelArtikel("SISTEM JAJAR LEGOWO","Dalam mensukseskan program pemerintah bahwa tahun 2014 harus surplus beras 10 juta ton maka para petani kita harus meningkatkan produktifitasnya padi...",R.drawable.sistem_jajar_legowo));
        Models.add(new ModelArtikel("BAWANG MERAH","Tahapan yang yang perlu diperhatikan dalam perbanyakan benih bawang merah untuk keperluan penangkaran benih umbi...",R.drawable.bawang_merah));


        adapter= new AdapterArtikel(Models,getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ModelArtikel Model = Models.get(position);

                Snackbar.make(view, Model.getTitle()+" Deskripsi "+Model.getDeskripsi(), Snackbar.LENGTH_LONG)
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

