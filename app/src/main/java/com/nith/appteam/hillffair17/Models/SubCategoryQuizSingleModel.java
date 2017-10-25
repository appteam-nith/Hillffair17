package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 15/10/17.
 */

public class SubCategoryQuizSingleModel {

    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("pic_url")
    private String photo;

    @SerializedName("category")
    private String category;

    public SubCategoryQuizSingleModel(String id, String name, String photo, String category) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


