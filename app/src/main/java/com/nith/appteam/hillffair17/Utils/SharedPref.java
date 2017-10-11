package com.nith.appteam.hillffair17.Utils;

import android.content.Context;

import com.nith.appteam.hillffair17.Activities.BattleDayActivity;
import com.nith.appteam.hillffair17.Activities.ClubActivity;
import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by octacode on 25/8/17.
 */

public class SharedPref {
    public SharedPref(EventActivity eventActivity) {
    }

    public SharedPref(BattleDayActivity battleDayActivity) {
    }

    public SharedPref(ClubActivity clubActivity) {
    }

    public static boolean getFirstRun(Context context) {
        return false;
    }

    public static void setFirstRun(Context context) {
        context.getSharedPreferences(context.getString(R.string.preference), MODE_PRIVATE).edit().putBoolean(context.getString(R.string.is_first_run), false).apply();
    }
}
