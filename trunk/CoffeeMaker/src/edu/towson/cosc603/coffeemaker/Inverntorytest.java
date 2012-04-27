package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;


public class Inverntorytest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();
    	//create new recipe strawberry
        r1 = new Recipe();
        r1.setName("strawberry");
        r1.setPrice(40);
        r1.setAmtCoffee(2);
        r1.setAmtMilk(2);
        r1.setAmtSugar(2);
        r1.setAmtChocolate(4);
	}
	
	
    public void testToString1() {
    	//test the output result of after make coffee to see is that inventary correct. 
    	cm.makeCoffee(r1, 100);
        assertEquals("Coffee: 13\nMilk: 13\nSugar: 13\nChocolate: 11\n",
                        i.toString());
}
    public void testEnoughIngredients1() {
    	//test different settings for the ingredient to see is that combination could be 
        assertTrue(i.enoughIngredients(r1));

        i.setCoffee(1);
        assertFalse(i.enoughIngredients(r1));

        i.setMilk(0);
        assertFalse(i.enoughIngredients(r1));

        i.setSugar(0);
        i.setChocolate(2);
        assertFalse(i.enoughIngredients(r1));

       

}
}