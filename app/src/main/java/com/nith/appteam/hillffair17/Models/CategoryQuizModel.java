package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 13/10/17.
 */

public class CategoryQuizModel {

    @SerializedName("success")
    private boolean success;

    @SerializedName("category")
    private ArrayList<CategoryQuizSingleModel> categories;

    public CategoryQuizModel(boolean success, ArrayList<CategoryQuizSingleModel> categories) {
        this.success = success;
        this.categories = categories;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<CategoryQuizSingleModel> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryQuizSingleModel> categories) {
        this.categories = categories;
    }
}
