import java.util.HashMap;
import java.util.Random;

public class Discount {
	
	private HashMap<String, Double> discountCodes;
	
	public Discount()
	{
		discountCodes = new HashMap<>();
	}
	
	public void populateCodes()
	{
		
		discountCodes.put("ABCD", 0.2);
		discountCodes.put("WAME", 0.05);
		discountCodes.put("JARE", 0.1);
		discountCodes.put("OLTP", 0.3);
		discountCodes.put("DCBA", 0.5);
	}
	
	
	public double getDiscount(String code)
	{
		if(discountCodes.containsKey(code))
		{
			return discountCodes.get(code);
		}
		return 0.0;
		
	}
	
}
