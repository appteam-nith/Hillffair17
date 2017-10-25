

package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Akatsuki on 3/23/2016.
 */
public class ClubEvent {
    @SerializedName("logo")
    private String image_id;
    @SerializedName("name")
    private String name;
    @SerializedName("_id")
    private String id;


    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
