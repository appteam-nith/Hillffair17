package com.nith.appteam.hillffair17.Utils;



import com.nith.appteam.hillffair17.Activities.ClubActivity;
import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.Activities.UploadNewsFeedActivity;
import com.nith.appteam.hillffair17.Fragments.FbLoginFragment;
import com.nith.appteam.hillffair17.Models.BattleDayModel;
import com.nith.appteam.hillffair17.Models.CategoryQuizModel;
import com.nith.appteam.hillffair17.Models.CategoryQuizSingleModel;
import com.nith.appteam.hillffair17.Models.ClubModel2;
import com.nith.appteam.hillffair17.Models.GalleryDetailResponse;
import com.nith.appteam.hillffair17.Models.GalleryResponse;
import com.nith.appteam.hillffair17.Models.LeaderBoardModel;
import com.nith.appteam.hillffair17.Models.Likecount;
import com.nith.appteam.hillffair17.Models.NewsFeedResponse;
import com.nith.appteam.hillffair17.Models.ProfileDataModel;
import com.nith.appteam.hillffair17.Models.ProfileEventModel;
import com.nith.appteam.hillffair17.Models.QuizQuestionsModel;
import com.nith.appteam.hillffair17.Models.RegisterResponse;
import com.nith.appteam.hillffair17.Models.SubCategoryQuizModel;
import com.nith.appteam.hillffair17.Notification.NotificationArrayModel;
import com.nith.appteam.hillffair17.Notification.notification_model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.cloudinary.Api.HttpMethod.GET;
import static com.cloudinary.Api.HttpMethod.POST;

/**
 * Created by Jatin on 9/11/2016.
 */

public interface APIINTERFACE {



    @GET("clubs")
    Call<EventActivity.ClubResponse> getAllClub();

    @GET("clubs/{club_id}")
    Call<ClubModel2> getClubInfo(@Path("club_id") String club_name);

    @GET("quiz/update/{id}")
    Call<UpdateScoreModel> updateScore(@Path("id") String id, @Query("score") int score);


    @GET("battleday")
    Call<BattleDayModel> getSpecialEvents();

    @GET("battleday/{battleid}")
    Call<com.nith.appteam.hillffair17.Activities.ClubActivity.BattleResponseEvent> getEventData(@Path("battleid") String id);

    @GET("quiz/category")
    Call<CategoryQuizModel> getCategories(@Query("type") String Category);

    @GET("quiz/subcategory")
    Call<SubCategoryQuizModel> getSubCategories(@Query("category")String category);

    @FormUrlEncoded
    @POST("newsfeed/like/{id}")
    Call<Likecount>likecount(@Path("id") String id, @Field("student_id") String userId);

    @GET("newsfeed/getall/{id}")
    Call<NewsFeedResponse> getAllNews(@Path("id") String userId, @Query("from") int from);

    @FormUrlEncoded
    @POST("newsfeed/post/{student_id}")
    Call<UploadNewsFeedActivity.UploadResponse> uploadNews(@Field("title") String title, @Field("desc") String description, @Path("student_id") String userId, @Field("name") String userName, @Field("photo") String imageUrl);

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

    @FormUrlEncoded
    @POST("register")
    Call<FbLoginFragment.UserSentResponse> sendFbUserData(@Field("name") String name, @Field("email") String email, @Field("pic_url")String picUrl);

    @POST("update/rollno/{id}")
    Call<RegisterResponse> updateRollNo(@Path("id") String id, @Query("roll_no") String rollNo);

    @GET("quiz/leaderboard")
    Call<LeaderBoardModel> getLeaderBoard();

    @POST("http://23.92.25.213/nithtpo/allnoti.php")
    Call<NotificationArrayModel> loadnotification();

    @FormUrlEncoded
    @POST("quiz/getSet/{student_id}")
    Call<QuizQuestionsModel> getQuiz(@Path("student_id") String id,@Field("category") String category,@Field("topic") String topic);



}


