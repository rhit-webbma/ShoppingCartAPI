
public class OhioTax implements Taxable{

	@Override
	public double calculateTax(double amount) {
		// TODO Auto-generated method stub
		return (1 + .0575) * amount;
	}

}
