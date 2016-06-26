package abstractions;


/**
 * Specification of simple paddle behaviour for use in a video game.<br>
 * 
 * For teaching MVC design pattern.<br>
 * 
 * <ul>
 * <li> The paddle has one degree of freedom - moving either left or right. </li>
 * <li> It has a position which is an integer value bounded by minimum and maximum values</li>
 * </ul>
 * 
 * @version 1.0.0
 * @author J Paul Gibson
 */
public interface PaddleSpecification {
	
	
	/**
	 * The lower bound on the horizontal position of the paddle
	 */
	final int MINIMUM_position = 0;
	
	/**
	 * The upper bound on the horizontal position of the paddle
	 */
	final int MAXIMUM_position = 32;
	
	
	/**
	  * @return true if  the <code> MINIMUM_position </code> value is less than the 
	  *               <code> MAXIMUM_position</code> 
	  */
	 boolean INVARIANT_OF_CLASS = ( MINIMUM_position <= MAXIMUM_position);
	
	
	/**
	 * @return The position of the paddle -
	 *  must be within the defined limit: {@link MINIMUM_position} ... {@link MAXIMUM_position} </code>
	 */
	public int get_position();
	
	/**
	 * @return true if the paddle is moving to the right and false otherwise
	 */
	public boolean goingRight();
	
	/**
	 * Update paddle position or direction of movement:<br>
     * <ul>
     * <li> if moving out of defined limits then change the direction of the paddle movement 
     *       without changing position</li>
     * <li> if moving right inside limits then increment position </li>
     * <li> if moving left inside limits then decrement position </li>
     * </ul>
	 */
	public void updatePosition();
	
	/**
     * Changes direction from left to  right, or right to left.
	 */
	public void changeDirection();
	
	/**
	 * @param thing is the input object to test for equality
	 * @returns true if the input parameter is equal to the Paddle object,
	 * where 2 paddles are considered equal if they have the same position and the same direction
	 */
	public boolean equals( Object thing);
	
	/**
	 * @returns the string representing the state of the Paddle.<br>
	 * The string format follows the template below (illustrated using default constructor values):<br>
	 * <pre>
	   Paddle: position = 0, moving =  right, is in safe state.
	 * </pre>
	   For an unsafe Paddle,  the format simply adds a not to the string, eg:
	 * <pre>
	   Paddle: position = 100, moving =  right, is not in safe state.
	 * </pre>
	 */
	public String toString();

}
