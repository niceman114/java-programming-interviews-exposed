package com.wiley.acinginterview.lifecycle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class ActivityLifecycleTest extends Activity
{
    private BroadcastReceiver receiver;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume()
    {
        register();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        unregister();
        super.onPause();
    }

    private void register()
    {
        if (receiver == null)
        {
            receiver = new NewRecipeReceiver();
            final IntentFilter filter = new IntentFilter(
                "com.wiley.interviewbook.NewRecipeAction");
            this.registerReceiver(receiver, filter);
        }
    }

    private void unregister()
    {
        if (receiver != null)
        {
            this.unregisterReceiver(receiver);
            receiver = null;
        }
    }

    private class NewRecipeReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            //add to the recipe list
        }
    }
}
