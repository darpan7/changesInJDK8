package support;

/**
* @date Mar 11, 2018 1:54:29 AM
* @author Darpan Shah
*
*/
public class IO {

	//public static DecimalFormat formatter = new DecimalFormat(".##");
	
	public static void print(Object object){
		System.out.println((object==null?"Null":object.toString()));
	}
}
