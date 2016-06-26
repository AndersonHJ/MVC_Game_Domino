package controllers;

import java.awt.event.KeyEvent;

import models.RunnableViewablePaddle;
import abstractions.PaddleControllerAbstraction;

/**
 * <b> Extends </b> {@link PaddleControllerAbstraction}<br><br>
 * A simple paddle controller for use in a video game.<br>
 * Typing a character on the keyboard changes direction of movement of the Paddle. <br>
 * For teaching MVC design pattern.
 * 
 * @version 1.0.0
 * @author J Paul Gibson
 */
public class PaddleController extends PaddleControllerAbstraction{
	/**
	 * This variable indicate the current direction
	 * */
	static char direction = 'j'; 
	/**
	 * The model being controlled by the controller
	 */
	RunnableViewablePaddle paddle;
	
	/**
	 * @param rvPaddle is the model to be controlled by the controller
	 */
	public PaddleController(RunnableViewablePaddle rvPaddle){
		
		this.paddle = rvPaddle;
	}

   /**
    * Change direction when a key is typed
    
    public void keyTyped(KeyEvent e){
	  System.out.println(e.getKeyChar());
	  
	  paddle.changeDirection();
    }
    */
    
	/**
	 * question2
	 * Change the controller so that you have to hold down a button to move left
	 * and hold down a button to move right 
	 * */
    public void keyTyped(KeyEvent e){
    	
  	  	if(e.getKeyChar()=='j'||e.getKeyChar()=='f'){
  	  		if(direction!=e.getKeyChar()){
    			paddle.changeDirection();
    			direction = e.getKeyChar();
    			paddle.changeDirShow();
    		}
  	  		paddle.goingRight();
  	  	}
  	  	else
  	  		return;
  	  	paddle.updatePosition();
    }
   
	
	
	
}
