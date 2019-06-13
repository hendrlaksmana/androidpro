package com.example.sumbermakmur;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class DataModel {

    private String Item_name ;
    private String Item_price;
    private int Item_image ;


    public DataModel(String item_name, String item_price, int item_image ) {
        Item_image = item_image;
        Item_name = item_name;
        Item_price = item_price;

    }


    public String getItem_name() {
        return Item_name;
    }


    public String getItem_price() {
        return Item_price;
    }


    public int getItem_image() {
        return Item_image;
    }



}
