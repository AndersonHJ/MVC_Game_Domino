package FactoryPattern.Factory.src;



public class WindowsButton extends Button{
	
    public void paint(){
        System.out.println("WindowsButton: "+ getCaption());
    }
} 
