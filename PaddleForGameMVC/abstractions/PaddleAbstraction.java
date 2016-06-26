package abstractions;

import java.util.Random;

import tools.HasInvariant;

/**
 * <b> Implements</b>  {@link HasInvariant}, {@link PaddleSpecification}<br><br>
 * 
 * A simple paddle model for use in a video game.<br>
 * 
 * It abstracts away from the movement of the paddle as specified in {@link PaddleSpecification#updatePosition}<br>
 * 
 * For teaching MVC design pattern.
 * 
 * @version 1.1.0
 * @author J Paul Gibson
 */
public abstract class PaddleAbstraction implements HasInvariant, PaddleSpecification{
	
	/**
	 * The paddle has one degree of freedom - either left or right. 
	 */
	protected boolean directionToRight;
	
	/**
	 * The horizontal position of the paddle
	 */
	protected int position;
	
	/**
	 * The position must be within the defined limit: 
	 * {@link PaddleSpecification#MINIMUM_position} ... {@link PaddleSpecification#MAXIMUM_position} </code>
	 */
	public boolean invariant (){
		
		return (position>= MINIMUM_position && position <= MAXIMUM_position);
	}
	
	public int get_position(){ return position;}
	

	public boolean goingRight(){ return directionToRight;}
	
	/**
	 * Tested by  {@link tests.JUnit_Paddle#testUpdatePosition()}, which guarantees that the Paddle remains 
	 * in a safe state as specified by {@link PaddleSpecification#invariant}.<br>
	 * The concrete subclasses need to implement this method
	 */
	public abstract void updatePosition();
	
	/**
	 * Tested by  {@link tests.JUnit_Paddle#testChangeDirection()}, which guarantees that the Paddle 
     * remains in a safe state as specified by {@link PaddleSpecification#invariant}.
	 */
	public void changeDirection(){directionToRight= ! directionToRight; }
	
	/**
	 * Tested by  {@link tests.JUnit_Paddle#testDefaultConstructor()}, which guarantees that the Paddle is
     * constructed in a safe state as specified by {@link PaddleSpecification#invariant}.<br><br>
     * 
     * As default the Paddle is at the leftmost position as defined by {@link MINIMUM_position}, and moving right
	 */
	public PaddleAbstraction (){
		
		position = MINIMUM_position;
		directionToRight = true;
	}
	
	/**
	 * Tested by  {@link tests.JUnit_Paddle#testNonDefaultConstructor()}, which guarantees that the Paddle is
     * constructed in a safe state as specified by {@link PaddleSpecification#invariant}.<br><br>
     * 
     * @param pos specifies the initial horizontal position for the Paddle being constructed
     * <ul>
     * <li> if <b> pos </b> is smaller than minimum bound then the position is initialised to the minimum</li>
     * <li> if <b> pos </b> is bigger than maximum bound then the position is initialised to the maximum</li>
     * <li> the Paddle direction is initially set to the right irrespective of the position</li>
     * </ul>
	 */
	public PaddleAbstraction (int pos){
		
		if (pos < MINIMUM_position) position = MINIMUM_position;
		else if (pos > MAXIMUM_position) position = MAXIMUM_position;
		else position = pos;
		directionToRight = true;
	}
	
	/**
	 * Tested by  {@link tests.RandomTest_Paddle}, which guarantees that the Paddle is
     * constructed in a safe state as specified by {@link PaddleSpecification#invariant}.<br><br>
     * 
     * @param rng is the random number generator to be used in the construction of a random Paddle:
     * <ul>
     * <li> Every valid position has an equal chance of being the initial value </li>
     * <li> Each direction (left and right) has an equal chance of being the initial value </li>
     * </ul>
	 */
	public PaddleAbstraction (Random rng){
		
		position = rng.nextInt(MAXIMUM_position);
		directionToRight = rng.nextBoolean();
	}

	
	public boolean equals( Object thing){
		
		if (thing ==null) return false;
		if ( this == thing) return true;
		if (! (thing instanceof PaddleSpecification)) return false;
		
		PaddleAbstraction that = (PaddleAbstraction) thing;
		return ( (this.get_position() == that.get_position()) 
				&& (this.directionToRight == that.directionToRight) );
	}
	

	public String toString(){
		
	String str = "Paddle: position = "+position+", moving =  ";
	if (directionToRight) str = str+"right,";
	else str = str+"left,";
	if (invariant()) str = str+" is in safe state.";
	else str = str+" is not in safe state.";
	return str;
	}

}