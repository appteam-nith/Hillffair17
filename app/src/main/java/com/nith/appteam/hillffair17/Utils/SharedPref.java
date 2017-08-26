package com.nith.appteam.hillffair17.Utils;

import android.content.Context;

import com.nith.appteam.hillffair17.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by octacode on 25/8/17.
 */

public class SharedPref {
    public static boolean getFirstRun(Context context) {
        return context.getSharedPreferences(context.getString(R.string.preference), MODE_PRIVATE).getBoolean(context.getString(R.string.is_first_run), true);
    }

    public static void setFirstRun(Context context) {
        context.getSharedPreferences(context.getString(R.string.preference), MODE_PRIVATE).edit().putBoolean(context.getString(R.string.is_first_run), false).apply();
    }
}
