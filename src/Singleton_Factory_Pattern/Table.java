package Singleton_Factory_Pattern;
import java.util.ArrayList;

import graphicInterface.BadMatchException;
import graphicInterface.GGame;

public class Table {

	/**
	 * The static instance of Table 
	 */
	private static Table table = null;
	
	int[] values;
	ArrayList<Domino> dominoList;
	
	/**
	 * To initialize the instance of Table
	 * @return table the static instance which is initialized 
	 */
	public static synchronized Table instance(){
		if(table == null) table = new Table();
		return table;
	}
	
	Table(){
		values = new int[]{-1,-1}; // it means no domino on the table
		dominoList = new ArrayList<>();
		
	}
	
	public int add(Domino domino) { // add a new domino to the table
		if(domino == null) throw new NullPointerException();
		
		if(values[0]<0){  //currently no domino on the table 
			values[0] = domino.getLeftValue();
			values[1] = domino.getRightValue();
			dominoList.add(domino);
			return 0;
		}
		else{
			if(domino.getLeftValue()==values[0]||domino.getRightValue()==values[0]){ // domino can be put on the left side
				if(domino.getLeftValue()==values[0])
					domino.switchSides();
				dominoList.add(0, domino);
				values[0] = domino.getLeftValue();
				
				return -1;
			}
			else{          // domino can be put on the right side
				if(domino.getRightValue()==values[1])
					domino.switchSides();
				dominoList.add(domino);
				values[1] = domino.getRightValue();
				return 1;
			}
		}
	}
	
	public int[] getEndValues(){ // get the values on right and left sides
		if(values[0]<0)
			return null;
		else{
			return values;
		}
	}
	
	public int getSize(){ // check the number of card on the table
		if (dominoList.size() == 28)
			System.out.println("NO place to put the domino. Game blocked.");
		return dominoList.size();
	}
}
