package com.wiley.acinginterview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wiley.acinginterview.location.LocationActivity;
import com.wiley.acinginterview.recipe.RecipeList;
import com.wiley.acinginterview.recipe.frag.RecipeViewAsFragments;
import com.wiley.acinginterview.service.CookingChatLauncher;
import com.wiley.acinginterview.service.RecipeBackupService;
import com.wiley.acinginterview.share.ShareIntentSender;
import com.wiley.acinginterview.takepicture.TakePictureActivity;
import com.wiley.acinginterview.takepicture.TakePictureActivityButtonOnBottom;

/**
 * has buttons for all the various test code
 */
public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setup();
    }
    
    private void setup()
    {
        findViewById(R.id.bt_recipe).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, RecipeList.class);
                startActivity(i);
            }
        });
        
        findViewById(R.id.bt_start_backup_service).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, RecipeBackupService.class);
                startService(i);
            }
        });
                

        findViewById(R.id.bt_recipe_frag).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, RecipeViewAsFragments.class);
                startActivity(i);
            }
        });

        findViewById(R.id.bt_button_in_front).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, TakePictureActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.bt_button_on_bottom).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, TakePictureActivityButtonOnBottom.class);
                startActivity(i);
            }
        });

        findViewById(R.id.bt_share_intent_sender).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, ShareIntentSender.class);
                startActivity(i);
            }
        });
        
        findViewById(R.id.bt_cooking_chat).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, CookingChatLauncher.class);
                startActivity(i);
            }
        });
        
        
        findViewById(R.id.bt_location).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(i);
            }
        });
    }
}
