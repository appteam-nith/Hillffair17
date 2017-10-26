package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 26/10/17.
 */

public class SponsorArrayModel {

    @SerializedName("success")
    private String success;

    @SerializedName("msg")
    private String msg;

    @SerializedName("sponsors")
    private ArrayList<SponsorItem> sponsors;


    public SponsorArrayModel(String success, String msg, ArrayList<SponsorItem> sponsors) {
        this.success = success;
        this.msg = msg;
        this.sponsors = sponsors;
    }


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<SponsorItem> getSponsors() {
        return sponsors;
    }

    public void setSponsors(ArrayList<SponsorItem> sponsors) {
        this.sponsors = sponsors;
    }
}
