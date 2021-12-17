
public class DiscountRequest implements Requestable{

	private Discount newDiscount;
	private Cart newCart;
	private String discountCode;
	
	public DiscountRequest(Cart newCart, Discount newDiscount, String discountCode)
	{
		this.newDiscount = newDiscount;
		this.newCart = newCart;
		this.discountCode = discountCode;
	}
	
	@Override
	public boolean generateResponse() {
		// TODO Auto-generated method stub
		double discount = newDiscount.getDiscount(discountCode);
		
		newCart.applyCartDiscount(discount);
		
		return true;
	}

	@Override
	public boolean reject() {
		// TODO Auto-generated method stub
		return false;
	}

}
