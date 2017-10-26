package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 26/8/17.
 */

public class SponsorItem {
    @SerializedName("name")
    private String sponsor_name;

    @SerializedName("img_url")
    public String image_id;

    public SponsorItem(String sponsor_name, String image_id)
    {
        this.sponsor_name = sponsor_name;
        this.image_id = image_id;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
}