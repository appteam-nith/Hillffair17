package com.nith.appteam.hillffair17.Notification;

import com.google.gson.annotations.SerializedName;
import com.nith.appteam.hillffair17.Adapters.Notification;

/**
 * Created by root on 8/30/16.
 */
public class notification_model {

    @SerializedName("id")
    private String id;

    @SerializedName("headings")
    private ContentModel title;

    @SerializedName("contents")
    private ContentModel body;

    @SerializedName("adm_big_picture")
    private String img;

    private String small_icon;;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public ContentModel getTitle() {
        return title;
    }

    public void setTitle(ContentModel title) {
        this.title = title;
    }

    public ContentModel getBody() {
        return body;
    }

    public void setBody(ContentModel body) {
        this.body = body;
    }

    private String notification_id;


    public String getBigpicture() {
        return bigpicture;
    }

    public void setBigpicture(String bigpicture) {
        this.bigpicture = bigpicture;
    }

    String bigpicture;

    public String getLaunchurl() {
        return launchurl;
    }

    public void setLaunchurl(String launchurl) {
        this.launchurl = launchurl;
    }

    String launchurl;



    public String getSmall_icon() {
        return small_icon;
    }

    public void setSmall_icon(String small_icon) {
        this.small_icon = small_icon;
    }


       public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    
}
