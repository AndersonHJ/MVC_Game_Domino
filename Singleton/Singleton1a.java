package models;


public class Singleton1a extends Singleton1 {

	/**
	 * 	
	 */
		public String toString () {
			return super.toString()+ ", data value = "+getData();}
	
	
	/**
	 * 
	 * @return the unique instance
	 */
	public synchronized static Singleton1 instance() {
	if(uniqueInstance == null) uniqueInstance = new Singleton1a();
	return  uniqueInstance;
	}
	
}
