package FactoryPattern.Factory.src;



class WindowsFactory2 extends GUIFactory2{
	private static WindowsFactory2 factory = new WindowsFactory2();
	
    public static WindowsFactory2 getInstance () {return factory;};
    
    public Button createButton(){
        return(new WindowsButton());
    }
    
    public Menu createMenu(){
        return(new WindowsMenu());
    }
    
}
