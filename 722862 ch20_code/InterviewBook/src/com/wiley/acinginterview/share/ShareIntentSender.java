package com.wiley.acinginterview.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wiley.acinginterview.R;

/**
 * sends the ShareIntent
 */
public class ShareIntentSender extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.share_button);

        findViewById(R.id.bt_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendShareIntent();
            }
        });
        super.onCreate(savedInstanceState);
    }
    
    private void sendShareIntent()
    {
        final Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Share Me!");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
