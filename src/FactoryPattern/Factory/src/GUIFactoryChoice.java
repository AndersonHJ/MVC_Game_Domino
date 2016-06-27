package FactoryPattern.Factory.src;



/**
 * 
 * @author J Paul Gibson
 * @version 1 
 * Simulate the setting of OS type by reading from a configuration file.<br>
 * A random choice will lead to construction of either a Windows or an OSX factory
 */
abstract class GUIFactoryChoice{
    public enum OS_Type {Win, OSX}

    protected static OS_Type readFromConfigFile(String param){
     if (Math.random() > 0.5) return OS_Type.Win; 
        else return OS_Type.OSX;
    }

    public static GUIFactory getFactory(){
    	
        OS_Type sys = readFromConfigFile("OS_TYPE");
        switch (sys) {
            case Win:
                return WindowsFactory.getInstance();
            case OSX:
                return  OSXFactory.getInstance();
        }
        throw new IllegalArgumentException("The OS type " + sys + " is not recognized.");
     }

    public abstract Button createButton();
}


