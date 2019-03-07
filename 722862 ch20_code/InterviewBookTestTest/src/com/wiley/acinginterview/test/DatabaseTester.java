package com.wiley.acinginterview.test;

import com.wiley.acinginterview.db.DatabaseHelper;

import android.test.AndroidTestCase;

public class DatabaseTester extends AndroidTestCase
{
    public void TestDbQuery()
    {
        DatabaseHelper helper = DatabaseHelper.getInstance(getContext());
        helper.insertNameAges(new String [] {"John, Sandra"}, new int [] {21, 25}, getContext());
        assertTrue(helper.queryForAge("John", getContext()) == 21);
        assertTrue(helper.queryForAge("Sandra", getContext()) == 25);
        assertTrue(helper.queryForAge("No One", getContext()) == -1);
    }
}
