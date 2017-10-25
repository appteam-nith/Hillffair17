package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 15/10/17.
 */

public class SubCategoryQuizModel {

    @SerializedName("success")
    private boolean success;

    @SerializedName("category")
    private ArrayList<SubCategoryQuizSingleModel> subcategories;

    public SubCategoryQuizModel(boolean success, ArrayList<SubCategoryQuizSingleModel> subcategories) {
        this.success = success;
        this.subcategories = subcategories;
    }

    public ArrayList<SubCategoryQuizSingleModel> getCategories() {
        return subcategories;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCategories(ArrayList<SubCategoryQuizModel> categories) {
        this.subcategories = subcategories;
    }
}
