
public class Item {
	
	public Item(String itemName, String type, String description, double price, String picture, double discountRate) {
		super();
		this.itemName = itemName;
		this.type = type;
		this.description = description;
		this.price = price;
		this.picture = picture;
		this.discountRate = discountRate;
	}
	
	private String type;
	private String description;
	private double price;
	private String picture;
	private double discountRate;
	private String itemName;
	
	public String displayItem(double prevPrice, double currentPrice, int quantity)
	{
		return
				("\nName: ") + itemName +
				("\nPicture: ") + picture +
				("\nType: ") + type +
				("\nItem Description: ") + description +
				("\nPrevious Price: ") + (price * quantity) +
				("\nNew Price: ") + ((price * quantity) - ((price * quantity) * discountRate));
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
	
}
