
public class QuantityRequest implements Requestable{

	private Cart newCart;
	private String itemName;
	private int quantity;
	
	
	public QuantityRequest(Cart newCart, String itemName, int quantity)
	{
		this.newCart = newCart;
		this.itemName = itemName;
		this.quantity = quantity;
		
	}
	
	@Override
	public boolean generateResponse() {
		// TODO Auto-generated method stub
		
		if(quantity < 0) return false;
		
		newCart.adjustQuantity(itemName, quantity);
		return true;	
	}

	@Override
	public boolean reject() {
		return false;
		// TODO Auto-generated method stub
		
	}

}
