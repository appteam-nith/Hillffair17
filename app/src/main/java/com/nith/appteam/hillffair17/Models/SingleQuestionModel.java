package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jatin on 17/10/17.
 */

public class SingleQuestionModel implements Serializable {
    /*

      "_id": "580bc68669436e0011b73e5d",
      "qNo": 45,
      "question": "Which is the Most Densly Populated State in India?",
      "optionsA": "West Bengal",
      "optionsB": "Bihar",
      "optionsC": "UP",
      "optionsD": "Tamil Nadu",
      "isSingleChoice": true,
      "answer": "B"

    */

    @SerializedName("_id")
    private String id;

    @SerializedName("qNo")
    private int qno;

    @SerializedName("question")
    private String question;

    @SerializedName("optionA")
    private String optionsA;

    @SerializedName("optionB")
    private String optionsB;

    @SerializedName("optionC")
    private String optionsC;

    @SerializedName("optionD")
    private String optionsD;

    @SerializedName("answer")
    private String answer;

    @SerializedName("isSingleChoice")
    private boolean isSingleChoice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionsA() {
        return optionsA;
    }

    public void setOptionsA(String optionsA) {
        this.optionsA = optionsA;
    }

    public String getOptionsB() {
        return optionsB;
    }

    public void setOptionsB(String optionsB) {
        this.optionsB = optionsB;
    }

    public String getOptionsC() {
        return optionsC;
    }

    public void setOptionsC(String optionsC) {
        this.optionsC = optionsC;
    }

    public String getOptionsD() {
        return optionsD;
    }

    public void setOptionsD(String optionsD) {
        this.optionsD = optionsD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isSingleChoice() {
        return isSingleChoice;
    }

    public void setSingleChoice(boolean singleChoice) {
        isSingleChoice = singleChoice;
    }
}

