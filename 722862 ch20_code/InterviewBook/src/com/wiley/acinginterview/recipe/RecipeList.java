package com.wiley.acinginterview.recipe;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class RecipeList extends ListActivity
{
    private BroadcastReceiver receiver;

    public static final String BUNDLE_SCROLL_POSITION = 
                               "BUNDLE_SCROLL_POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final List<String> recipes = getRecipes();
                
        // make a string adapter, then add an onclick
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, recipes);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id)
                    {
                        final String recipeClicked = recipes.get(position);
                        sendRecipeViewIntent(recipeClicked);
                    }
                });

        if (savedInstanceState != null
                && savedInstanceState.containsKey(BUNDLE_SCROLL_POSITION))
        {
            final int oldScrollPosition = savedInstanceState
                    .getInt(BUNDLE_SCROLL_POSITION);
            scrollTo(oldScrollPosition);
        }
    }
    
    private List<String> getRecipes()
    {
        //get from a db, but for now just hard code
        final List<String> recipes = Arrays.asList("Pizza", "Tasty Minestrone",
                "Broccoli", "Kale Chips");
        return recipes;
    }

    private void sendRecipeViewIntent(final String recipeId)
    {
        final Intent i = new Intent(this, RecipeDetail.class);
        i.putExtra(RecipeDetail.INTENT_RECIPE_ID, recipeId);
        startActivity(i);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        // which row in the recipe is the user looking at?
        // save this so the app can rescroll to that location
        // when the user returns
        final int scrollPosition = getScrollPosition();
        outState.putInt(BUNDLE_SCROLL_POSITION, scrollPosition);
        super.onSaveInstanceState(outState);
    }

    private int getScrollPosition()
    {
        final int scrollPosition = getListView().getFirstVisiblePosition();
        return scrollPosition;
    }

    private void scrollTo(final int scroll)
    {
        // scroll the list view to the given row
        getListView().setSelection(scroll);
    }

    @Override
    protected void onResume()
    {
        register();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        unregister();
        super.onPause();
    }

    private void register()
    {
        if (receiver == null)
        {
            receiver = new NewRecipeReceiver();
            final IntentFilter filter = new IntentFilter(
                    "com.wiley.acinginterview.NewRecipeAction");
            this.registerReceiver(receiver, filter);
        }
    }

    private void unregister()
    {
        if (receiver != null)
        {
            this.unregisterReceiver(receiver);
            receiver = null;
        }
    }

    private class NewRecipeReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            // add to the recipe list and refresh
        }
    }
}
