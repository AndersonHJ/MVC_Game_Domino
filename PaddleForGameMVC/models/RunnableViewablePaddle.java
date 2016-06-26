package models;

import abstractions.PaddleSpecification;
import abstractions.PaddleViewSpecification;

/**
 * <b> Implements</b>  {@link Runnable}<br>
 * 
 * For teaching MVC design pattern.
 * 
 * @version 1.1.0
 * @author J Paul Gibson
 */
public class RunnableViewablePaddle implements Runnable, PaddleSpecification{
	
	/**
	 * The paddle that will be run
	 */
	private final PaddleSpecification paddle;
	
	/**
	 * A 1/10th second delay between movements of Paddle
	 */
	public static final int DELAY = 100;
	
	
	/**
	 * The view to be informed that the state of the Paddle has changed
	 */
	private PaddleViewSpecification paddleView;
	
	/**
	 * @param p the paddle to be run
	 */
    public RunnableViewablePaddle(PaddleSpecification p){
    	paddle = p;
    }
	
	
	/**
	 * @param paddleView2 the current view which responds to state changes
	 */
	public void setView(PaddleViewSpecification paddleView2){
		paddleView = paddleView2;
	}
	
	
	public int get_position(){
		return paddle.get_position();
	}
	
	public void changeDirection(){
		paddle.changeDirection();
	}
	
	public boolean goingRight(){
		return paddle.goingRight();
	}
	
	public void updatePosition(){
		paddle.updatePosition();
	}
	
	
	/**
	 * Change the direction show on the screen
	 * */
	public void changeDirShow(){
		paddleView.changeDir();
	}
	
	
	/**
	 * Every 10th of second:
	 * <ul>
	 * <li> update the paddle position</li>
	 * <li> inform the view (if it has been initialised) of the update </li>
	 * </ul>
	 */
	public void run(){
		while(true){	
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (paddleView !=null) {
				paddleView.updateView();
			}
		}
	}
}

