import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Stock {

	private HashMap<Item, Integer> currentStock;
	
	public HashMap<Item, Integer> getCurrentStock() {
		return currentStock;
	}
	
	public void populateStock()
	{
		Item newItem = new Item("1", "test 1", "Test Description for Item 1", 35.16, "pic", 0.10);
		currentStock.put(newItem, 15);
		newItem = new Item("2", "test 2", "Test Description for Item 2", 12.11, "pic", 0.05);
		currentStock.put(newItem, 10);
		newItem = new Item("3", "test 3", "Test Description for Item 3", 16.12, "pic", 0.2);
		currentStock.put(newItem, 12);
		newItem = new Item("4", "test 4", "Test Description for Item 4", 55.13, "pic", 0.3);
		currentStock.put(newItem, 8);
		newItem = new Item("5", "test 5", "Test Description for Item 5", 9.05, "pic", 0.4);
		currentStock.put(newItem, 6);
		newItem = new Item("6", "test 6", "Test Description for Item 6", 1.02, "pic", 0.03);
		currentStock.put(newItem, 2);
		newItem = new Item("7", "test 7", "Test Description for Item 7", 12.16, "pic", 0.02);
		currentStock.put(newItem, 3);
		newItem = new Item("8", "test 8", "Test Description for Item 8", 96.78, "pic", 0.05);
		currentStock.put(newItem, 1);
		newItem = new Item("9", "test 9", "Test Description for Item 9", 100.02, "pic", 0.06);
		currentStock.put(newItem, 5);
		newItem = new Item("10", "test 10", "Test Description for Item 10", 10.11, "pic", 0.11);
		currentStock.put(newItem, 30);

	}
	
	public void decrementStock(Item currentItem, int itemQuantity)
	{
		this.currentStock.replace(currentItem, currentStock.get(currentItem)- itemQuantity);
	}

	public void setCurrentStock(HashMap<Item, Integer> currentStock) {
		this.currentStock = currentStock;
	}

	public Stock()
	{
		currentStock = new HashMap<>();
	}
	
	public int removeItemFromStock(Item item, int itemQuantity)
	{
	
		for(Map.Entry<Item, Integer> entry : this.currentStock.entrySet()) {
		    Item currentItem = entry.getKey();
		    int quantity = entry.getValue();
		    
		    if(currentItem.getItemName().equals(item.getItemName()))
		    {
		    	if(quantity < itemQuantity)
		    	{
		    		decrementStock(currentItem, quantity);
		    		return quantity;
		    	}
		    	else
		    	{
			    	decrementStock(currentItem, itemQuantity);
			    	return itemQuantity;
		    	}
		    }
		}
		return itemQuantity;
		
	}

	public Item findItem(String itemName) {
		// TODO Auto-generated method stub
		for(Map.Entry<Item, Integer> entry : this.currentStock.entrySet()) {
		    Item currentItem = entry.getKey();

		    if(currentItem.getItemName().equals(itemName))
		    {
		    	return currentItem;
		    }
		}
		return null;
	}
	
}
