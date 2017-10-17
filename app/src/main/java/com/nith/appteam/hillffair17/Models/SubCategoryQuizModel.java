package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 15/10/17.
 */

public class SubCategoryQuizModel {
    @SerializedName("Sub_Categories")
    private ArrayList<SubCategoryQuizSingleModel> subcategories;

    public SubCategoryQuizModel(ArrayList<SubCategoryQuizSingleModel> categories)
    {
        this.subcategories=categories;
    }

    public ArrayList<SubCategoryQuizSingleModel> getCategories() {
        return subcategories;
    }

    public void setCategories(ArrayList<SubCategoryQuizModel> categories) {
        this.subcategories = subcategories;
    }
}
