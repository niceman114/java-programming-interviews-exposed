package com.wiley.acinginterview.recipe.frag;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class RecipeListFragment extends ListFragment
{
    private RecipeActions recipeActions;

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setRecipes();
    }

    /**
     * create the recipe list
     */
    public void setRecipes()
    {
        final List<String> recipes = getRecipes();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, recipes);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id)
                    {
                        final String recipeClicked = recipes.get(position);
                        recipeActions.showRecipe(recipeClicked);
                    }
                });
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        recipeActions = (RecipeActions) activity;
    }

    private List<String> getRecipes()
    {
        final List<String> recipes = Arrays.asList("Pizza", "Tasty Minestrone",
                "Broccoli", "Kale Chips");
        return recipes;
    }
}
