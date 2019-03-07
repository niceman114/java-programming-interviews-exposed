package com.wiley.acinginterview.recipe;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class RecipeListPlain extends ListActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //make a string adapter, then add an onclick
        final List<String> recipes = Arrays.asList("Pizza", "Tasty Minestrone",
                "Broccoli", "Kale Chips");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
            (this, android.R.layout.simple_list_item_1, recipes);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id)
            {
                final String recipeClicked = recipes.get(position);
                sendRecipeViewIntent(recipeClicked);
            }
        });
    }
    
    private void sendRecipeViewIntent(final String recipeId)
    {
        final Intent i = new Intent(this, RecipeDetail.class);
        i.putExtra(RecipeDetail.INTENT_RECIPE_ID, recipeId);
        startActivity(i);
    }
}
