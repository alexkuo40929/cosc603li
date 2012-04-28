package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	//set the initial value and give some recipe 
	private CoffeeMaker maker1;
	private Inventory i;
	private Recipe ray1;
	private Recipe ray2;
	private Recipe ray3;
	private Recipe ray4;

	public void setUp() {
		maker1 = new CoffeeMaker();
		i = maker1.checkInventory();

		ray1 = new Recipe();
		ray1.setName("Coffee");
		ray1.setPrice(50);
		ray1.setAmtCoffee(6);
		ray1.setAmtMilk(1);
		ray1.setAmtSugar(1);
		ray1.setAmtChocolate(0);
		//create new recipe icey
        ray2 = new Recipe();
        ray2.setName(" icey");
        ray2.setPrice(25);
        ray2.setAmtCoffee(6);
        ray2.setAmtMilk(2);
        ray2.setAmtSugar(2);
        ray2.setAmtChocolate(3);
		//create new recipe grenntea
        ray3 = new Recipe();
        ray3.setName("grenntea");
        ray3.setPrice(35);
        ray3.setAmtCoffee(5);
        ray3.setAmtMilk(2);
        ray3.setAmtSugar(2);
        ray3.setAmtChocolate(2);
    	//create new recipe strawberry
        ray4 = new Recipe();
        ray4.setName("strawberry");
        ray4.setPrice(40);
        ray4.setAmtCoffee(2);
        ray4.setAmtMilk(2);
        ray4.setAmtSugar(2);
        ray4.setAmtChocolate(4);
	}

	public void testAddRecipe1() {
		assertTrue(maker1.addRecipe(ray1));
	}

	public void testDeleteRecipe1() {
		maker1.addRecipe(ray1);
		assertTrue(maker1.deleteRecipe(ray1));
	}

	public void testEditRecipe1() {
		maker1.addRecipe(ray1);
		Recipe newRecipe = new Recipe();
		newRecipe = ray1;
		newRecipe.setAmtSugar(2);
		assertTrue(maker1.editRecipe(ray1, newRecipe));
	}
	
    public void testMakeCoffee1() {
        maker1.addRecipe(ray2);
        //here we can find the bug of inverntary of coffe is increasing ,it should reduce
        assertEquals(75, maker1.makeCoffee(ray2, 100));
        assertEquals(9, maker1.checkInventory().getCoffee());
        assertEquals(13, maker1.checkInventory().getMilk());
        assertEquals(13, maker1.checkInventory().getSugar());
        assertEquals(12, maker1.checkInventory().getChocolate());
        
}
    public void testMakeCoffee2()
    {
            //test input as 0 to see is that return the 0
            assertEquals(0, maker1.makeCoffee(ray4, 0));
            //test if the insert money is less than the money of coffe
            assertEquals(30, maker1.makeCoffee(ray4, 30));
    }
    /**
     * Test adding coffee to Coffee Maker.
     */

    public void testAddInventory()
    {
    	//test add inventary to see all works as positive number and value increased
            assertTrue(maker1.addInventory(5, 1, 2, 3));
            assertEquals(20, maker1.checkInventory().getCoffee());
            assertEquals(16, maker1.checkInventory().getMilk());
            assertEquals(17, maker1.checkInventory().getSugar());
            assertEquals(18, maker1.checkInventory().getChocolate());
    }
   
    public void testAddInventory2()
    {
            //false case if it is inserting negtive numbers
            assertFalse(maker1.addInventory(-1, 0, 0, 0));
            assertFalse(maker1.addInventory(0, -1, 0, 0));
            assertFalse(maker1.addInventory(0, 0, -1, 0));
            assertFalse(maker1.addInventory(0, 0, 0, -1));
            
    }
    public void testGetRecipeForName() {
    	//compare the recipt set name function to see can we recive the correc name.
        maker1.addRecipe(ray4);
        assertEquals("strawberry", maker1.getRecipeForName("strawberry").getName());
}
    public void testRecipeArray() {
    	//to test how the array store the recipe 
    	   maker1.addRecipe(ray1);
           maker1.addRecipe(ray2);
     
           Recipe[] raytesting = {ray1,ray2,};
           assertEquals(raytesting [0], maker1.getRecipes()[3]);               
           assertEquals(raytesting [1], maker1.getRecipes()[2]);

    }    
}