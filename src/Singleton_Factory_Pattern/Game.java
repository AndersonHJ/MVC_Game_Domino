package Singleton_Factory_Pattern;



import graphicInterface.BadMatchException; 
import graphicInterface.GGame;
import graphicInterface.InterfaceGame;


/**
* Run the game between a player and the computer.
* @version march 2016
*
*/
public class Game implements InterfaceGame {
	/**
	 * The static instance of graphic game
	 */
	private static GGame gGame = null;
	
	/**
	 * The static instance of game 
	 */
	private static Game game = null;
	
	/**
	 * The instance of domino factory.
	 */
	private DominoFactory factory = null;
	
	/**
	 * The stock
	 */
	 private Stock stock;
   
	 /**
	  * The board where dominos are put.
	  */
	 private Table table;
   
   /**
    * Player 1
    */
	 private Player player1;
   
   /**
    * Computer
    */
	 private Player pc;
   
   /**States:
    * 0-6 search if double domino
    * 8 player plays
    * 9 player plays with empty stock
    * 10 computer plays
    * 12 player forced play
    * 14 computer plays with drawing from stock
    * 15 computer blocked
    * 18 player plays while computer is blocked
    * 19 player plays with empty stock while computer is blocked
    * 
    */
	
	//Meaning of the states
	 String stateMeaning[] ={"double0","double1","double2","double3","double4",
			 "double5","double6","blockedComputer","play","blockedPlayer",
			 "win","blockedGame","NoDoubleFirstDomino"};
	 
	 
	 int indState = 6; //begin with double 6
	 
	 boolean playerIsBlocked = false; // to check whether player is blocked
	 
	 
	 /**
	  * To initialize the game instance.
	  * @return Game the static instance of game 
	  */
	 public synchronized static Game instance(){
		 if(game==null) game = new Game();
		 return game;
	 }
	 
   /**
    * Constructor for 2 players.Create a graphical interface and send it a message to enter the player's name.
    * @param name1 The name of the first player.
    * @param name2 The name of the second player.
    */
	   private Game() {
		// To renew a game and input a player name
		   gGame = new GGame(this);
		   gGame.setVisible(true); // to make the interface visible
		   gGame.setMessage("Please input your name: ");
		   gGame.setMessageEnabled(true);// to show messages on the white board
	   }
   
   
   
   /**
    * Create a stock, a board, two players (player and computer), initialise the 
    * graphical interface : hand, button and send it the first message.
    * @param name The name of the player
    */
   public void initialize(String name) {
	  //TO DO  	 	
	   table = table.instance();
	   factory = factory.instance();
	   
	   stock = new Stock(factory);
	   player1 = new Player("name");
	   Hand player1Hand = new Hand(stock, gGame);
	   player1.setHand(player1Hand);
	   player1Hand.print();
	   pc = new Player("computer");
	   pc.setHand(new Hand(stock, gGame));
   }
   
