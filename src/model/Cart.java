package model;

import java.util.ArrayList;

import model.discounts.Discount;
import model.discounts.FreeCupDiscount;
import model.discounts.PercentDiscount;

public class Cart {

	ArrayList<CartItem> items = new ArrayList<CartItem>();
	
	public double totalPriceOfProducts(){
		double sum = 0;
		for(CartItem item : items)
			sum+=item.getProduct().getPrice();
		return sum;
	}
	
	public double totalPriceOfDiscountedProducts(){
		double sum = 0;
		for(CartItem item : items)
			sum+=item.getCurrentPrice();
		return sum;
	}
	
	public ArrayList<CartItem> getItems(){
		return items;
	}

	public void applyDiscount(Discount discount) {
		if(discount.canApply(this))
			discount.apply(this);
		
	}
}
