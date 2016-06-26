package tests;

import models.PaddleBounce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <b> Tests</b>  {@link PaddleBounce}<br>
 * 
 * @version 1.0.0
 * @author J Paul Gibson
 */
public class JUnit_Paddle {
	
	protected PaddleBounce paddleDefault;
	protected PaddleBounce paddleOK1;
	protected PaddleBounce paddleOK2;
	protected PaddleBounce paddlePastMax;
	protected PaddleBounce paddlePastMin;
	
	@Before
	public void setUp() throws Exception {
		
			paddleDefault = new PaddleBounce();
			paddleOK1 = new PaddleBounce((PaddleBounce.MAXIMUM_position - PaddleBounce.MINIMUM_position)/2);
			paddleOK2 = new PaddleBounce((PaddleBounce.MAXIMUM_position - PaddleBounce.MINIMUM_position)/2);
			paddlePastMax = new PaddleBounce(PaddleBounce.MAXIMUM_position +1);
			paddlePastMin = new PaddleBounce(PaddleBounce.MINIMUM_position -1);
	}
	
	@After
	public void tearDown() throws Exception {
		
			paddleDefault = null;
			paddleOK1 = null;
			paddlePastMax = null;
			paddlePastMin = null;
			
	}
	
	/**
	 * tests the default constructor {@link PaddleBounce#Paddle()}
	 */
	@Test
	public void testDefaultConstructor() {

			Assert.assertTrue(paddleDefault.invariant());
			Assert.assertEquals(paddleDefault.get_position(), 0);
			Assert.assertTrue(paddleDefault.goingRight());	    
	}
	
	/**
	 * tests the default constructor {@link PaddleBounce#Paddle(int)}
	 */
	@Test
	public void testNonDefaultConstructor() {

			Assert.assertTrue(paddleOK1.invariant());
			Assert.assertEquals(paddleOK1.get_position(),(PaddleBounce.MAXIMUM_position - PaddleBounce.MINIMUM_position)/2 );
			Assert.assertTrue(paddleOK1.goingRight());
			
			Assert.assertTrue(paddlePastMax.invariant());
			Assert.assertEquals(paddlePastMax.get_position(),PaddleBounce.MAXIMUM_position);
			Assert.assertTrue(paddlePastMax.goingRight());
			
			Assert.assertTrue(paddlePastMin.invariant());
			Assert.assertEquals(paddlePastMin.get_position(),PaddleBounce.MINIMUM_position);
			Assert.assertTrue(paddlePastMin.goingRight());
	}
	
	/**
	 * tests changeDirection {@link PaddleBounce#changeDirection()}
	 */
	@Test
	public void testChangeDirection() {
		
		boolean direction = paddleDefault.goingRight();
	
		paddleDefault.changeDirection();
		Assert.assertTrue(direction != paddleDefault.goingRight());
		paddleDefault.changeDirection();
		Assert.assertTrue(direction == paddleDefault.goingRight());
		
	}
	
	/**
	 * tests updatePosition {@link PaddleBounce#updatePosition()}
	 */
	@Test
	public void testUpdatePosition() {
		
		paddleDefault.updatePosition();
		Assert.assertTrue(paddleDefault.invariant());
		Assert.assertEquals(paddleDefault.get_position(), 1);
		Assert.assertTrue(paddleDefault.goingRight());
		
		paddleOK1.updatePosition();
		Assert.assertTrue(paddleOK1.invariant());
		Assert.assertEquals(paddleOK1.get_position(),(PaddleBounce.MAXIMUM_position - PaddleBounce.MINIMUM_position)/2 +1);
		Assert.assertTrue(paddleOK1.goingRight());
		
		paddlePastMax.updatePosition();
		Assert.assertTrue(paddlePastMax.invariant());
		Assert.assertEquals(paddlePastMax.get_position(),PaddleBounce.MAXIMUM_position);
		Assert.assertFalse(paddlePastMax.goingRight());
		
		paddlePastMin.updatePosition();
		Assert.assertTrue(paddlePastMin.invariant());
		Assert.assertEquals(paddlePastMin.get_position(),PaddleBounce.MINIMUM_position+1);
		Assert.assertTrue(paddlePastMin.goingRight());
		
		paddlePastMin.changeDirection();
		paddlePastMin.updatePosition();
		paddlePastMin.updatePosition();
		Assert.assertTrue(paddlePastMin.invariant());
		Assert.assertEquals(paddlePastMin.get_position(),PaddleBounce.MINIMUM_position);
		Assert.assertTrue(paddlePastMin.goingRight());
	}
		
		/**
		 * tests toString {@link PaddleBounce#toString()}
		 */
		@Test
		public void testToString() {
			
			Assert.assertEquals(paddleDefault.toString(), 
					            "Paddle: position = 0, moving =  right, is in safe state." );
		}

		/**
		 * tests equals {@link PaddleBounce#equals()}
		 */
		@Test
		public void testEquals() {
			
			Assert.assertEquals(paddleDefault, paddleDefault);
			Assert.assertEquals(paddleOK1, paddleOK2);
			Assert.assertNotSame(paddleDefault, paddleOK1);
		}
}
