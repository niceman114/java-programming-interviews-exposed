package com.wiley.acinginterview.recipe.frag;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.wiley.acinginterview.R;

public class RecipeViewAsFragments extends FragmentActivity implements RecipeActions
{
    private RecipeDetailFragment recipeDetail;

    private RecipeListFragment recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_by_side);
        
        recipeDetail = (RecipeDetailFragment) 
                getSupportFragmentManager().findFragmentById(R.id.frag_recipe_detail);
        recipeList = (RecipeListFragment) 
                getSupportFragmentManager().findFragmentById(R.id.frag_recipe_list);
        hideRecipeDetail();
    }
    
    @Override
    public void showRecipe(String recipeId)
    {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.show(recipeDetail);
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.addToBackStack("show recipe");
        ft.commit();
        
        recipeDetail.loadRecipe(recipeId);
    }

    public void hideRecipeDetail()
    {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(recipeDetail);
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.commit();        
    }

}