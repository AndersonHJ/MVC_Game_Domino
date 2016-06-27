package FactoryPattern.Factory.src;



abstract class GUIFactory{ 
	
    public static GUIFactory getFactory() {
          return WindowsFactory.getInstance();
    }
    
    public abstract Button createButton();
    
}

