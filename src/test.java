import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class test {

	@Test
	public void AddRequestTest1() {
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount newDiscount = new Discount();
		Cart testCart = new Cart(testStock, newDiscount);
		
		AddRequest req1 = new AddRequest(testCart, testStock, "10", 10);
		
		assertEquals("10", req1.getPassedItemName());
		assertFalse(req1.getPassedItemName() == "12");
		
		req1.generateResponse();
		
		HashMap<Item, Integer> cartContents = testCart.getCartContents();
		
		for(Map.Entry<Item, Integer> entry : cartContents.entrySet()) {
			Item currentItem = entry.getKey();
			
			if(currentItem.getItemName().equals("10"))
			{
				assertTrue(true);
			}
		}	
	}
	
	@Test
	public void AddRequestTest2() {
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount newDiscount = new Discount();
		Cart testCart = new Cart(testStock, newDiscount);
		
		AddRequest req1 = new AddRequest(testCart, testStock, "3", 2);
		
		assertEquals("3", req1.getPassedItemName());
		assertFalse(req1.getPassedItemName() == "10");
		
		req1.generateResponse();
		
		HashMap<Item, Integer> cartContents = testCart.getCartContents();
		
		for(Map.Entry<Item, Integer> entry : cartContents.entrySet()) {
			Item currentItem = entry.getKey();
			
			if(currentItem.getItemName().equals("10"))
			{
				assertTrue(true);
			}
		}	
	}
	
	@Test
	public void AddRequestTestFail() {
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount newDiscount = new Discount();
		Cart testCart = new Cart(testStock, newDiscount);
		
		AddRequest req1 = new AddRequest(testCart, testStock, "12", 2);
		
		assertFalse(req1.generateResponse());
	}
	
	@Test
	public void ViewRequestTest1()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount newDiscount = new Discount();
		Cart testCart = new Cart(testStock, newDiscount);
		IndianaTax stateTax = new IndianaTax();
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "1", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "5", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		ViewRequest req2 = new ViewRequest(testCart, stateTax);
				
		req2.generateResponse();
		
	}
	
	@Test
	public void ViewRequestTest2()
	{	
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount newDiscount = new Discount();
		OhioTax stateTax = new OhioTax();
		Cart testCart = new Cart(testStock, newDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "1", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "5", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		ViewRequest req2 = new ViewRequest(testCart, stateTax);
		
		req2.generateResponse();
		
	}
	
	@Test
	public void DiscountRequestTest1()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "3", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "9", 2);
		
		req1.generateResponse();
		
		double prevTotalPrice = testCart.getcartTotal();
		
		DiscountRequest req2 = new DiscountRequest(testCart, testDiscount, "DCBA");
		req2.generateResponse();
		
		
		//Using Delta = 1 to account for precision loss with delta
		assertEquals(prevTotalPrice, (prevTotalPrice * 0.5), 1);
	}
	
	@Test
	public void DiscountRequestTest2()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "5", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "1", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		double prevTotalPrice = testCart.getcartTotal();
		
		DiscountRequest req2 = new DiscountRequest(testCart, testDiscount, "WAME");
		req2.generateResponse();
		
		
		//Using Delta = 1 to account for precision loss with delta
		assertEquals(prevTotalPrice, (prevTotalPrice * 0.05), 1);
	}
	
	@Test
	public void DiscountRequestTestNotExist()
	{		
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "5", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "1", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		double prevTotalPrice = testCart.getcartTotal();
		
		DiscountRequest req2 = new DiscountRequest(testCart, testDiscount, "MIKE");
		req2.generateResponse();
		
		
		//Using Delta = 1 to account for precision loss with delta
		assertEquals(prevTotalPrice, (prevTotalPrice * 0.0), 1);
	}

	
	@Test
	public void QuantityRequestTest1()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "9", 2);
		
		req1.generateResponse();
		
		QuantityRequest req3 = new QuantityRequest(testCart, "2", 1);
		
		req3.generateResponse();
		
		Item checkItem = testStock.findItem("2");
		
		int checkQuantity = testCart.getCartContents().get(checkItem);
			
		assertEquals(checkQuantity, 1);
	}
	
	@Test
	public void QuantityRequestTest2()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "9", 2);
		
		req1.generateResponse();
		
		QuantityRequest req3 = new QuantityRequest(testCart, "9", 3);
		
		req3.generateResponse();
		
		Item checkItem = testStock.findItem("9");
		
		int checkQuantity = testCart.getCartContents().get(checkItem);
			
		assertEquals(checkQuantity, 3);
	}
	
	@Test
	public void QuantityRequestTestNotEnough()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "9", 2);
		
		req1.generateResponse();
		
		QuantityRequest req3 = new QuantityRequest(testCart, "10", 35);
		
		req3.generateResponse();
		
		Item checkItem = testStock.findItem("10");
		
		int checkQuantity = testCart.getCartContents().get(checkItem);
			
		assertEquals(checkQuantity, 29);
	}
	
	@Test
	public void QuantityRequestTestNegativeQuantity()
	{
		Stock testStock = new Stock();
		testStock.populateStock();
		Discount testDiscount = new Discount();
		testDiscount.populateCodes();
		Cart testCart = new Cart(testStock, testDiscount);
		AddRequest req1;
		
		req1 = new AddRequest(testCart, testStock, "10", 1);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "6", 2);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "2", 3);
		
		req1.generateResponse();
		
		req1 = new AddRequest(testCart, testStock, "9", 2);
		
		req1.generateResponse();
		
		QuantityRequest req3 = new QuantityRequest(testCart, "2", -10);
		
		assertFalse(req3.generateResponse());
	}
}
