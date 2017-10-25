package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sukhbir on 20/10/16.
 */

public class BattleEventResponse {

    @SerializedName("success")
    String success;

    @SerializedName("desc")
    private String eventdescription;

    @SerializedName("banner")
    private String photo;


    public BattleEventResponse(String success, String eventdescription, String photo) {
        this.success = success;
        this.eventdescription = eventdescription;
        this.photo = photo;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
