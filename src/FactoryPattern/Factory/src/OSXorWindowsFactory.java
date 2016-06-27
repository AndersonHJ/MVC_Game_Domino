package FactoryPattern.Factory.src;




/**
 * 
 * @author J Paul Gibson
 * @version 1
 * Check that different factories can be used but only 1 factory object of each type is ever created
 *<br>
 EXPECTED (TYPICAL) OUTPUT
 <pre>
Using factory p_factory.WindowsFactory@1fb8ee3 to construct aButton
WindowsButton: Push a
Using factory p_factory.OSXFactory@14318bb to construct bButton
OSXButton: Push b
Using factory p_factory.WindowsFactory@1fb8ee3 to construct cButton
WindowsButton: Push c
</pre>
 */
public class OSXorWindowsFactory {

	 public static void main(String[] args){
	    	
	        GUIFactory aFactory = GUIFactoryChoice.getFactory();
	        System.out.println("Using factory "+ aFactory+" to construct aButton");
	        Button aButton = aFactory.createButton();
	        aButton.setCaption("Push a");
	        aButton.paint();

	        GUIFactory bFactory = GUIFactoryChoice.getFactory();
	        System.out.println("Using factory "+ bFactory+" to construct bButton");
	        Button bButton = bFactory.createButton();
	        bButton.setCaption("Push b");
	        bButton.paint();
	        
	        GUIFactory cFactory = GUIFactoryChoice.getFactory();
	        System.out.println("Using factory "+ cFactory+" to construct cButton");
	        Button cButton = cFactory.createButton();
	        cButton.setCaption("Push c");
	        cButton.paint();
	    }
	 
}
