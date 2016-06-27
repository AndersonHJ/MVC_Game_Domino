package Singleton_Factory_Pattern;

public class DominoFactory {

	private static DominoFactory factory = null;
	
	public static DominoFactory instance() {
		if(factory == null) factory = new DominoFactory();
		return factory;
	}
	
	Domino generateDomino(int leftvalue, int rightvalue){
		return new Domino(leftvalue, rightvalue);
	}
}
