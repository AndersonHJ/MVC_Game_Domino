package FactoryPattern.Factory.src;



public class OSXButton extends Button{
	
    public void paint(){
        System.out.println("OSXButton: "+ getCaption());
    }
} 
