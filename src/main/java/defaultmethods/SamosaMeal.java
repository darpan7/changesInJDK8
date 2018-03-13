package defaultmethods;

import support.IO;

/**
* @date @Mar 13, 2018 @1:05:20 PM
* @author Darpan Shah
*
*/
public class SamosaMeal implements MealMaker{

	@Override
	public void gatherRequirements() {
		IO.print("=== Gather following items ===");
		IO.print("1. Wheate flour");
		IO.print("2. All spicy masala. i.e. salt, corriander powder, chilli powder.");
		IO.print("3. Green boiled peas");
		IO.print("4. Milk");
	}

	@Override
	public void prepareVeggies() {
		IO.print("=== Prepare Veggies ===");
		IO.print("1. Make batter of wheat flour, water, oil.");
		IO.print("2. Cut onions, garlic, ginger, chillies.");
	}

	@Override
	public void makeMeal() {
		gatherRequirements();
		prepareVeggies();
		addVeggies();
		makeSamosa();
		addToppings();
	}

	@Override
	public void addVeggies() {
		IO.print("=== Add Vegetables ===");
		IO.print("1. Smash potatoes");
		IO.print("2. Add peas.");
	}
	
	public void makeSamosa(){
		IO.print("=== Make base curry ===");
		IO.print("1. Add chopped onions, garlic, ginger, chillies in boiled pan");
		IO.print("2. Add mix with smash potatoes. Mix it well.");
		IO.print("3. Put that mix in traingle of wheat flour cup.");
		IO.print("4. stick borders of that traingle cup with milk.");
		IO.print("5. Add them into frying pan. Take out when it becomes brown.");
	}

}
