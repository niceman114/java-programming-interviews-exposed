package com.wiley.acinginterview.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NetworkBroadcastReceiver extends BroadcastReceiver
{
    private static final String TAG = "NetworkBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(TAG, "network connection change: " + intent.getAction());
    }
}