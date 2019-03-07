package com.wiley.acinginterview.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RecipeBackupServiceDoneReceiver extends BroadcastReceiver
{
    private static final String TAG = "RecipeBackupServiceDoneReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(TAG, "Received recipe backup complete: " + intent.getAction());
    }
}