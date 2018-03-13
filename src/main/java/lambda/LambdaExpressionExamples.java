package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import home.Item;
import home.Item.ITEM_TYPE;
import support.Averager;
import support.IO;
import support.Validator;

/**
* @date Mar 11, 2018 12:50:46 AM
* @author Darpan Shah
*
*/
/**
 * Treat functionality as an argument to another method!
 */
public class LambdaExpressionExamples {

	public void printItemsUsingPredicateWithJDK8(List<Item> items, Predicate<Item> validator, Consumer<Object> consumer){
		for(Item item: items){
			if(validator.test(item)){
				consumer.accept(item);
			}
		}
	}
	
	public <X,Y> void printItemTypesWithJDK8(Iterable<X> items, Predicate<X> validator, Function<X, Y> mapper, Consumer<Y> consumer){
		for(X item: items){
			if(validator.test(item)){
				consumer.accept(mapper.apply(item));
			}
		}
	}
	
	public void printItemsWithoutJDK8(List<Item> items, Validator validator){
		for(Item item: items){
			if(validator.validate(item)){
				item.print();
			}
		}
	}
	public void printItemsWithJDK8(List<Item> items){
		items.forEach(item -> item.print());
	}
	
	public void printElectronicsItemTypesUsingLambdaWithJDK8(List<Item> items){
		items.stream()
			 .filter(item -> item.getType().equals(ITEM_TYPE.ELECTRONICS))
			 .map(item -> item.getType())
			 .forEach(type -> System.out.println(type));
	}
	
	public void printItemsUsingLambdaWithJDK8(List<Item> items){
		items.stream()
			 .filter(item -> item!=null)
//			 .map(item -> item)
			 .forEach(item -> System.out.println("Item: " + item.getItemName() + ", Dept: " + item.getBelongsTo().name()));
	}
	
	public void printItemsUsingLambdaCollectorsJDK8(List<Item> items){
		// collectors: best suited for collections.
		IO.print("\nPrint average of all items price using JDK8 stream, method reference, collector!");
		// average requires total sum and no of items as well.
		// collect returns ONLY one value throughout the stream. So we need some kind of placer where we will keep storing sum, count during stream.
		Averager avg = items
			.stream()
			.map(Item::getPrice) 
			// alternate of item -> item.getPrice()
			.collect(Averager::new, Averager::accept, Averager::mergeIntermediateAverage); 
			//accept takes one double value from stream and call merge.. method, which combines previous averger`s sum, count.
			// All Averager`s methods have no return type except for average which is not used in stream processing.
		IO.print("Average of price: " + String.format("%.4f", avg.average()));
		
		IO.print("\nPrint total of items price using JDK8 stream, collector, suming!");
		double total = items
			.stream()
			.collect(Collectors.summingDouble(Item::getPrice)); // no need for map as well.
		IO.print("Total price: " + String.format("%.4f", total)); // same result
		
		IO.print("\nPrint total of all items price using JDK8 stream, collector toList!");
		List<Double> prices = items
			.stream()
			.map(Item::getPrice) 
			// alternate of item -> item.getPrice()
			.collect(Collectors.toList()); 
			// collects stream of elements i.e. price, and creates a List of price.
		IO.print("List of prices: " + prices); 
		
		IO.print("\nPrint total of all items price using JDK8 stream, collector toCollection!");
		prices = items
			.stream()
			.map(Item::getPrice) 
			.collect(Collectors.toCollection(ArrayList::new)); // same as toList: Here, we can get prices in any list form; TreeSet, HashSet, ArrayList.
		IO.print("List of prices: " + prices);
		
		IO.print("\nPrint total of all items price using JDK8 stream, collector joining!");
		String priceString = items
			.stream()
			.map(Item::getPrice)
			.map(Object::toString) //basically, double.toString() as upper map converts stream of Item into stream of Double
			.collect(Collectors.joining(", ")); // same as toList.
		IO.print("List of prices: [" + priceString + "]"); 
		
		IO.print("\nPrint items based on type using JDK8 stream, collector grouping!");
		Map<ITEM_TYPE, List<Item>> byType = items
			.stream()
			.collect(Collectors.groupingBy(Item::getType));
		IO.print("Items by Type: " + byType ); 
		
		IO.print("\nPrint items based on type using JDK8 stream, collector grouping!");
		Map<ITEM_TYPE, Double> sumByType = items
			.stream()
			.collect(Collectors.groupingBy(Item::getType, Collectors.summingDouble(Item::getPrice)));
		IO.print("Total prices by Type: " +  sumByType); 
		
		IO.print("\nPrint items based on type using JDK8 stream, collector grouping!");
		Map<ITEM_TYPE, Optional<Item>> largetstByType = items
			.stream()
			.collect(Collectors.groupingBy(Item::getType, Collectors.maxBy(Comparator.comparing(Item::getPrice) )));
		IO.print("Total prices by Type: " +  largetstByType); 
	}
	
	public void printItemsUsingLambdaFunctionJDK8(List<Item> items){
		IO.print("\nPrint total of all items price using JDK8 stream!");
		double total = items
			.stream()
			.mapToDouble(item -> item.getPrice())
			.sum();
		IO.print("Total of price: " + String.format("%.4f", total));
		
		IO.print("\nPrint total of all items price using JDK8 stream, method reference!");
		total = items
			.stream()
			.mapToDouble(Item::getPrice) 
			// alternate of item -> item.getPrice()
			.sum();
		IO.print("Total price: " + String.format("%.4f", total)); 
		// same result
		
		IO.print("\nPrint average of all items price using JDK8 stream!");
		double average = items
			.stream()
			.mapToDouble(item -> item.getPrice()) 
			// can apply method reference as well= Item::getPrice
			.average()
			.getAsDouble();
		IO.print("Average of price: " + String.format("%.4f", average));
		
		IO.print("\nPrint total of Furniture items price using JDK8 stream!");
		total = items
			.stream()
			.filter(item -> item.getType().equals(ITEM_TYPE.FURNITURE)) 
			// works as Validator, Predicate.
			.mapToDouble(Item::getPrice) 
			// alternate of item -> item.getPrice()
			.sum();
		IO.print("Total price: " + String.format("%.4f", total)); // same result
		
		IO.print("\nPrint average of Furniture items price using JDK8 stream!");
		average = items
			.stream()
			.filter(item -> item.getType().equals(ITEM_TYPE.FURNITURE)) 
			// works as Validator, Predicate.
			.mapToDouble(item -> item.getPrice()) 
			// can apply method reference as well= Item::getPrice
			.average()
			.getAsDouble();
		IO.print("Average of price: " + String.format("%.4f", average));		
	}
	
	public void printItemsUsingLambdaReductionJDK8(List<Item> items){
		IO.print("\nPrint total of all items price using JDK8 stream, reduction!");
		double total = items
			.stream()
			.map(Item::getPrice) 
			// alternate of item -> item.getPrice()
			.reduce(0.0, (a, b) -> a + b); 
			// sum() wont work as we did not use mapToDouble, here stream is list of items not list of doubles. 0.0 is initial value.
			// reduce always returns a new value. Degrades performance if we use reduce for large collection/objects. For that, better to use collect method.
		IO.print("Total price: " + String.format("%.4f", total)); // same result
	}
}
