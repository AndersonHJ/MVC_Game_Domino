package tests;

import models.Singleton4;

/**
 * Test class for {@link Singleton4}<br>
 * 
 * <ul>
 * <li> Construct 2 {@link Singleton4} objects using the instance method</li>
 * <li> Set the data value of the first and print info. concerning both objects to the screen</li>
 * <li> Check that the references and values for both objects are the same</li>
 * </ul>
 * <br>
 * EXPECTED (TYPICAL) OUTPUT
 * 
<pre>
First singleton4: Singleton4.Singleton@19821f
First singleton4 data value =  34
Second singleton4: Singleton4.Singleton@19821f
Second singleton4 data value =  34
</pre>
 * 
 * @author J Paul Gibson
 * 
 * @version 1
 */
public class TestSingleton4 {

	public static void main(String args[]) {	
   // Construct 2 singleton objects using the instance method
	Singleton4 s4a = Singleton4.getInstance();
	Singleton4 s4b = Singleton4.getInstance();
	// Set the data value.
	s4a.setData(34);
	System.out.println("First singleton4: " + s4a);
	System.out.println("First singleton4 data value =  " +s4a.getData());
	System.out.println("Second singleton4: " + s4b);
	System.out.println("Second singleton4 data value =  " +s4b.getData());
	}
}


