// This is mutant program.
// Author : ysma

package edu.towson.cosc603.coffeemaker;


import junit.framework.TestCase;


public class Recipetest extends junit.framework.TestCase
{

    public edu.towson.cosc603.coffeemaker.Recipe ray1;

    public edu.towson.cosc603.coffeemaker.Recipe ray2;

    public void setUp()
        throws java.lang.Exception
    {
    }

    public void tearDown()
        throws java.lang.Exception
    {
    }

    public void testSetAmtCoffee1()
    {
        ray1.setAmtCoffee( -1 );
        assertEquals( 0, ray1.getAmtCoffee() );
        ray1.setAmtCoffee( 0 );
        assertEquals( 0, ray1.getAmtCoffee() );
        ray1.setAmtCoffee( 3 );
        assertEquals( 3, ray1.getAmtCoffee() );
    }

    public void testSetAmtMilk1()
    {
        ray1.setAmtMilk( -1 );
        assertEquals( 0, ray1.getAmtMilk() );
        ray1.setAmtMilk( 0 );
        assertEquals( 0, ray1.getAmtMilk() );
        ray1.setAmtMilk( 1 );
        assertEquals( 1, ray1.getAmtMilk() );
    }

    public void testSetAmtSugar1()
    {
        ray1.setAmtSugar( -1 );
        assertEquals( 0, ray1.getAmtSugar() );
        ray1.setAmtSugar( 0 );
        assertEquals( 0, ray1.getAmtSugar() );
        ray1.setAmtSugar( 1 );
        assertEquals( 1, ray1.getAmtSugar() );
    }

    public void testSetAmtChocolate1()
    {
        ray1.setAmtChocolate( -1 );
        assertEquals( 0, ray1.getAmtChocolate() );
        ray1.setAmtChocolate( 0 );
        assertEquals( 0, ray1.getAmtChocolate() );
        ray1.setAmtChocolate( 10 );
        assertEquals( 10, ray1.getAmtChocolate() );
    }

    public void testSetPrice1()
    {
        ray1.setPrice( -1 );
        assertEquals( 0, ray1.getPrice() );
        ray1.setPrice( 50 );
        assertEquals( 50, ray1.getPrice() );
    }

    public void testSetName1()
    {
        ray1.setName( "Coffee" );
        assertEquals( "Coffee", ray1.getName() );
    }

    public void testEquals1()
    {
        assertFalse( ray1.equals( ray2 ) );
        ray2.setName( "Coffee" );
        assertFalse( ray1.equals( ray2 ) );
        ray1.setName( "Coffee" );
        assertTrue( ray1.equals( ray2 ) );
        ray1.setName( "Cafe Mocha" );
        assertFalse( ray1.equals( ray2 ) );
    }

    public void testToString1()
    {
        ray1.setName( "Coffee" );
        assertEquals( "Coffee", ray1.toString() );
    }

}
