import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author cla
 *
 */
public class VendingMachineItemTest {
	public VendingMachine machine;
	public VendingMachine machine2;
	public VendingMachineItem item ;
	public VendingMachineItem item2 ;
	public VendingMachineItem item3 ;
	@Before
	public void setUp() throws Exception {
		
		machine=new VendingMachine();
		item=new VendingMachineItem("MM", 1.25);
		item2=new VendingMachineItem(" ",5.00);
		item3=new VendingMachineItem(null,7.00);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public void testVendingMachineItem() {
		//first test the item name is the same as the "MM"
		assertSame("MM",item.getName());
		//second test is about how does if item2 's name is " "is this can be works
		//i think this is a bug which allow item name as the " ";
		assertNotNull(item2.getName());
		//test if it is the Null value in item3 can be seen as the Null or not
		assertNull(item3.getName());
		//test if the item name like" ", is this item is the null or not, it is a bug
		assertNotNull(item2);
		
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 */
	@Test
	public void testGetName() {
		//test get name function works correctly.
		assertEquals("MM",item.getName());
		
	}
	

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(1.25,item.getPrice(),0.01);
	
	}

}
