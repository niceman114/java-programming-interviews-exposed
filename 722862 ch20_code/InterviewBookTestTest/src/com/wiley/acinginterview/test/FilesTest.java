package com.wiley.acinginterview.test;

import android.os.Environment;
import android.test.AndroidTestCase;

public class FilesTest extends AndroidTestCase
{
    public void testFileStorage()
    {
        if (!isExternalStorageWritable())
        {
            fail("External storage not writable");
        }

        //path for the SD card
        String root = Environment.getRootDirectory().getAbsolutePath();
        //path for external files that Android deletes upon uninstall 
        String externalFilesDir = getContext().
                getExternalFilesDir("myfiles").getAbsolutePath();
        assertTrue(externalFilesDir
             .contains("Android/data/com.wiley.interviewbook/files/myfiles"));
        //path to internal storage directory 
        String interalFilesDir = getContext().getFilesDir().getAbsolutePath();
        assertTrue(interalFilesDir
                .contains("/data/data/com.wiley.interviewbook/files"));
    }
    
    private boolean isExternalStorageWritable()
    {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            return true;
        }
        return false;
    }
}