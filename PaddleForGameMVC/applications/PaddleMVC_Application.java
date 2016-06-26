package applications;


import models.PaddleBounceViewSimple;


/**
 * Instantiates {@link PaddleBounceViewSimple} and starts its execution <br>
 * For teaching MVC design pattern.
 * 
 * @version 1.0.0
 * @author J Paul Gibson
 */
public class PaddleMVC_Application {
	
	public static void main(String[] args){
		
		PaddleBounceViewSimple application = new PaddleBounceViewSimple();
		application.startgame();
	
		
	}

}
