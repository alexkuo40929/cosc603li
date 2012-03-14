package edu.ncsu.monopoly;

public class GoCell extends Cell {
	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	public boolean playAction(String msg) {
		boolean result=false;
		if(msg!=null)
	
		 result = true;
		else
		result=false;
		
		return result;
	}
	
	void setName(String name) {
	}
	
}
