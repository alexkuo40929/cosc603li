// This is mutant program.
// Author : ysma

package edu.towson.cosc603.coffeemaker;


public class CoffeeMaker
{

    private edu.towson.cosc603.coffeemaker.Recipe[] recipeArray;

    private final int NUM_RECIPES = 4;

    private boolean[] recipeFull;

    private edu.towson.cosc603.coffeemaker.Inventory inventory;

    public CoffeeMaker()
    {
        recipeArray = new edu.towson.cosc603.coffeemaker.Recipe[NUM_RECIPES];
        recipeFull = new boolean[NUM_RECIPES];
        for (int i = 0; i < NUM_RECIPES; i++) {
            recipeArray[i] = new edu.towson.cosc603.coffeemaker.Recipe();
            recipeFull[i] = false;
        }
        inventory = new edu.towson.cosc603.coffeemaker.Inventory();
    }

    public boolean addRecipe( edu.towson.cosc603.coffeemaker.Recipe r )
    {
        boolean canAddRecipe = true;
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (r.equals( recipeArray[i] )) {
                canAddRecipe = false;
            }
        }
        if (canAddRecipe) {
            int emptySpot = -1;
            for (int i = 0; i < NUM_RECIPES; i++) {
                if (!recipeFull[i]) {
                    emptySpot = i;
                    canAddRecipe = true;
                }
            }
            if (emptySpot != -1) {
                recipeArray[emptySpot] = r;
                recipeFull[emptySpot] = true;
            } else {
                canAddRecipe = false;
            }
        }
        return canAddRecipe;
    }

    public boolean deleteRecipe( edu.towson.cosc603.coffeemaker.Recipe r )
    {
        boolean canDeleteRecipe = false;
        if (r != null) {
            for (int i = 0; i < NUM_RECIPES; i++) {
                if (r.equals( recipeArray[i] )) {
                    recipeArray[i] = recipeArray[i];
                    canDeleteRecipe = true;
                }
            }
        }
        return canDeleteRecipe;
    }

    public boolean editRecipe( edu.towson.cosc603.coffeemaker.Recipe oldRecipe, edu.towson.cosc603.coffeemaker.Recipe newRecipe )
    {
        boolean canEditRecipe = false;
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (recipeArray[i].getName() != null) {
                if (newRecipe.equals( recipeArray[i] )) {
                    recipeArray[i] = new edu.towson.cosc603.coffeemaker.Recipe();
                    if (addRecipe( newRecipe )) {
                        canEditRecipe = true;
                    } else {
                        canEditRecipe = false;
                    }
                }
            }
        }
        return !canEditRecipe;
    }

    public boolean addInventory( int amtCoffee, int amtMilk, int amtSugar, int amtChocolate )
    {
        boolean canAddInventory = true;
        if (amtCoffee < 0 || amtMilk < 0 || amtSugar < 0 || amtChocolate < 0) {
            canAddInventory = false;
        } else {
            inventory.setCoffee( inventory.getCoffee() + amtCoffee );
            inventory.setMilk( inventory.getMilk() + amtMilk );
            inventory.setSugar( inventory.getSugar() + amtSugar );
            inventory.setChocolate( inventory.getChocolate() + amtChocolate );
        }
        return canAddInventory;
    }

    public edu.towson.cosc603.coffeemaker.Inventory checkInventory()
    {
        return inventory;
    }

    public int makeCoffee( edu.towson.cosc603.coffeemaker.Recipe r, int amtPaid )
    {
        boolean canMakeCoffee = true;
        if (amtPaid < r.getPrice()) {
            canMakeCoffee = false;
        }
        if (!inventory.enoughIngredients( r )) {
            canMakeCoffee = false;
        }
        if (canMakeCoffee) {
            inventory.setCoffee( inventory.getCoffee() - r.getAmtCoffee() );
            inventory.setMilk( inventory.getMilk() - r.getAmtMilk() );
            inventory.setSugar( inventory.getSugar() - r.getAmtSugar() );
            inventory.setChocolate( inventory.getChocolate() - r.getAmtChocolate() );
            return amtPaid - r.getPrice();
        } else {
            return amtPaid;
        }
    }

    public edu.towson.cosc603.coffeemaker.Recipe[] getRecipes()
    {
        return recipeArray;
    }

    public edu.towson.cosc603.coffeemaker.Recipe getRecipeForName( java.lang.String name )
    {
        edu.towson.cosc603.coffeemaker.Recipe r = new edu.towson.cosc603.coffeemaker.Recipe();
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (recipeArray[i].getName() != null) {
                if (recipeArray[i].getName().equals( name )) {
                    r = recipeArray[i];
                }
            }
        }
        return r;
    }

}
