package softwareGame;

public class Player {
	String name;
	Hand hand;
	
	
	Player(String playerName) {  // add a player name
		name = playerName;
	}
	
	public void setHand(Hand hand) {  // set hand for a player
		this.hand = hand;
	}
	
	public Hand getHand(){ // get the hand from a player
		return hand;
	}
	
	
	
}
