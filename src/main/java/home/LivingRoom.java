package home;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import home.Item.ITEM_TYPE;

/**
* @date Mar 11, 2018 1:12:06 AM
* @author Darpan Shah
*
*/
public class LivingRoom implements Department{
	private String deptName;
	private List<Item> items;
	
	
	public LivingRoom() {
		super();
		this.deptName = "Living Room";
		this.items = new ArrayList<Item>();
	}

	public List<Item> items() {
		return items;
	}

	public String name() {
		return deptName;
	}

	@Override
	public Department loadItems() {
		if(items.size() > 0){
			return this;
		}
//		items.clear();
		for(int i=0; i<6; i++){
			if(i%2 == 0)
				items.add(new Item("item"+i, this, ITEM_TYPE.FURNITURE, ThreadLocalRandom.current().nextDouble(0, 10000)));
			else
				items.add(new Item("item"+i, this, ITEM_TYPE.ELECTRONICS, ThreadLocalRandom.current().nextDouble(0, 10000)));
		}
		return this;
	}

}
