package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by akatsuki on 24/10/17.
 */

public class PollModelUserResponse {

    @SerializedName("success")
    boolean success;
    @SerializedName("msg")
    String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
