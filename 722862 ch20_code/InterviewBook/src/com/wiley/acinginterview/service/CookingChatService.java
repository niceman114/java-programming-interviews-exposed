package com.wiley.acinginterview.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CookingChatService extends Service
{
    private static final String TAG = "CookingChatService";
    
    private ChatConnection connection;
    
    private final IBinder mBinder = new CookingChatBinder();

    @Override
    public void onCreate()
    {
        connection = new ChatConnection();
        super.onCreate();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        connection.connect();
        // restart in case the Service gets canceled
        return START_REDELIVER_INTENT;
    }    
    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }
    
    public ChatConnection getConnection()
    {
        return connection;
    }
    
    @Override
    public void onDestroy()
    {
        Log.d(TAG, "Chat Service SHUTDOWN");
        super.onDestroy();
    }
    
    public class CookingChatBinder extends Binder
    {
        public CookingChatService getService()
        {
            return CookingChatService.this;
        }
    }
}
