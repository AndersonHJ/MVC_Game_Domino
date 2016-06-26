package models;

import controllers.PaddleController;
import abstractions.PaddleControllerAbstraction;
import abstractions.PaddleViewSpecification;
import views.PaddleViewPlain;
import models.RunnableViewablePaddle;

/**
 * A first step in building a java game where a paddle constantly moves horizontally at the 
 * bottom of a 2-D screen and its direction is changed/controlled by keyboard presses<br>
 * 
 * For teaching MVC design pattern, and introducing Java threads:
 * <ul>
 * <li> Model is {@link RunnableViewableBouncePaddle}</li>
 * <li> View is {@link PaddleViewPlain}</li>
 * <li> Controller is {@link PaddleController}</li>
 * </ul>
 * 
 * <b> NOTE: </b> This is not intended as a good example of UI development in Java, it is intended only as
 *                a good introduction to the MVC design pattern<br>
 * 
 * @version 1.1.0
 * @author J Paul Gibson
 */
public class PaddleBounceViewSimple {
	
	/**
	 * The model
	 */
	RunnableViewablePaddle rvPaddle;
	
	/** 
	 * The view
	 */
	PaddleViewSpecification paddleView;
	
	/**
	 * The controller
	 */
	PaddleControllerAbstraction paddleController;
	
	public PaddleBounceViewSimple(){
		
		// Construct model
		rvPaddle = new RunnableViewablePaddle(new PaddleBounce());
		
		// Construct view which can see model
		paddleView = new PaddleViewPlain(rvPaddle);
		
		//Allow the model to see view in order to make updates when state changes
		rvPaddle.setView(paddleView);
		
		//Construct controller
		PaddleController paddleController = new PaddleController(rvPaddle);
		
		//The frame which contains the view must allow the controller to react to key presses
		paddleView.getFrame().addKeyListener(paddleController);
	}
	
	public void startgame(){ 		
		
	  Thread paddleThread = new Thread((Runnable) rvPaddle);
	  paddleThread.run();
	  System.out.println("made bounce thread");
	}
	
}
