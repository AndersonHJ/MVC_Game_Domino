package tests;

import models.Singleton3;

/**

 * Test class for {@link Singleton3}<br>
 * 
 * <ul>
 * <li> Construct 2 {@link Singleton3} objects using the instance method</li>
 * <li> Set the data value of the first and print info. concerning both objects to the screen</li>
 * <li> Check that the references and values for both objects are the same</li>
 * </ul>
 * <br>
 * EXPECTED (TYPICAL) OUTPUT
 * 
<pre>
First singleton3: Singleton4.Singleton3@19821f
First singleton3 data value =  34
Second singleton3: Singleton4.Singleton3@19821f
Second singleton3 data value =  34
</pre>
 * 
 * @author J Paul Gibson
 * 
 * @version 1
 */
public class TestSingleton3 {

	public static void main(String args[]) {	
   // Construct 2 singleton3 objects using the instance method
	Singleton3 s1a = Singleton3.instance();
	Singleton3 s1b = Singleton3.instance();
	// Set the data value.
	s1a.setData(34);
	System.out.println("First singleton3: " + s1a);
	System.out.println("First singleton3 data value =  " +s1a.getData());
	System.out.println("Second singleton3: " + s1b);
	System.out.println("Second singleton3 data value =  " +s1b.getData());
	}
}
