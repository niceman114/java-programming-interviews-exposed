package com.wiley.acinginterview.takepicture;

import android.app.Activity;
import android.os.Bundle;

import com.wiley.acinginterview.R;

/**
 * shows a version of take picture with
 * camera button in front of the image
 */
public class TakePictureActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontof);
    }
}
