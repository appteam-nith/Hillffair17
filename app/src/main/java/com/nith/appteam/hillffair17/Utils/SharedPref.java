package com.nith.appteam.hillffair17.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.nith.appteam.hillffair17.Activities.BattleDayActivity;
import com.nith.appteam.hillffair17.Activities.ClubActivity;
import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by octacode on 25/8/17.
 */

public class SharedPref {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME="UserInfo";
    private static final String IS_FIRST_TIME="isfirstTime";

    public SharedPref(EventActivity eventActivity) {
    }
    public SharedPref(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public SharedPref(BattleDayActivity battleDayActivity) {
    }

    public SharedPref(ClubActivity clubActivity) {
    }

    public static boolean getFirstRun(Context context) {
        return context.getSharedPreferences(context.getString(R.string.preference), MODE_PRIVATE).getBoolean(context.getString(R.string.is_first_run), true);
    }

    public static void setFirstRun(Context context) {
        context.getSharedPreferences(context.getString(R.string.preference), MODE_PRIVATE).edit().putBoolean(context.getString(R.string.is_first_run), false).apply();
    }

    public boolean showIsFirstTime(){
        return sharedPreferences.getBoolean(IS_FIRST_TIME,false);
    }
    public void setIsFirstTime(){
        editor.putBoolean(IS_FIRST_TIME,true);
        editor.commit();
    }
}
