package com.wiley.acinginterview.recipe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.wiley.acinginterview.R;

public class RecipeDetail extends Activity
{
    public static final String INTENT_RECIPE_ID = "INTENT_RECIPE_ID";
    
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);
        if (getIntent() != null)
        {
            if (getIntent().hasExtra(INTENT_RECIPE_ID))
            {
                final String recipeId = getIntent().getStringExtra(INTENT_RECIPE_ID);
                //access database, populate display, etc...
                loadRecipe(recipeId);
            }
        }
    }
    
    private void loadRecipe(final String recipeId)
    {
        final TextView display = (TextView)findViewById(R.id.tv_recipe_id);
        display.setText(recipeId);
        
        final TextView ingredients = (TextView) findViewById(R.id.tv_ingredients);
        final TextView steps = (TextView) findViewById(R.id.tv_steps);

        //only include one recipe :)
        if (recipeId.contains("Minestrone"))
        {
            ingredients.setText("1 onion\n" + "3 carrots\n" + "1 zuccinni\n"
                    + "6 cups vegetable broth\n");
            steps.setText("1. Cook all vegetables for 5 minutes\n"
                    + "2. Cook for 10 minutes\n" + "3. Add vegetable broth\n"
                    + "4. Cook for 30 mninutes\n");
        }
        else
        {
            ingredients.setText("");
            steps.setText("");
        }
    }
}
