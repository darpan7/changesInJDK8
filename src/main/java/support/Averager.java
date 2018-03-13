package support;

import java.util.function.DoubleConsumer;

/**
* @date Mar 12, 2018 2:00:51 PM
* @author Darpan Shah
*
*/
public class Averager implements DoubleConsumer{

	private double totalPrice = 0;
	private double countItems = 0;
	
	public double average(){
		return countItems > 0 ? totalPrice/countItems : 0;
	}
	@Override
	public void accept(double value) {
		totalPrice += value;
		++countItems;
	}
	
	public void mergeIntermediateAverage(Averager previous) {
		totalPrice += previous.totalPrice;
		countItems += previous.countItems;
	}	

}
