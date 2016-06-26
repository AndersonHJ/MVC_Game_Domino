package softwareGame;
import java.util.ArrayList;

import graphicInterface.BadMatchException;
import graphicInterface.GGame;

public class Table {

	GGame tgame;
	int[] values;
	ArrayList<Domino> dominoList;
	
	Table(GGame tgame){
		this.tgame = tgame;
		values = new int[]{-1,-1}; // it means no domino on the table
		dominoList = new ArrayList<>();
		
	}
	
	public void add(Domino domino){ // add a new domino to the table
		if(values[0]<0){  //currently no domino on the table 
			values[0] = domino.getLeftValue();
			values[1] = domino.getRightValue();
			dominoList.add(domino);
			tgame.putDominoOnTable(domino);
		}
		else{
			if(domino.getLeftValue()==values[0]||domino.getRightValue()==values[0]){ // domino can be put on the left side
				if(domino.getLeftValue()==values[0])
					domino.switchSides();
				dominoList.add(0, domino);
				values[0] = domino.getLeftValue();
				
				try {
					tgame.putDominoOnLeftTable(domino);
				} catch (BadMatchException e) {
					
					e.printStackTrace();
				}
			}
			else{          // domino can be put on the right side
				if(domino.getRightValue()==values[1])
					domino.switchSides();
				dominoList.add(domino);
				values[1] = domino.getRightValue();
				try {
					tgame.putDominoOnRightTable(domino);
				} catch (BadMatchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
