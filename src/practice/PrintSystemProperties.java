package practice;

import java.util.Properties;

public class PrintSystemProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pros = System.getProperties();
	      pros.list(System.out);
	  
	      // Get a particular System property given its key
	      // Return the property value or null
	      System.out.println(System.getProperty("java.home"));
	      System.out.println(System.getProperty("java.library.path"));
	      System.out.println(System.getProperty("java.ext.dirs"));
	      System.out.println("ClassPath : "+System.getProperty("java.class.path"));
	}

}
