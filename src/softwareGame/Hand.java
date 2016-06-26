package softwareGame;

import java.util.ArrayList;

import graphicInterface.GGame;

public class Hand {

	GGame gGame;
	Stock stock;
	ArrayList<Domino> listOfHand;
	
	
	Hand(Stock stock, GGame gGame){
		this.gGame = gGame;
		this.stock=stock;
		listOfHand = stock.initialize();
		
    }
	
	public void add(Domino domino) { // add a domino to hand 
		listOfHand.add(domino);
		
	}
	
	public void delete(Domino domino) { // delete the domino from hand
		listOfHand.remove(domino);
		
	}
	
	public Domino get(int index){  // get the dominos in hand due to the index
		return listOfHand.get(index);
	}
	
	
	public int getSize() {  // get the number of dominos on hand
		return listOfHand.size();
	}

	public void print() {  // Show the six dominos in hand when the game starts
		for(int i=0; i<6; i++)
			gGame.addDominoInHand(listOfHand.get(i));
	}
	
	
}
