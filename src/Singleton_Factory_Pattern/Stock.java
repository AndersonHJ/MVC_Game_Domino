package Singleton_Factory_Pattern;
import java.util.ArrayList;
import java.util.Random;

public class Stock {
	
	ArrayList<Domino> list;
	
	/**
	 * The constructor of Stock
	 * @param factory the factory to generate domino
	 */
	Stock(DominoFactory factory){  // create 28 dominos
		if(factory == null) throw new NullPointerException();
		
		list = new ArrayList<>();
		for(int i = 6; i>=0;i--)
			for(int j = i;j>=0; j--)
				list.add(factory.generateDomino(i, j));
    }
	
	public ArrayList<Domino> initialize(){  //Six random dominos when the game start
		ArrayList<Domino> sixDominos = new ArrayList<>();
		for(int i = 0; i< 6; i++){
			sixDominos.add(this.draw());
		}
		return sixDominos;
	}
	
	public Domino draw() throws IndexOutOfBoundsException {  // add a domino to hand at random, then delete from the stock
		Random rand = new Random();
		int index = rand.nextInt(list.size()); // Each domino has an index
		return list.remove(index);  // remove the domino from stock
	}
	
	public int getSize() { // check if the stock is empty
		if (list.size() == 0)
			System.out.println("The stock is empty.Please choose a domino or jump");
			
		return list.size();
	}
	
	
}
