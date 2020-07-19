package com.mx.gem.models;

public class Catitem {

    private String item_title,item_description;
    private int item_pic,item_qr;

    public Catitem(String item_title, String item_description, int item_pic, int item_qr) {
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_pic = item_pic;
        this.item_qr = item_qr;
    }

    public Catitem() {
    }


    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public int getItem_pic() {
        return item_pic;
    }

    public void setItem_pic(int item_pic) {
        this.item_pic = item_pic;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getItem_qr() {
        return item_qr;
    }

    public void setItem_qr(int item_qr) {
        this.item_qr = item_qr;
    }
}