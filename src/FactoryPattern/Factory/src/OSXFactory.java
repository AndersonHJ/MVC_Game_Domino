package FactoryPattern.Factory.src;



/**
 * 
 * @author J Paul Gibson
 * @version 1
 * A concrete OSX factory for constructing OSX buttons<br>
 * Implemented as a Singleton4 
 *
 */
class OSXFactory extends GUIFactory{
	private static OSXFactory factory = new OSXFactory();
	
    public static OSXFactory getInstance () {return factory;};
    
    public Button createButton(){
        return(new OSXButton());
    }
}
