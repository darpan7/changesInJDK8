package home;

import support.IO;

/**
* @date Mar 11, 2018 1:10:26 AM
* @author Darpan Shah
*
*/
public class Item {
	public enum ITEM_TYPE{
		FURNITURE, ELECTRONICS, STATIONARY;
	}
	private String itemName;
	private Department belongsTo;
	private ITEM_TYPE type;
	private double price;
	
	public Item(String itemName, Department belongsTo, ITEM_TYPE type, double price) {
		super();
		this.itemName = itemName;
		this.belongsTo = belongsTo;
		this.type = type;
		this.price = price;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Department getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Department belongsTo) {
		this.belongsTo = belongsTo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ITEM_TYPE getType() {
		return type;
	}

	public void setType(ITEM_TYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [" + itemName + ": belongsTo " + belongsTo.name() + ", Type " + type + ", Price " + price + "]";
	}
	public void print(){
		IO.print(this.toString());
	}
	
}
