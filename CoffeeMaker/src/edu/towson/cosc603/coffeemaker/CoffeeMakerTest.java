package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		//create new recipe icey
        r2 = new Recipe();
        r2.setName(" icey");
        r2.setPrice(25);
        r2.setAmtCoffee(6);
        r2.setAmtMilk(2);
        r2.setAmtSugar(2);
        r2.setAmtChocolate(3);
		//create new recipe grenntea
        r3 = new Recipe();
        r3.setName("grenntea");
        r3.setPrice(35);
        r3.setAmtCoffee(5);
        r3.setAmtMilk(2);
        r3.setAmtSugar(2);
        r3.setAmtChocolate(2);
    	//create new recipe strawberry
        r4 = new Recipe();
        r4.setName("strawberry");
        r4.setPrice(40);
        r4.setAmtCoffee(2);
        r4.setAmtMilk(2);
        r4.setAmtSugar(2);
        r4.setAmtChocolate(4);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
    public void testMakeCoffee1() {
        cm.addRecipe(r2);
        //here we can find the bug of inverntary of coffe is increasing ,it should reduce
        assertEquals(75, cm.makeCoffee(r2, 100));
        assertEquals(9, cm.checkInventory().getCoffee());
        assertEquals(13, cm.checkInventory().getMilk());
        assertEquals(13, cm.checkInventory().getSugar());
        assertEquals(12, cm.checkInventory().getChocolate());
        
}
    public void testMakeCoffee2()
    {
            //test input as 0 to see is that return the 0
            assertEquals(0, cm.makeCoffee(r4, 0));
            //test if the insert money is less than the money of coffe
            assertEquals(30, cm.makeCoffee(r4, 30));
    }
    /**
     * Test adding coffee to Coffee Maker.
     */

    public void testAddInventory()
    {
    	//test add inventary to see all works as positive number and value increased
            assertTrue(cm.addInventory(5, 1, 2, 3));
            assertEquals(20, cm.checkInventory().getCoffee());
            assertEquals(16, cm.checkInventory().getMilk());
            assertEquals(17, cm.checkInventory().getSugar());
            assertEquals(18, cm.checkInventory().getChocolate());
    }
   
    public void testAddInventory2()
    {
            //false case if it is inserting negtive numbers
            assertFalse(cm.addInventory(-1, 0, 0, 0));
            assertFalse(cm.addInventory(0, -1, 0, 0));
            assertFalse(cm.addInventory(0, 0, -1, 0));
            assertFalse(cm.addInventory(0, 0, 0, -1));
            
    }
    public void testGetRecipeForName() {
        cm.addRecipe(r4);
        assertEquals("strawberry", cm.getRecipeForName("strawberry").getName());
}
    public void testRecipeArray() {
    	   cm.addRecipe(r1);
           cm.addRecipe(r2);
           cm.addRecipe(r3);
           cm.addRecipe(r4);
           Recipe[] raytesting = {r1,r2, r3, r4};
           assertEquals(raytesting [0], cm.getRecipes()[3]);               
           assertEquals(raytesting [1], cm.getRecipes()[2]);
           assertEquals(raytesting [2], cm.getRecipes()[1]);
           assertEquals(raytesting [3], cm.getRecipes()[0]);
    }    
}