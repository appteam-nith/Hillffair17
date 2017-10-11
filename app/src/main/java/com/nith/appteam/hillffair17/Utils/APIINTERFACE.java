package com.nith.appteam.hillffair17.Utils;



import com.nith.appteam.hillffair17.Activities.ClubActivity;
import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.Models.BattleDayModel;
import com.nith.appteam.hillffair17.Models.ClubModel2;

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



    @GET("club")
    Call<EventActivity.ClubResponse> getAllClub();

    @GET("club/{club_name}")
    Call<ClubModel2> getClubInfo(@Path("club_name") String club_name);


    @GET("events/special")
    Call<BattleDayModel> getSpecialEvents();

    @GET("events/special/event")
    Call<com.nith.appteam.hillffair17.Activities.ClubActivity.BattleResponseEvent> getEventData(@Query("id") String id);



}


