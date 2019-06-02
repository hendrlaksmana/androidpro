package com.example.sumbermakmur;

public class item {

    private String Image_name;
    private int Image;

    public item() {
    }

    public item(String image_name, int image) {
        Image_name = image_name;
        Image = image;
    }

    public String getImage_name() {
        return Image_name;
    }

    public int getImage() {
        return Image;
    }


    public void setImage_name(String image_name) {
        Image_name = image_name;
    }

    public void setImage(int image) {
        Image = image;
    }
}
