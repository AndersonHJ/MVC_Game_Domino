package softwareGame;

import graphicInterface.InterfaceDomino;

public class Domino implements InterfaceDomino {
	int leftValue;
	int rightValue;
	
	Domino(int leftValue,int rightValue){
		this.leftValue=leftValue;
		this.rightValue=rightValue;
    }
	
	//public boolean equals(Domino two){  
	//	if(this.leftValue == two.leftValue && this.rightValue == two.rightValue)
	//		return true;
	//	else
	//		return false;
	//}
	
	@Override
	public int getLeftValue() {
		return leftValue;
	}
	
	@Override
	public int getRightValue() {
		return rightValue;
	}

	public void switchSides() { // switch the side of the card
		int temp = 0;
		temp = leftValue;
		leftValue = rightValue;
		rightValue = temp;
	}
	
	public String toString(){ //print the content of the domino
		return leftValue + ":" +rightValue;			
	}
	
}
  
