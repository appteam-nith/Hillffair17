package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by akatsuki on 24/10/17.
 */

public class PlotModel {

    @SerializedName("question")
    String question;
    @SerializedName("options")
    private ArrayList<String> options;
    @SerializedName("stats")
    private ArrayList<Integer> stats;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public ArrayList<Integer> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Integer> stats) {
        this.stats = stats;
    }
}
