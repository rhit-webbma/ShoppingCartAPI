import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private double cartTotal;
	private HashMap<Item, Integer> cartContents;
	private Discount discount;
	private double totalPrice;
	private Stock inventory;

	
	
	
	public HashMap<Item, Integer> getCartContents() {
		return cartContents;
	}

	public void setCartContents(HashMap<Item, Integer> cartContents) {
		this.cartContents = cartContents;
	}

	public double getcartTotal()
	{
		return this.cartTotal;
	}
	
	
	public Cart(Stock newStock, Discount discount)
	{
		this.inventory = newStock;
		this.cartContents = new HashMap<>();
		this.discount = discount;
		this.totalPrice = 0.0;
	}
	
	public void applyCartDiscount(double discount)
	{
		totalPrice = totalPrice - (totalPrice * discount);
	}
	
	public String displayCart(Taxable stateTax)
	{
		String returnString = "";
		ArrayList<Double> pricesofItems = new ArrayList<>();
		
		returnString += "-----------------Cart-----------------\n";
		
		for(Map.Entry<Item, Integer> entry : this.cartContents.entrySet()) {
			returnString += "\nQuantity: " + entry.getValue();
			returnString += entry.getKey().displayItem(entry.getKey().getPrice(), entry.getKey().getPrice() - (entry.getKey().getPrice() * entry.getKey().getDiscountRate()), entry.getValue());
			returnString += "\n";
			returnString += "--------------------------------------";
			
			double itemPrice = entry.getKey().getPrice();
			double discount = entry.getKey().getDiscountRate();
			
			pricesofItems.add((itemPrice * entry.getValue()) - ((itemPrice * entry.getValue()) * discount));
		}
		
		for(int i = 0; i < pricesofItems.size(); i++)
		{
			totalPrice += pricesofItems.get(i);
		}
		
		
		returnString += "\nCart Price: $" + stateTax.calculateTax(totalPrice);
		
		
		return returnString;
	}
	
	public void adjustQuantity(String itemName, int quantity)
	{
		for(Map.Entry<Item, Integer> entry : this.cartContents.entrySet()) {
			
			if(entry.getKey().getItemName().equals(itemName))
			{
				
				HashMap<Item, Integer> stock = inventory.getCurrentStock();
				int stockQuantity = stock.get(entry.getKey());
				
				if(quantity > stockQuantity)
				{
					entry.setValue(stockQuantity);
					inventory.decrementStock(entry.getKey(), stockQuantity - entry.getValue());
				}
				else
				{	
					entry.setValue(quantity);
					inventory.decrementStock(entry.getKey(), stockQuantity - entry.getValue());
				}
				
				

			}
			
		}
	}
	
	public void addItem(Item newItem, int itemQuantity)
	{
		cartContents.put(newItem, itemQuantity);
	}
	
	public void removeItem(Item itemToRemove)
	{
		cartContents.remove(itemToRemove);
	}
	
	
}
