package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;


public class Inverntorytest extends TestCase {
	private CoffeeMaker maker1;
	private Inventory i;
	private Recipe ray1;

	public void setUp() {
		maker1 = new CoffeeMaker();
		i = maker1.checkInventory();
    	//create new recipe strawberry
        ray1 = new Recipe();
        ray1.setName("strawberry");
        ray1.setPrice(40);
        ray1.setAmtCoffee(2);
        ray1.setAmtMilk(2);
        ray1.setAmtSugar(2);
        ray1.setAmtChocolate(4);
	}
	
	
    public void testToString1() {
    	//test the output result of after make coffee to see is that inventary correct. 
    	maker1.makeCoffee(ray1, 100);
        assertEquals("Coffee: 13\nMilk: 13\nSugar: 13\nChocolate: 11\n",
                        i.toString());
}
    
    public void testsetCoffee(){
    	i.setChocolate(-1);
    	assertEquals(0,i.getChocolate());
    	i.setChocolate(0);
    	assertEquals(0,i.getChocolate());
    	i.setChocolate(-1);
    	assertEquals(0,i.getChocolate());
    	
    }
    
    public void testsetSugar(){
    	i.setSugar(-1);
    	assertEquals(0,i.getSugar());
    	i.setSugar(0);
    	assertEquals(0,i.getSugar());
    	i.setSugar(-1);
    	assertEquals(0,i.getSugar());
    	
    }
    
    public void testsetMilk(){
    	i.setMilk(-1);
    	assertEquals(0,i.getMilk());
    	i.setMilk(0);
    	assertEquals(0,i.getMilk());
    	i.setMilk(-1);
    	assertEquals(0,i.getMilk());
    	
    }
    public void testEnoughIngredients1() {
    	//test different settings for the ingredient to see is that combination could be 
        assertTrue(i.enoughIngredients(ray1));

        i.setCoffee(1);
        assertFalse(i.enoughIngredients(ray1));

        i.setMilk(0);
        assertFalse(i.enoughIngredients(ray1));

        i.setSugar(0);
        i.setChocolate(2);
        assertFalse(i.enoughIngredients(ray1));

       

}
}