package com.nith.appteam.hillffair17.Utils;



import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.Activities.UploadNewsFeedActivity;
import com.nith.appteam.hillffair17.Fragments.FbLoginFragment;
import com.nith.appteam.hillffair17.Models.BattleDayModel;
import com.nith.appteam.hillffair17.Models.CategoryQuizModel;
import com.nith.appteam.hillffair17.Models.ClubModel2;
import com.nith.appteam.hillffair17.Models.GalleryDetailResponse;
import com.nith.appteam.hillffair17.Models.GalleryResponse;
import com.nith.appteam.hillffair17.Models.Likecount;
import com.nith.appteam.hillffair17.Models.NewsFeedResponse;
import com.nith.appteam.hillffair17.Models.PlotModel;
import com.nith.appteam.hillffair17.Models.PollModelUserResponse;
import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.Models.ProfileDataModel;
import com.nith.appteam.hillffair17.Models.ProfileEventModel;
import com.nith.appteam.hillffair17.Models.QuizQuestionsModel;
import com.nith.appteam.hillffair17.Models.RegisterResponse;
import com.nith.appteam.hillffair17.Models.SubCategoryQuizModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jatin on 9/11/2016.
 */

public interface APIINTERFACE {



    @GET("club")
    Call<EventActivity.ClubResponse> getAllClub();

    @GET("club/{club_name}")
    Call<ClubModel2> getClubInfo(@Path("club_name") String club_name);

    @GET("quiz/update/{id}")
    Call<UpdateScoreModel> updateScore(@Path("id") String id, @Query("score") int score);


    @GET("events/special")
    Call<BattleDayModel> getSpecialEvents();

    @GET("events/special/event")
    Call<com.nith.appteam.hillffair17.Activities.ClubActivity.BattleResponseEvent> getEventData(@Query("id") String id);

    @GET("Quiz_category")
    Call<CategoryQuizModel> getCategories();

    @GET("Quiz_Sub_Category")
    Call<SubCategoryQuizModel> getSubCategories(@Query("category")String category);

    @POST("newsfeed/like/{id}")
    Call<Likecount>likecount(@Path("id") String id, @Query("student_id") String userId);

    @GET("newsfeed/getall/{id}")
    Call<NewsFeedResponse> getAllNews(@Path("id") String userId, @Query("from") int from);

    @FormUrlEncoded
    @POST("newsfeed/post/{student_id}")
    Call<UploadNewsFeedActivity.UploadResponse> uploadNews(@Field("title") String title, @Field("desc") String description, @Path("student_id") String userId, @Field("name") String userName, @Field("photo") String imageUrl);


    @GET("quiz/get/{id}")
    Call<QuizQuestionsModel> getQuiz(@Path("id") String id,@Query("category") String category,@Query("topic") String topic);


    @GET("profile/{id}")
    Call<ProfileDataModel> profileBasicInfo(@Path("id") String id);

    @GET("profile/event/{id}")
    Call<ProfileEventModel> profileEventList(@Path("id") String id);

    @GET("profile/newsfeed/{student_id}")
    Call<NewsFeedResponse> getUserNews(@Path("student_id") String userId);

    @GET("gallery/{id}")
    Call<GalleryDetailResponse> getGalleryResponse(@Path("id") String id);

    @GET("galleryAll")
    Call<GalleryResponse> getGalleryAll();

    @POST("register")

    @FormUrlEncoded
    Call<FbLoginFragment.UserSentResponse> sendFbUserData(@Field("name") String name, @Field("email") String email, @Field("pic_url")String picUrl);

    @POST("update/rollno/{id}")
    Call<RegisterResponse> updateRollNo(@Path("id") String id, @Query("roll_no") String rollNo);


    //for poll
    @GET("poll/{uid}")
    Call<PollModel> getPoll(@Path("uid") String uid);
    @GET("stats/{qid}")
    Call<PlotModel>getStats(@Path("qid") String qid);//stats of a particular qid
    @GET("update/{qid}")
    Call<PollModelUserResponse>updateScore(@Field("userid") String uid, @Path("qid") String qid);
     @GET("allpolls/{id}")
    Call<ArrayList<PollModel>>getPastPoll(@Field("userid") String userid);
}


