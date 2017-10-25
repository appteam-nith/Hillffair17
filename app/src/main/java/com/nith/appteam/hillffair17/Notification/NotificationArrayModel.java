package com.nith.appteam.hillffair17.Notification;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 25/10/17.
 */

public class NotificationArrayModel {

    @SerializedName("notifications")
    private ArrayList<notification_model> list;

    public NotificationArrayModel(ArrayList<notification_model> list) {
        this.list = list;
    }

    public ArrayList<notification_model> getList() {
        return list;
    }

    public void setList(ArrayList<notification_model> list) {
        this.list = list;
    }
}
