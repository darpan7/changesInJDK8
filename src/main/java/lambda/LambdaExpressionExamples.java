package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import home.Department;
import home.Item;
import home.Item.ITEM_TYPE;
import home.LivingRoom;
import support.IO;
import support.Validator;

/**
* @date @Mar 11, 2018 @12:50:46 AM
* @author Darpan Shah
*
*/
/**
 * Treat functionality as an argument to another method!
 */
public class LambdaExpressionExamples {

	public void processOnlyElectronicsItemsWithJDK8(List<Item> items, Predicate<Item> validator, Consumer<Item> consumer){
		for(Item item: items){
			if(validator.test(item)){
				consumer.accept(item);
			}
		}
	}
	public void processOnlyElectronicsItemsWithoutJDK8(List<Item> items, Validator validator){
		for(Item item: items){
			if(validator.validate(item)){
				item.print();
			}
		}
	}
	public static void main(String[] args) {
		LambdaExpressionExamples processor = new LambdaExpressionExamples();
		Department dept = new LivingRoom();
		
		IO.print("Print only electronics items WITH JDK8!");
		processor.processOnlyElectronicsItemsWithJDK8(
				dept.loadItems().items(), 
				item -> item.getType().equals(ITEM_TYPE.ELECTRONICS), // passing condition(functionality) as argument for this method.
				item -> item.print() // passing print statement as an argument for this method.
		);
		
		IO.print("\nPrint only electronics items WITHOUT JDK8!");
		processor.processOnlyElectronicsItemsWithoutJDK8(
				dept.loadItems().items(), 
				new Validator(){ // passing Anonymous class.
					public boolean validate(Item item){
						if(item.getType().equals(ITEM_TYPE.ELECTRONICS))
							return true;
						return false;
					}
				}
		);
	}
}
