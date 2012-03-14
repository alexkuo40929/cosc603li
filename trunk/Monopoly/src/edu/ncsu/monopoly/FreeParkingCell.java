package edu.ncsu.monopoly;

public class FreeParkingCell extends Cell {

	public FreeParkingCell() {
		setName("Free Parking");
	}

	public boolean playAction(String msg) {
		boolean result=false;
		if(msg!=null)
	
		 result = true;
		else
		result=false;
		
		return result;
	}
}
