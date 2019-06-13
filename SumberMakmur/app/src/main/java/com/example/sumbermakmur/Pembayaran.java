package com.example.sumbermakmur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class Pembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
    }

    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("PembayaranActivity","Nama:"+name);

        EditText alamatEditText=(EditText)findViewById(R.id.edt_alamat);
        String alamat=alamatEditText.getText().toString();
        Log.v("PembayaranActivity","Alamat:"+alamat);

        EditText nomorEditText=(EditText)findViewById(R.id.edt_nomor);
        String nomor=nomorEditText.getText().toString();
        Log.v("PembayaranActivity","Nomor:"+nomor);

        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.Ringan_checkbox);
        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
        Log.v("ServiceActivity","has Ringan:"+haswhippedcream);

        CheckBox chocolateChekBox= (CheckBox) findViewById(R.id.Berat_checkbox);
        boolean haschocolate=chocolateChekBox.isChecked();//mengidentifikasi check
        Log.v("ServiceActivity","has Ringan:"+haschocolate);

        int price=calculateprice(haswhippedcream,haschocolate);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,alamat,nomor,haswhippedcream,haschocolate);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean ringan,boolean berat){//jumlah pesanan * harga
        int harga=5000;

        if(ringan){
            harga=harga+10000;
        }

        if (berat){
            harga=harga+200000;
        }

        return harga;
    }
    private String createOrderSummary(int price, String alamat, String nomor ,String name, boolean berat, boolean ringan) {//hasil pemesanan
        String pricemessage=" Nama       = "+name;
        pricemessage+="\n Alamat          =" +alamat;
        pricemessage+="\n Plat           =" +nomor;
        pricemessage+="\n Service Berat  =" +ringan;
        pricemessage+="\n Service Ringan =" +berat;
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n Terimakasih";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}