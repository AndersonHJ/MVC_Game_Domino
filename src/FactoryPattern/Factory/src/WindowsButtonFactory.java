package FactoryPattern.Factory.src;



/**
 * 
 * @author J Paul Gibson
 * @version 1
 * Test for  simplest factory behaviour:
 * <ul>
 * <li> Make a  Windows Factory and print identifier to screen
 * <li> Make a button using this factory
 * <li> Make a second Windows Factory and print identifier to screen (it should be the same as the first)
 * <li> Make a second button using this factory
 * <li> Write state of buttons to screen 
 * </ul>
 *
 *EXPECTED (TYPICAL) OUTPUT
 <pre>
Using factory p_factory.WindowsFactory@9304b1 to construct aButton
WindowsButton: Push a
Using factory p_factory.WindowsFactory@9304b1 to construct bButton
WindowsButton: Push b
</pre>
 */
public class WindowsButtonFactory {

    public static void main(String[] args){
    	
        GUIFactory aFactory = GUIFactory.getFactory();
        System.out.println("Using factory "+ aFactory+" to construct aButton");
        Button aButton = aFactory.createButton();
        aButton.setCaption("Push a");
        aButton.paint();

        GUIFactory bFactory = GUIFactory.getFactory();
        System.out.println("Using factory "+ bFactory+" to construct bButton");
        Button bButton = bFactory.createButton();
        bButton.setCaption("Push b");
        bButton.paint();
    }
}
