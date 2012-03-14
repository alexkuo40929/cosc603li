package edu.ncsu.monopoly;

public class CardCell extends Cell {
    private int type;
    
    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    public boolean playAction(String msg) {
		boolean result=false;
		if(msg!=null)
	
		 result = true;
		else
		result=false;
		
		return result;
    }
    
    public int getType() {
        return type;
    }
}
