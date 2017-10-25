package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by akatsuki on 24/10/17.
 */

public class PollModelUserResponse {

    @SerializedName("userid")
    String id;
    @SerializedName("qid")
    String qid;
    @SerializedName("option")
    String option;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
