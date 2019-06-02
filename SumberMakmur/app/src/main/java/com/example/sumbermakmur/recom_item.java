package com.example.sumbermakmur;

public class recom_item {


    private String Recom_name ;
    private String Recom_price;
    private int Recom_image ;

    public recom_item() {
    }

    public recom_item(String recom_name, String recom_price, int recom_image) {
        Recom_image = recom_image;
        Recom_name = recom_name;
        Recom_price = recom_price;
    }

    public String getRecom_name() { return Recom_name; }
    public String getRecom_price() { return Recom_price; }
    public int getRecom_image() { return Recom_image; }


    public void setRecom_name(String recom_name) { Recom_name = recom_name; }
    public void setRecom_price(String recom_price) { Recom_price = recom_price; }
    public void setRecom_image(int recom_image) { Recom_image = recom_image; }
}
