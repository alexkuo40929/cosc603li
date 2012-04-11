import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
	public VendingMachine machine;
	public VendingMachine machine2;
	public VendingMachineItem item ;
	public VendingMachineItem item2 ;
	double amount=5.00;
	
	@Before
	public void setUp() throws Exception {
		machine=new VendingMachine();
		item=new VendingMachineItem("MM", 1.25);
		item2=new VendingMachineItem("car",5.00);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//test add item by checking after added item is that match with the item is the same
	//as the value we got from that slot by test both slot A and B.
	public void testAddItem() {

	    machine.addItem(item,VendingMachine.A_CODE);
	    machine.addItem(item2,VendingMachine.B_CODE);
	    assertSame(item, machine.getItem(VendingMachine.A_CODE ));
	    assertSame(item2, machine.getItem(VendingMachine.B_CODE ));
	 // test case 2 for the slot C and D to see is that still nothing without add to wrong solt
	    assertNull(machine.getItem(VendingMachine.C_CODE));
		assertNull(machine.getItem(VendingMachine.D_CODE));
	}
	
   
		
		
   
	@Test
	// test the remote function. after tie down, we need add a new item into 
	//slot first and call remote function to check the value in this slot should be null
	public void testRemoveItem() {
	    machine.addItem(item,VendingMachine.A_CODE);
		machine.removeItem(VendingMachine.A_CODE);
		assertEquals(null,machine.getItem(VendingMachine.A_CODE ) );
	}

	
	
	@Test
	//test after insert twice money to see is that amount be plugin totally?
	public void testInsertMoney() {
        machine.insertMoney(3.0);
        machine.insertMoney(1.75);
        assertEquals(4.75, machine.getBalance(), 0.01); 
	}

	@Test
	//test the price of the new item is the same as the add to a new item to the machine
	public void testGetBalance() {
		  machine.balance=4;
		  machine.addItem(item,VendingMachine.A_CODE);
		  machine.makePurchase(VendingMachine.A_CODE);
		  assertEquals(2.75,machine.getBalance(),0.001);
	}

	@Test
	//this is the test to ass two item into two differetn solt,and 
	//to test give 5 dollar to sucessfully purchase the solt is not null.
	public void testMakePurchase() {
		machine.addItem(item, VendingMachine.A_CODE);
		machine.addItem(item2, VendingMachine.B_CODE);
		machine.balance=5.0;
		assertEquals(true,machine.makePurchase(VendingMachine.A_CODE));
		//test case of if purchase on the empty slot
		assertEquals(false,machine.makePurchase(VendingMachine.C_CODE));
		//after purchase, then test how much left 5.0-1.25, to see is the value changed.
		assertEquals(3.75,machine.getBalance(),0.01);
	}

	@Test
	//testing the return value after make purhase the produce,
	//compare the change should be eqalis insert money-item.price
	public void testReturnChange() {

		machine.insertMoney(2.5);
		machine.addItem(item, VendingMachine.B_CODE);
		machine.makePurchase(VendingMachine.B_CODE);
		assertEquals(2.5-item.getPrice(),machine.returnChange(),0.01);
	}   

}
