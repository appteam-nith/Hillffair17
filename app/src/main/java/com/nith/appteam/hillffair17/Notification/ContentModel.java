package com.nith.appteam.hillffair17.Notification;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 25/10/17.
 */

public class ContentModel {
    @SerializedName("en")
    private String title;

    public ContentModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
