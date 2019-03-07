package com.wiley.acinginterview.recipe.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiley.acinginterview.R;

public class RecipeDetailFragment extends Fragment
{
    public static final String RECIPE_ID_ARG = "RECIPE_ID_ARG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.recipe_detail, container, false);
    }

    public void loadRecipe(final String recipeId)
    {
        final TextView display = (TextView)getView().findViewById(R.id.tv_recipe_id);
        display.setText(recipeId);
        
        final TextView ingredients = (TextView)getView().findViewById(R.id.tv_ingredients);
        final TextView steps = (TextView)getView().findViewById(R.id.tv_steps);

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
