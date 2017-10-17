package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 13/10/17.
 */

public class CategoryQuizModel {

    @SerializedName("Categories")
    private ArrayList<CategoryQuizSingleModel> categories;

    public CategoryQuizModel(ArrayList<CategoryQuizSingleModel> categories)
    {
        this.categories=categories;
    }

    public ArrayList<CategoryQuizSingleModel> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryQuizSingleModel> categories) {
        this.categories = categories;
    }
}
