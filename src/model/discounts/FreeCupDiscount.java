package model.discounts;

import model.Cart;
import model.CartItem;
import model.Product;

public class FreeCupDiscount implements Discount{
	
	public boolean canApply(Cart cart){
		return cart.totalPriceOfProducts()>200;
	}
	
	public void apply(Cart cart){
		Product cup = new Product();
		cup.setName("Nice Cup");
		cup.setPrice(0);
		cart.getItems().add(new CartItem(cup));
	}
}
