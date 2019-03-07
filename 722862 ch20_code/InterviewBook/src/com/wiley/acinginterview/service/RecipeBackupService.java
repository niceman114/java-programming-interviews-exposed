package com.wiley.acinginterview.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class RecipeBackupService extends IntentService
{
    private static final String TAG = "RecipeBackupService";
    
    private static final String BACKUP_COMPLETE = "BACKUP_COMPLETE";
    
    public RecipeBackupService()
    {
        //name service for debugging purposes
        super("RecipeBackupService");
    }
    
    @Override
    protected void onHandleIntent(Intent workIntent)
    {
        //TODO: backup recipes...
        Log.d(TAG, "Backup complete");
        
        //then communicate with app
        broadcastComplete();
    }
    
    private void broadcastComplete()
    {
        final Intent i = new Intent(BACKUP_COMPLETE);
        sendBroadcast(i);
    }
}