   /**
    * Take the selected domino, verify if it is the right one.
    * If it is ok, call treatAnswer method otherwise send a message.
    * @param d The selected domino.
    */
   public int treatDoubleAnswer(Domino d, Player player) {
	   if(d.getLeftValue()==d.getRightValue()&&d.getLeftValue()==indState){
 			player.getHand().delete(d);
 			if(player.equals(player1)) // if current player is not pc, delete the domino from hand
 				gGame.removeDominoFromHand(d);
 			int res = table.add(d);
 			
			try {
				if(res == -1) gGame.putDominoOnLeftTable(d);
				else if(res == 0) gGame.putDominoOnTable(d);
	 			else gGame.putDominoOnRightTable(d);
			} catch (BadMatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
 			gGame.setEnabledJump(false);
 			indState = 7;
 			return 1;
 		}
 		return -1;
   }
 
   
   /**
    * When a player plays, we verify that the selected domino d may be
    * put on the table. If it is the case, we remove d from the hand of the player
    * and from the graphical hand. Then put d on the board and on the graphic board.
    * @param d The domino selected by the player.
    */
    public int treatAnswer(Domino d, Player player) {
    	int left = table.getEndValues()[0];
   		int right = table.getEndValues()[1];
   		if(left == d.getLeftValue()||left==d.getRightValue()||right == d.getLeftValue()||right == d.getRightValue()){
   			player.getHand().delete(d);
   			if(player.equals(player1))
   				gGame.removeDominoFromHand(d);
   			int res = table.add(d);
 			
			try {
				if(res == -1) gGame.putDominoOnLeftTable(d);
				else if(res == 0) gGame.putDominoOnTable(d);
	 			else gGame.putDominoOnRightTable(d);
			} catch (BadMatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   			gGame.setHandEnable(false);
   			gGame.setEnabledPlayPC(true);
   			gGame.setEnabledDraw(false);
   			indState = 7;
   			return 1;
		}
   		return -1;
    }


	/**
	    * This method is called when an event is produced in the graphical interface.
	    * @param val The state of the game.
	    */
	   public void receivedMessage(int val) {
		   System.out.println( "\ntype received message  "+ val +" for state "+indState);
		   
		   switch (val)  {
		   
		   case GGame.DATA_NAME: //TO DO 
			    gGame.setEnabledJump(true);
			    gGame.setHandEnable(true);
			    this.initialize(gGame.getPlayerName());
			    gGame.setMessage("Welcom "+gGame.getPlayerName()+". Good luck~ Please choose a double 6 or jump.");
		   		break;
		   case GGame.PLAY:
			   
			   switch (indState) {
			   	 case 6: case 5: case 4:case 3: case 2: case 1: case 0: //double domino
			   		 if(treatDoubleAnswer((Domino) gGame.dominoChoiced, player1)<0)
			   	 		 gGame.setMessage("This choice is not good.   Please click on a domino.");
			   		 else{
			   			 gGame.setEnabledPlayPC(true);
			   			 gGame.setHandEnable(false);
			   			 gGame.setMessage("It's PC's turn. Please click on Play PC to validate.");
			   		 }
			  		 break;
			  	
			   	 case 7:// normal play
			   		if(treatAnswer((Domino) gGame.dominoChoiced, player1)<0)
			   			gGame.setMessage("This choice is not good.   Please click on a domino.");
			   		else
			   			gGame.setMessage("It's PC's turn. Please click on play pc to validate.");
					break;

				 default: System.out.println("state no valid");
			   }
			   if(player1.getHand().getSize()==0){
				   gGame.setMessage("*******Congratulations! You have won!*******");
				   gGame.setEnabledDraw(false);
				   gGame.setHandEnable(false);
				   gGame.setEnabledPlayPC(false);
			   }
			   break;

		   case GGame.JUMP:	
			   gGame.setEnabledPlayPC(true);
			   
			   gGame.setEnabledJump(false);
			   playerIsBlocked = true;
			   gGame.setMessage("It's PC's turn. Please click on Play PC to validate. ");
			   break;
			   
		   case GGame.DRAW:
			   if(stock.getSize()==0){
				   gGame.setMessage("The stock is empty. Please click domino or jump.");
				   gGame.setEnabledJump(true);
				   gGame.setEnabledDraw(false);
				   playerIsBlocked = true;
			   }
			   else{
				   gGame.setMessage("Please choose a domino or draw.");
				   Domino newOne = stock.draw();
				   gGame.addDominoInHand(newOne);
				   player1.getHand().add(newOne);
			   }
			   gGame.setHandEnable(true);
			   
			   break;
			   
		   case GGame.VALIDPCPLAY:
			   this.computerPlay();
			   
			   break;

		   case GGame.NEWGAME:
			   gGame.setVisible(false);
			   gGame = new GGame(this);
		       gGame.setVisible(true);
		       gGame.setMessage("Please input your name: ");
		       gGame.setMessageEnabled(true);
		       indState = 6;
			   break;
		   }
		  
	   }
	/**
	 * The computer plays in relationship with the state of the game.
	 * If state = n (with n =1,2,3,4,5,6) we look for a double n in the computer's hand.
	 * If yes, the computer plays else the player is asked to play the double domino (n-1).
	 * If n=0 we look for a double 0 in the computer's hand.
	 * If yes, the computer plays, otherwise the player is asked to play any other domino.
	 * If n=8 or 9  normal game managing the stock and the empty stock.
	 * If n=11 blocked game.
	 */
   	public void computerPlay( )	{
   		System.out.println("state:"+indState+ ". computer plays");
   		Domino d=null;
   		int size = pc.getHand().getSize();
   		switch (indState) {
   		case 6: case 5: case 4:case 3: case 2: case 1: case 0:
   			int i = 0;
   			for(i = 0; i< size; i++){      // to check the domino list of hand 
   				int tempIndState = indState;
   				if(treatDoubleAnswer(pc.getHand().get(i), pc)>0){   // pc has a double domino 
   					gGame.setEnabledDraw(true);
   					gGame.setHandEnable(true);
   					gGame.setEnabledPlayPC(false);
   					gGame.setMessage("Computer played "+ tempIndState +" : "+ tempIndState + ". Choose a domino or draw.");
   					playerIsBlocked = false;
   					break;
   				}
   			}
			if(i == size){     //no double domino matched for double n, check double (n-1)
				gGame.setMessage("PC dosen't have double " + indState +". Please click on double " + --indState +" or jump.");
				gGame.setEnabledJump(true);
				gGame.setEnabledPlayPC(false);
			}
			break;
  	
   		case 7: //computer plays,including jumping, drawing 
   			int j = 0;
   			for(j = 0; j< size; j++){
   				String temp = pc.getHand().get(j).toString();
   				if(treatAnswer(pc.getHand().get(j), pc)>0){
   					if(stock.getSize()==0) // stock empty,  human player can only jump or play
   						gGame.setEnabledJump(true);
   					else                   //stock not empty, human player can draw or play
   						gGame.setEnabledDraw(true);
   					gGame.setHandEnable(true);
   					gGame.setEnabledPlayPC(false);
   					gGame.setMessage("The computer has played " + temp + ". Please choose a domino or draw");
   					playerIsBlocked = false;
   					break;
   				}
   			}
			if(j == size){
				gGame.setEnabledDraw(false);
				if(stock.getSize()==0){
		   			gGame.setEnabledPlayPC(false);
		   			if(playerIsBlocked){
		   				gGame.setMessage("The game is blocked, please restart the game.");
		   				gGame.setEnabledJump(false);
		   				gGame.setHandEnable(false);
		   			}
		   			else{
		   				gGame.setHandEnable(true);
			   			gGame.setEnabledJump(true);
		   				gGame.setMessage("The stock is empty. PC can't play. Please choose a domino or jump.");
		   			}
				}
				else{
					gGame.setEnabledPlayPC(true);
					gGame.setHandEnable(false);
					pc.getHand().add(stock.draw());
					gGame.setMessage("The computer has one draw. Click on PLAY PC button to continue��");
				}
			}
			if(pc.getHand().getSize()==0){
				   gGame.setMessage("*******The computer has won*******");
				   gGame.setEnabledDraw(false);
				   gGame.setHandEnable(false);
				   gGame.setEnabledPlayPC(false);
			   }
			
			break;

   		case -1: // when player and pc don't have double domino at the beginning , player start first
   			indState = 7;
   			gGame.setMessage("The computer and player don't have a double-value domino. Please choose a domino or draw");
   			gGame.setEnabledDraw(true);
   			gGame.setHandEnable(true);
   			gGame.setEnabledPlayPC(false);
   			break;
  		 
   		default: System.out.println("state invalid");
					
  	 }	
	 for(int k = 0; k<pc.getHand().getSize(); k++) // to show current domino list of pc at the background
		 System.out.println(pc.getHand().get(k));
	    	
   }
	
   
   public static void main(String [] args) {
	   Game gameinstance = game.instance();   
       
   }
}



