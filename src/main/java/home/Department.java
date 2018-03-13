package home;

import java.util.List;

/**
* @date Mar 11, 2018 1:08:20 AM
* @author Darpan Shah
*
*/
public interface Department {
	
	String name();
	
	List<Item> items();
	
	Department loadItems();
}
