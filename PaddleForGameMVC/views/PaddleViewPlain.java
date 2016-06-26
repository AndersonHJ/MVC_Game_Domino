package views;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

//import com.sun.javafx.scene.traversal.Direction;

import models.PaddleBounce;
import models.RunnableViewablePaddle;
import abstractions.PaddleSpecification;
import abstractions.PaddleViewSpecification;

/**
 * 
 * <b> Implements </b> {@link PaddleViewSpecification}<br>
 * 
 * The view is a simple rectangle 
 * 
 * For teaching MVC design pattern.
 * 
 * @version 1.1.0
 * @author J Paul Gibson
 */
public class PaddleViewPlain implements PaddleViewSpecification{
	
	/**
	 * Local canvas class for inside of {@link PaddleViewPlain}
	 * frame responsible for graphical representation of the {@link PaddleBounce} model
	 * 
	 * @version 1.1.0
	 * @author J Paul Gibson
	 *
	 */
	 class PaddleViewCanvas extends Canvas{

		private final Color BACKGROUND_COLOUR = Color.blue;
		private final Color PADDLE_COLOUR = Color.yellow;
		private final int PADDLE_HEIGHT = 8;
		private final int PADDLE_WIDTH;
		private final int CANVAS_WIDTH;
		private final int CANVAS_HEIGHT;
		private final int PADDLE_INCREMENT;
		
		/**
		 * String to show on the panel
		 * */
		private Color String_Color = Color.red;
		private String direct = "Right";
		private boolean blue = false;
		
		private static final long serialVersionUID = 1L;
		
		private RunnableViewablePaddle paddleModel;
		
		public PaddleViewCanvas (RunnableViewablePaddle rvPaddle, int width, int height){
			
			super();
			paddleModel = rvPaddle;
			CANVAS_WIDTH = width;
			CANVAS_HEIGHT = height;
			setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
			setBackground(BACKGROUND_COLOUR);
			PADDLE_INCREMENT = CANVAS_WIDTH/(PaddleSpecification.MAXIMUM_position - PaddleSpecification.MINIMUM_position);
			PADDLE_WIDTH= PADDLE_INCREMENT;
		}
		
		public void update(Graphics g){
			paint(g);
		}
		
		public void paint(Graphics g){
			
			g.setColor(BACKGROUND_COLOUR);
			g.fillRect(0,
					    CANVAS_HEIGHT-2*PADDLE_HEIGHT-10,
					    CANVAS_WIDTH,
					    PADDLE_HEIGHT);
			
			g.setColor(PADDLE_COLOUR);
			g.fillRect(paddleModel.get_position()*PADDLE_INCREMENT,CANVAS_HEIGHT-2*PADDLE_HEIGHT-10,PADDLE_WIDTH,PADDLE_HEIGHT); 
			
			if(String_Color==Color.blue){
				if(blue==false)
					blue = true;
				else{
					String_Color = Color.red;
					direct = direct.equals("Right")?"Left":"Right";
					blue = false;
				}
					
			}
			g.setColor(String_Color);
			g.drawString(direct, 44, 44);
		}
		
		public void setDirect(String dir){
			this.direct = dir;
		}
		public String getDirect(){
			return this.direct;
		}
		public void setStringColor(){
			this.String_Color = Color.blue;
		}
		
	 }
	 
	/**
	 * The frame which contains the canvas in which the {@link PaddleSpecification} view is to be painted and which generates the
	 * events that need to be handled by the {@link controllers.PaddleControllerAbstraction}
	 */
	private  JFrame frame;
	
	/**
	 * The canvas in which the view is painted
	 */
	private PaddleViewCanvas canvas;
	
	/**
	 * @param rvPaddle is the {@link PaddleBounce} model which is to be associated with the view
	 */
	public PaddleViewPlain(RunnableViewablePaddle rvPaddle){
		
		frame = new JFrame("Paddle MVC");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(VIEW_WIDTH,VIEW_HEIGHT+20);
		frame.setVisible(true);
		frame.setResizable(false);
		canvas = new PaddleViewCanvas(rvPaddle, VIEW_WIDTH, VIEW_HEIGHT);
		
		frame.getContentPane().add(canvas, BorderLayout.CENTER );
		
	}
	
	public JFrame getFrame(){return frame;}
	
	public void updateView(){
		
		canvas.repaint();
	}
	
	public void changeDir(){
		canvas.setStringColor();
		if(canvas.getDirect().equals("Left"))
			canvas.setDirect("Left");
		else
			canvas.setDirect("Right"); 
	}
	
}



