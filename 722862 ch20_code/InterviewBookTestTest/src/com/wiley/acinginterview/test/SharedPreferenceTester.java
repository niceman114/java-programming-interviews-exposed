package com.wiley.acinginterview.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.test.AndroidTestCase;

public class SharedPreferenceTester extends AndroidTestCase
{
    public void testSaveName()
    {
        final String PREF_NAME = "name";
        final String PREF_NAME_DEFAULT = "none";
        final String PREF_NAME_SET = "Shooting Star";
        SharedPreferences preferences = getContext().getSharedPreferences(
                "Test", Context.MODE_PRIVATE);

        //write a value
        Editor editor = preferences.edit();
        editor.putString(PREF_NAME, PREF_NAME_SET);
        editor.commit();
        
        //read a value
        String pref = preferences.getString(PREF_NAME, PREF_NAME_DEFAULT);
        assertTrue("pref now set", pref.equals(PREF_NAME_SET));
    }

}
