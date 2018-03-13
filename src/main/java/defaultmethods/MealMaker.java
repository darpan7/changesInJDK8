package defaultmethods;

import support.IO;

/**
* @date @Mar 13, 2018 @12:53:00 PM
* @author Darpan Shah
*
*/
public interface MealMaker {
	
	void gatherRequirements();
	
	void prepareVeggies();
	
	void makeMeal();
	
	void addVeggies();

	// default does not let you to change existing implemented classes. 
	// Instead, it extends interface methods.
	// In future, if some method requires, it can be added by default easily
	// without touching other implemented classes!
	// SamosaMeal does not override default method because it does not need to.
	// whereas PaniPuriMeal overrides it.
	default void addToppings(){
		IO.print("Nothing to add topping! Your meal is ready!");
	}

}
