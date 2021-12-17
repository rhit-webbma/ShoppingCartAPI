
public class IndianaTax implements Taxable{

	@Override
	public double calculateTax(double amount) {
		// TODO Auto-generated method stub
		return (1 + .07) * amount;
	}

}
