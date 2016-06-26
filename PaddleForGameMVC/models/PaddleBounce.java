
package models;


import java.util.Random;

import abstractions.PaddleAbstraction;
import abstractions.PaddleSpecification;
import tools.HasInvariant;

/**
 * <b> Implements</b>  {@link HasInvariant}, {@link PaddleSpecification}<br><br>
 * 
 * A simple bouncing paddle model for use in a video game.<br>
 * 
 * For teaching MVC design pattern.
 * 
 * @version 1.1.0
 * @author J Paul Gibson
 */
public class PaddleBounce extends PaddleAbstraction{
	
	
	public PaddleBounce(int i) {
		super(i);
	}

	public PaddleBounce() {
		super();
	}

	public PaddleBounce(Random rng) {
		super(rng);
	}

	/**
	 * Tested by  {@link tests.JUnit_Paddle#testUpdatePosition()}, which guarantees that the Paddle remains 
	 * in a safe state as specified by {@link PaddleBounce#invariant}. <br>
	 * 
	 * When the paddle reaches the end of the screen we chose to make it bounce back by changing direction
	 */
	/*
	public void updatePosition(){
		
		if (directionToRight && position < MAXIMUM_position) position++;
		 else if (!directionToRight && position > MINIMUM_position) position--;
		 else changeDirection();
	}
	*/
	
	public void updatePosition(){
		
		if (directionToRight && position < MAXIMUM_position) position++;
		else if (!directionToRight && position > MINIMUM_position) position--;
		else if (directionToRight && position == MAXIMUM_position)
			position = MINIMUM_position;
		else 
			position = MAXIMUM_position;
	}
	
	
	
}
