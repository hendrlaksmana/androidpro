package com.example.sumbermakmur;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.sumbermakmur.Adapter.CustomAdapter;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class katalog extends Fragment {

    private RecyclerView RecyclerView;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private static CustomAdapter adapter;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.katalog,container,false);

        String url = "http://192.168.43.4/rest_sm/index.php/api/produk";

        RecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(getContext());

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id_produk", json.getString("id_produk"));
                        map.put("nama_produk", json.getString("nama_produk"));
                        map.put("kategori", json.getString("kategori"));
                        map.put("nama_file", json.getString("nama_file"));
                        map.put("deskripsi", json.getString("deskripsi"));
                        map.put("tanggal", json.getString("tanggal"));
                        map.put("harga", json.getString("harga"));
                        list_data.add(map);
                        adapter = new CustomAdapter(getContext(),list_data);
                        RecyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("erorr ",error.getMessage()+"");
            }
        });

        requestQueue.add(stringRequest);

        return view;
    }

}