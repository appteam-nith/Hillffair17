package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;
import com.nith.appteam.hillffair17.Activities.LeaderBoardActivity;

import java.util.ArrayList;

/**
 * Created by aditya on 25/10/17.
 */

public class LeaderBoardModel {

    @SerializedName("users")
    private ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users;

    public LeaderBoardModel(ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users) {
        this.users = users;
    }

    public ArrayList<LeaderBoardActivity.LeaderBoardUserModel> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users) {
        this.users = users;
    }
}
