package tests;

import models.Singleton2;

/**

 * Test class for {@link Singleton2}<br>
 * 
 * <ul>
 * <li> Construct 2 {@link Singleton2} objects using the instance method</li>
 * <li> Set the data value of the first and print info. concerning both objects to the screen</li>
 * <li> Check that the references and values for both objects are the same</li>
 * </ul>
 * <br>
 * EXPECTED (TYPICAL) OUTPUT
 * 
<pre>
First singleton2: Singleton4.Singleton2@19821f
First singleton2 data value =  34
Second singleton2: Singleton4.Singleton2@19821f
Second singleton2 data value =  34
</pre>
 * 
 * @author J Paul Gibson
 * 
 * @version 1
 */
public class TestSingleton2 {

	public static void main(String args[]) {	
   // Construct 2 singleton1 objects using the instance method
	Singleton2 s2a = Singleton2.uniqueinstance;
	Singleton2 s2b = Singleton2.uniqueinstance;
	// Set the data value.
	s2a.setData(34);
	System.out.println("First singleton2: " + s2a);
	System.out.println("First singleton2 data value =  " +s2a.getData());
	System.out.println("Second singleton2: " + s2b);
	System.out.println("Second singleton2 data value =  " +s2b.getData());
	}
}
