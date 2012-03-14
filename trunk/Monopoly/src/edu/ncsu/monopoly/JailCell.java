package edu.ncsu.monopoly;

public class JailCell extends Cell {
	public static int BAIL = 50;
	
	public JailCell() {
		setName("Jail");
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
