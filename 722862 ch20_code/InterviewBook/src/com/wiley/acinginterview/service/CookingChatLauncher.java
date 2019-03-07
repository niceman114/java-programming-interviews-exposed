package com.wiley.acinginterview.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wiley.acinginterview.R;
import com.wiley.acinginterview.service.CookingChatService.CookingChatBinder;

public class CookingChatLauncher extends Activity
{
    private static final String TAG = "CookingChatLauncher";
    
    private boolean bound;
    
    private CookingChatBinder binder;
    
    private EditText message;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        findViewById(R.id.bt_send).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                sendMessage();
            }
        });
        message = (EditText)findViewById(R.id.et_message);
    }
    
    private void sendMessage()
    {
        if (bound && binder != null)
        {
            final String messageToSend = message.getText().toString();
            binder.getService().getConnection()
                    .sendMessage(messageToSend);
            Toast.makeText(this, "Message sent: " + messageToSend,
                    Toast.LENGTH_SHORT).show();
        }
    }

    //Note: use onStart and onStop so that the app doesn't spend a lot
    //of time reconnecting, but still will release the resources should
    //app terminate
    @Override
    public void onStart()
    {
        if (!bound)
        {
            Log.d(TAG, "not bound, binding to the service");
            final Intent intent = new Intent(this, CookingChatService.class);
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        }
        super.onStart();
    }

    @Override
    public void onStop()
    {
        if (bound)
        {
            Log.d(TAG, "unbinding to service");
            unbindService(serviceConnection);
            bound = false;
        }
        super.onStop();
    }
    
    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service)
        {
            Log.d(TAG, "service connected");
            binder = (CookingChatBinder) service;
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0)
        {
            bound = false;
        }
    };
}
