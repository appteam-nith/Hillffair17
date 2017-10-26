package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by akatsuki on 24/10/17.
 */

public class PollModel {

    @SerializedName("success")
    boolean done;
    @SerializedName("qNo")
    String qno;
    @SerializedName("qId")
    private String qid;
    @SerializedName("question")
    private String question;
    @SerializedName("optionA")
    private String optionA;
    @SerializedName("optionB")
    private String optionB;
    @SerializedName("optionC")
    private String optionC;
    @SerializedName("optionD")
    private String optionD;


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getQno() {
        return qno;
    }

    public void setQno(String qno) {
        this.qno = qno;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}

