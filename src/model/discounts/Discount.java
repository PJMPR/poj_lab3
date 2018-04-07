package model.discounts;

import model.Cart;

public interface Discount {

	boolean canApply(Cart cart);
	void apply(Cart cart);

}
