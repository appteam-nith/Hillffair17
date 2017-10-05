package com.nith.appteam.hillffair17.Models;

/**
 * Created by aditya on 26/8/17.
 */


public class HomeModel {
    private int photo_id;
    private String name;
    private int bg_color;

    public HomeModel(int photo_id, String name, int bg_color) {
        this.photo_id = photo_id;
        this.name = name;
        this.bg_color = bg_color;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBg_color() {
        return bg_color;
    }

    public void setBg_color(int bg_color) {
        this.bg_color = bg_color;
    }

}
