
public class ViewRequest implements Requestable{

	private Cart newCart;
	private String fullCart;
	private Taxable stateTax;
	
	public ViewRequest(Cart newCart, Taxable stateTax)
	{
		this.newCart = newCart;
		this.fullCart = "";
		this.stateTax = stateTax;
	}
	
	@Override
	public boolean generateResponse() {
		// TODO Auto-generated method stub
		
		fullCart = newCart.displayCart(stateTax);
		System.out.println(fullCart);
		
		return true;
		
		
	}
	
	public String getfullCart()
	{
		return this.fullCart;
	}

	@Override
	public boolean reject() {
		// TODO Auto-generated method stub
		return false;
	}

}
