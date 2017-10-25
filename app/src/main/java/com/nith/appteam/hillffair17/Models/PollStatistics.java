package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by akatsuki on 26/10/17.
 */

public class PollStatistics {

    @SerializedName("success")
    boolean success;
    @SerializedName("question")
    String question;
    @SerializedName("optionA")
    String optionA;
    @SerializedName("optionB")
    String optionB;
    @SerializedName("optionC")
    String optionC;
    @SerializedName("optionD")
    String optionD;
    @SerializedName("optionA_users")
    String nOptionA;
    @SerializedName("optionB_users")
    String nOptionB;
    @SerializedName("optionC_users")
    String nOptionC;
    @SerializedName("optionD_users")
    String nOptionD;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getnOptionA() {
        return nOptionA;
    }

    public void setnOptionA(String nOptionA) {
        this.nOptionA = nOptionA;
    }

    public String getnOptionB() {
        return nOptionB;
    }

    public void setnOptionB(String nOptionB) {
        this.nOptionB = nOptionB;
    }

    public String getnOptionC() {
        return nOptionC;
    }

    public void setnOptionC(String nOptionC) {
        this.nOptionC = nOptionC;
    }

    public String getnOptionD() {
        return nOptionD;
    }

    public void setnOptionD(String nOptionD) {
        this.nOptionD = nOptionD;
    }
}
