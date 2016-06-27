package models;

import tests.TestSingleton2;

/**
 * @author J Paul Gibson
 * @version 2
 * <tt> Singleton2 </tt> is an implementation of a class that
* only allows one instantiation.<br>
* It has a simple state of a single integer variable {@link Singleton2#Data}.<br><br>
* Tested by {@link TestSingleton2}
*/
public class Singleton2 {

/**
 * The  reference to the one and only instance.<br>
 */
public static final Singleton2 uniqueinstance = new Singleton2(); 

/**
 * An instance attribute - for illustrative purposes
 */
private int data;

/**
 * The constructor is private so that it is controlled by the class.<br>
 * Initially the {@link Singleton2#data} value is set to 0.<br><br>
 */
private Singleton2() {data=0;}

/**
 * {@link Singleton2#data} getter method
 * @return data
 */
public int getData(){return data;}

/**
 * {@link Singleton2#data} setter method
 * @param d defines the new data value
 */
public void setData(int d){data =d;}

}
