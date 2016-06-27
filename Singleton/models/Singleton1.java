package models;



/**
 * @author J Paul Gibson
 * @version 1
 * <tt> Singleton1 </tt> is an implementation of a class that
* only allows one instantiation.<br>
* It has a simple state of a single integer variable {@link Singleton1#data}.<br><br>
* Tested by {@link TestSingleton1}
*/
public class Singleton1 {

/**
 * The protected reference to the one and only instance.<br>
 */
protected static Singleton1 uniqueInstance = null;

/**
 * An instance attribute - for illustrative purposes
 */
private int data;

/**
 * @return the unique instance
 */
public synchronized static Singleton1 instance() {
if(uniqueInstance == null) uniqueInstance = new Singleton1();
return uniqueInstance;
}

/**
 * The constructor is protected so that it is controlled by the class.<br>
 * Initially the {@link Singleton1#data} value is set to 0.<br><br>
 */
protected Singleton1() {data=0;}

/**
 * {@link Singleton1#data} getter method
 * @return data
 */
public int getData(){return data;}

/**
 * {@link Singleton1#data} setter method
 * @param d defines the new data value
 */
public void setData(int d){data =d;}

}
