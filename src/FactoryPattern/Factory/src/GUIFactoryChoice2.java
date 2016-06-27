package FactoryPattern.Factory.src;




/**
 * 
 * @author J Paul Gibson
 * @version 1 
 * Extend factory with menus
 *
 */
public abstract class GUIFactoryChoice2 extends GUIFactoryChoice {

    public static GUIFactory2 getFactory(){
    	
        OS_Type sys = readFromConfigFile("OS_TYPE");
        switch (sys) {
            case Win:
                return WindowsFactory2.getInstance();
            case OSX:
                return  OSXFactory2.getInstance();
        }
        throw new IllegalArgumentException("The OS type " + sys + " is not recognized.");
     }
    
    public abstract Menu createMenu();
}
