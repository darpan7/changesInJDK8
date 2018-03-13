package lambda;

import home.Department;
import home.Item;
import home.Item.ITEM_TYPE;
import home.LivingRoom;
import support.IO;
import support.Validator;

/**
* @date Mar 11, 2018 7:23:55 PM
* @author Darpan Shah
*
*/
public class Start {
	public static void main(String[] args) {
		LambdaExpressionExamples processor = new LambdaExpressionExamples();
		Department dept = new LivingRoom();
		
		IO.print("Print only electronics items WITH JDK8!");
		processor.printItemsUsingPredicateWithJDK8(
				dept.loadItems().items(), 
				item -> item.getType().equals(ITEM_TYPE.ELECTRONICS),
				// passing condition(functionality) as argument for this method.
				item -> ((Item)item).print() 
				// passing print method as an argument for this method.
		);
		
		IO.print("\nPrint electronics item types WITH JDK8!");
		processor.printItemTypesWithJDK8(
				dept.loadItems().items(), 
				item -> item.getType().equals(ITEM_TYPE.ELECTRONICS), 
				// passing condition(functionality) as argument for this method.
				item -> item.getType(), 
				// Function<Item, String>: returns each item`s type and pass it to Consumer.
				item -> IO.print("" + item) 
				// passing print method as an argument for this method.
		);
		
		IO.print("\nPrint electronics item types WITH JDK8 using Method Reference!");
		processor.printItemTypesWithJDK8(
				dept.loadItems().items(), 
				item -> item.getType().equals(ITEM_TYPE.ELECTRONICS), 
				// passing condition(functionality) as argument for this method.
				Item::getType, 
				// Alternate of: item -> item.getType(), // Function<Item, String>: returns each item`s type and pass it to Consumer.
				item -> IO.print("" + item) 
				// passing print method as an argument for this method.
		);
		
		IO.print("\nPrint item types WITH JDK8!");
		processor.printItemTypesWithJDK8(
				dept.loadItems().items(), 
				item -> true, 
				// passing condition(functionality) as argument for this method.
				item -> item.getType(), 
				// Function<Item, String>: returns each item`s type and pass it to Consumer.
				item -> IO.print(item) 
				// passing print method as an argument for this method.
		);
		
		IO.print("\nPrint only furniture items WITH JDK8!");
		processor.printItemsUsingPredicateWithJDK8(
				dept.loadItems().items(), 
				item -> item.getType().equals(ITEM_TYPE.FURNITURE), 
				// passing condition(functionality) as argument for this method.
				item -> IO.print(item.toString()) 
				// passing print statement as an argument for this method.
		);
		
		IO.print("\nPrint only electronics items WITHOUT JDK8!");
		processor.printItemsWithoutJDK8(
				dept.loadItems().items(), 
				new Validator(){ // passing Anonymous class.
					public boolean validate(Item item){
						if(item.getType().equals(ITEM_TYPE.ELECTRONICS))
							return true;
						return false;
					}
				}
		);
		
		IO.print("\nPrint items!");
		processor.printItemsWithJDK8(dept.loadItems().items());
		
		IO.print("\nPrint electronic items using JDK8 stream!");
		processor.printElectronicsItemTypesUsingLambdaWithJDK8(dept.loadItems().items());
		
		IO.print("\nPrint items using JDK8 stream!");
		processor.printItemsUsingLambdaWithJDK8(dept.loadItems().items());
		

		// lambda reduction
		processor.printItemsUsingLambdaReductionJDK8(dept.loadItems().items());
		
		// lambda map, aggregate functions
		processor.printItemsUsingLambdaFunctionJDK8(dept.loadItems().items());
		
		// lambda collectors
		processor.printItemsUsingLambdaCollectorsJDK8(dept.loadItems().items());
	}
}
