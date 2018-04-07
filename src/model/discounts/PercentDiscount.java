package model.discounts;

import model.Cart;
import model.CartItem;

public class PercentDiscount implements Discount {

	private double discountRate;
	
	public PercentDiscount(double discountRate){
		this.discountRate = discountRate;
	}
	
	public boolean canApply(Cart cart){
		return cart.totalPriceOfProducts()>300;
	}
	
	public void apply(Cart cart){
		for(CartItem item:cart.getItems()){
			item.setCurrentPrice(item.getCurrentPrice()*(1-discountRate));
		}
	}
}
