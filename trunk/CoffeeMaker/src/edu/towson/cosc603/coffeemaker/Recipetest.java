package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class Recipetest extends TestCase{
	//private new recipses
       private Recipe ray1;
       private Recipe ray2;


        @Before
        public void setUp() throws Exception {
            ray1 = new Recipe();
            ray2 = new Recipe();
        }

        @Test
        public void testSetAmtCoffee1() {
                ray1.setAmtCoffee(-1);
                assertEquals(0, ray1.getAmtCoffee());
                ray1.setAmtCoffee(0);
                assertEquals(0, ray1.getAmtCoffee());
                ray1.setAmtCoffee(3);
                assertEquals(3, ray1.getAmtCoffee());
        }

        @Test
        public void testSetAmtMilk1() {
                ray1.setAmtMilk(-1);
                assertEquals(0, ray1.getAmtMilk());
                ray1.setAmtMilk(0);
                assertEquals(0, ray1.getAmtMilk());
                ray1.setAmtMilk(1);
                assertEquals(1, ray1.getAmtMilk());
        }

        @Test
        public void testSetAmtSugar1() {
                ray1.setAmtSugar(-1);
                assertEquals(0, ray1.getAmtSugar());
                ray1.setAmtSugar(0);
                assertEquals(0, ray1.getAmtSugar());
                ray1.setAmtSugar(1);
                assertEquals(1, ray1.getAmtSugar());
        }
        
        @Test
        public void testSetAmtChocolate1() {
                ray1.setAmtChocolate(-1);
                assertEquals(0, ray1.getAmtChocolate());
                ray1.setAmtChocolate(0);
                assertEquals(0, ray1.getAmtChocolate());
                ray1.setAmtChocolate(10);
                assertEquals(10, ray1.getAmtChocolate());
        }

        @Test
        public void testSetPrice1() {
                ray1.setPrice(-1);
                assertEquals(0, ray1.getPrice());
                ray1.setPrice(50);
                assertEquals(50, ray1.getPrice());
        }

        @Test
        public void testSetName1() {
                ray1.setName("Coffee");
                assertEquals("Coffee", ray1.getName());
        }

        @Test
        public void testEquals1() {
        	    

                ray2.setName("Coffee");
                assertFalse(ray1.equals(ray2));

                ray1.setName("Coffee");
                assertTrue(ray1.equals(ray2));

                ray1.setName("Cafe Mocha");
                assertFalse(ray1.equals(ray2));
        }

        @Test
        public void testToString1() {
                ray1.setName("Coffee");
                assertEquals("Coffee", ray1.toString());
        }


}
