package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 13/10/17.
 */

public class CategoryQuizSingleModel {

    @SerializedName("_id")
    String id;

    @SerializedName("name")
    private String name;

    @SerializedName("pic_url")
    private String photo;

    public CategoryQuizSingleModel(String id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
