package defaultmethods;

import support.IO;

/**
* @date @Mar 13, 2018 @1:31:13 PM
* @author Darpan Shah
*
*/
public class Start {
	public static void main(String[] args) {
		MealMaker samosa = new SamosaMeal();
		MealMaker meal = new PaniPuriMeal();
		samosa.makeMeal();
		IO.print("");
		meal.makeMeal();
	}
}
