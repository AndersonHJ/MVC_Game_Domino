package tests;

import models.Singleton1;

/**
 * Test class for {@link Singleton1}<br>
 * 
 * <ul>
 * <li> Construct 2 {@link Singleton1} objects using the instance method</li>
 * <li> Set the data value of the first and print info. concerning both objects to the screen</li>
 * <li> Check that the references and values for both objects are the same</li>
 * </ul>
 * <br>
 * EXPECTED (TYPICAL) OUTPUT
 * 
<pre>
First singleton1: Singleton4.Singleton1@19821f
First singleton1 data value =  34
Second singleton1: Singleton4.Singleton1@19821f
Second singleton1 data value =  34
</pre>
 * 
 * @author J Paul Gibson
 * 
 * @version 1:
 */
public class TestSingleton1 {

	public static void main(String args[]) {	
   // Construct 2 singleton1 objects using the instance method
	Singleton1 s1a = Singleton1.instance();
	Singleton1 s1b = Singleton1.instance();
	// Set the data value.
	s1a.setData(34);
	System.out.println("First singleton1: " + s1a);
	System.out.println("First singleton1 data value =  " +s1a.getData());
	System.out.println("Second singleton1: " + s1b);
	System.out.println("Second singleton1 data value =  " +s1b.getData());
	}
}
