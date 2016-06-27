package models;

import tests.TestSingleton2;

/**
 * @author J Paul Gibson
 * @version 3
 * <tt> Singleton3 </tt> is an implementation of a class that
* only allows one instantiation.<br>
* It has a simple state of a single integer variable {@link Singleton2#Data}.<br><br>
* Tested by {@link TestSingleton2}
*/
public class Singleton3 {
	
	/**
	 * The reference to the one and only instance.<br>
	 */
	private static final Singleton3 instance = new Singleton3();
	
	/**
	 * An instance attribute - for illustrative purposes
	 */
	private int data; 
	
	/**
	 * The constructor is private so that it is controlled by the class.<br>
	 * Initially the {@link Singleton3#data} value is set to 0.<br><br>
	 */
	private Singleton3() { data=0; }
	
	/**
	 * @return the unique instance
	 */
	public static Singleton3 instance() {return instance;}
	
	/**
	 * {@link Singleton3#data} getter method
	 * @return data
	 */
	public int getData(){return data;}

	/**
	 * {@link Singleton3#data} setter method
	 * @param d defines the new data value
	 */
	public void setData(int d){data =d;}
	
}
