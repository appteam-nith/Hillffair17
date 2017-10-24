package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 15/10/17.
 */

public class SubCategoryQuizSingleModel {

    @SerializedName("Category_Name")
    private String name;

    @SerializedName("Category_Photo")
    private String photo;

    public SubCategoryQuizSingleModel(String name,String photo)
    {
        this.photo=photo;
        this.name = name;
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


