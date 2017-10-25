package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by akatsuki on 26/10/17.
 */

public class PollListModel {

    @SerializedName("success")
    boolean success;

    @SerializedName("questions")
    ArrayList<Question> questions;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

  public  class Question{
        @SerializedName("_id")
        String id;

        @SerializedName("question")
        String question;

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }

      public String getQuestion() {
          return question;
      }

      public void setQuestion(String question) {
          this.question = question;
      }
  }
}

