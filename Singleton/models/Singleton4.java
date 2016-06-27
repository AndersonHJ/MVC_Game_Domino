package models;

import tests.TestSingleton4;

/**
 * @author J Paul Gibson
 * <tt> Singleton4 </tt> is an implementation of a class that
* only allows one instantiation.<br>
* 
* Follows Java specific design proposed by Bill Pugh 
* from <em> Concurrent programming in Java: design principles and patterns</em><br>
* 
* It has a simple state of a single integer variable {@link Singleton4#data}.<br><br>
* Tested by {@link TestSingleton4}
*/
public class Singleton4 {
	
	
	/**
	 * An instance attribute - for illustrative purposes
	 */
	private int data; 
	
	/**
	 * The constructor is private so that it is controlled by the class.<br>
	 * Initially the {@link Singleton4#data} value is set to 0.<br><br>
	 */
	private Singleton4() { data=0; }
	 
	  /**
	   * SingletonHolder is loaded on the first execution of Singleton4.getInstance() 
	   * or the first access to SingletonHolder.INSTANCE, not before.
	   */
	  private static class SingletonHolder { 
	    private static final Singleton4 INSTANCE = new Singleton4();
	  }

	  public static Singleton4 getInstance() {
	    return SingletonHolder.INSTANCE;
	  }
	  
	  /**
	   * {@link Singleton4#data} getter method
	   * @return data
	   */
	  public int getData(){return data;}

	  /**
	   * {@link Singleton4#data} setter method
	   * @param d defines the new data value
	   */
	  public void setData(int d){data =d;}

}
