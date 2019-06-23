package com.example.sumbermakmur;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class ModelArtikel {

    private String Title ;
    private String Deskripsi;
    private int Image ;


    public ModelArtikel(String title, String deskripsi, int image ) {
        Image = image;
        Title = title;
        Deskripsi = deskripsi;

    }


    public String getTitle() {
        return Title;
    }


    public String getDeskripsi() {
        return Deskripsi;
    }


    public int getImage() {
        return Image;
    }



}
