
public class AddRequest implements Requestable{

	private Cart newCart;
	private Stock inventory;
	private String passedItemName;
	private int passedItemQuantity;

	
	public AddRequest(Cart newCart, Stock newStock, String itemName, int itemQuantity)
	{
		this.newCart = newCart;
		this.inventory = newStock;
		this.passedItemName = itemName;
		this.passedItemQuantity = itemQuantity;
	}
	
	public String getPassedItemName() {
		return passedItemName;
	}

	public int getPassedItemQuantity() {
		return passedItemQuantity;
	}

	
	@Override
	public boolean generateResponse() {
		// TODO Auto-generated method stub
		
		
		
		if(inventory.findItem(passedItemName) == null)
		{
			return this.reject();
		}
		
		Item foundItem = this.inventory.findItem(passedItemName);
		int newQuantity = this.inventory.removeItemFromStock(foundItem, passedItemQuantity);
		
		if(newQuantity != 0)
		{
			this.newCart.addItem(this.inventory.findItem(passedItemName), newQuantity);
		}
		
		return true;
	}

	@Override
	public boolean reject() {
		// TODO Auto-generated method stub
		return false;
	}

}
