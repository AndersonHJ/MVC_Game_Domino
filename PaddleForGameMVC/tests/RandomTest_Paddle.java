package tests;

import java.util.Random;

import models.PaddleBounce;
import tools.DateHeader;
import tools.SeedRNGCommandLine;

/**
 * Test class for {@link PaddleBounce} that uses a {@link Random} RNG for simulation purposes.<br>
 * The RNG can be seeded at the command line, or a default value of 0 can be used. <br><br>
 * 
 * We use the {@link DateHeader} class to document the date/time of the test execution<br><br>
 * 
 * Expected Output (using default RNG seed = 0) and <code> NUMBER_OF_TESTS </code> = 6:
 * <pre>
The seed used for the random number generator in the test is 0.
You can override this value by passing an integer value as a main argument parameter, if you so wish.


********************************************************************
Execution Date/Time 2011/03/16 11:29:28
********************************************************************
Creating a random Paddle 6 times:

Paddle: position = 6, moving =  right, is in safe state.
Paddle: position = 7, moving =  right, is in safe state.
Paddle: position = 10, moving =  left, is in safe state.
Paddle: position = 5, moving =  left, is in safe state.
Paddle: position = 6, moving =  right, is in safe state.
Paddle: position = 18, moving =  left, is in safe state.
</pre>
 * 
 * @author J Paul Gibson
 * @version 1
 * @see JUnit_Paddle
 */

public class RandomTest_Paddle {
	
	public static void main(String[] args) {
		
		PaddleBounce paddle;
		
		/**
		 * The number of rolls in our simulation
		 */
		final int NUMBER_OF_TESTS = 6;
		
		Random rng = SeedRNGCommandLine.getRandom(args);
		System.out.println(DateHeader.dateString());
		
		
				
        System.out.println("Creating a random Paddle "+NUMBER_OF_TESTS+ " times:\n");
		for (int i =1; i<=NUMBER_OF_TESTS;i++){ 
			paddle = new PaddleBounce(rng); 
			System.out.println(paddle);
		}
		
		} 

}