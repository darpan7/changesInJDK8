package defaultmethods;

import support.IO;

/**
* @date Mar 13, 2018 2:00:24 PM
* @author Darpan Shah
*
*/
public class PaniPuriMeal  implements MealMaker{
	@Override
	public void gatherRequirements() {
		IO.print("=== Gather following items ===");
		IO.print("1. Order Puris {You will need a lot!}");
		IO.print("2. All spicy masala. i.e. salt, corriander powder, chilli powder.");
		IO.print("3. Green Mint liquid");
		IO.print("4. Dates mix sweet liquid");
	}

	@Override
	public void prepareVeggies() {
		IO.print("=== Prepare Veggies ===");
		IO.print("1. Cut onions, garlic, ginger, chillies.");
		IO.print("2. Boil potatoes");
	}

	@Override
	public void makeMeal() {
		gatherRequirements();
		prepareVeggies();
		addVeggies();
		makePaniPuri();
		addToppings();
	}

	@Override
	public void addVeggies() {
		IO.print("=== Add Vegetables ===");
		IO.print("1. Smash potatoes");
		IO.print("2. Add peas.");
	}
	
	public void makePaniPuri(){
		IO.print("=== Make base curry ===");
		IO.print("1. Add chopped onions, garlic, ginger, chillies in samshed potatoes");
		IO.print("2. Mix it well.");
		IO.print("3. Make mint liquid");
		IO.print("4. Make dates liquid");
		IO.print("5. Put little mix into Puri.");
	}
	
	public void addToppings(){
		IO.print("=== Add Toppings ===");
		IO.print("1. Pour liquids into puri and enjoy your meal!");
	}
}
