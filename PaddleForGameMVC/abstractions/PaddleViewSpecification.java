package abstractions;

import javax.swing.JFrame;

/**
 * Specification of a simple paddle view for use in a video game:
 * <ul>
 * <li> View is 360*360 square</li>
 * </ul>
 * 
 * For teaching MVC design pattern.
 * 
 * @version 1.0.0
 * @author J Paul Gibson
 */
public interface PaddleViewSpecification {
	
	 final int VIEW_WIDTH = 360;
	 final int VIEW_HEIGHT = 360;
	
	/**
	 * @return the frame which contains the canvas in which the view is to be painted and which generates the
	 * events that need to be handled by the controller
	 */
	public JFrame getFrame();
	
	/**
	 * update the canvas on which the view is painted
	 */
	public void updateView();

	public void changeDir();
	
}
