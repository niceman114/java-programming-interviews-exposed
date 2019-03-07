package com.wiley.acinginterview.service;

import android.util.Log;

public class ChatConnection
{
    private static final String TAG = "ChatConnection";
    
    public void sendMessage(String send)
    {
        Log.d(TAG, "send message: " + send);
    }
    
    public boolean isConnected()
    {
        return true;
    }
    
    public void connect()
    {
        
    }

}
