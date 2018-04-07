import java.util.ArrayList;

import model.Cart;
import model.CartItem;
import model.Product;
import model.discounts.FreeCupDiscount;
import model.discounts.PercentDiscount;


public class Program {

	public static void main(String[] args) {
		Cart cart = getSampleCart();
		
		PercentDiscount fivePercentDiscount = new PercentDiscount(0.05);
		FreeCupDiscount freeCup = new FreeCupDiscount();
		cart.applyDiscount(fivePercentDiscount);
		cart.applyDiscount(freeCup);
		printCart(cart);
		
	}

	public static void printCart(Cart cart){
		System.out.println("================================");
		System.out.println("Nazwa \t\t|Cena\t|Cena Promocyjna|");
		System.out.println("--------------------------------");
		for(CartItem item:cart.getItems()){
			System.out.println(
					item.getProduct().getName()
					+ "\t|"
					+ item.getProduct().getPrice()
					+ "\t|"
					+ item.getCurrentPrice()
					);
			System.out.println("--------------------------------");
		}
		System.out.println("Suma: "+cart.totalPriceOfProducts());
		System.out.println("Suma po promocji: "+cart.totalPriceOfDiscountedProducts());
		
	}
	
	public static Cart getSampleCart(){
		Cart cart = new Cart();
		for(Product p:getSampleProducts()){
			cart.getItems().add(new CartItem(p));
		}
		return cart;
	}
	
	public static ArrayList<Product> getSampleProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		
		for(int i=1;i<=5;i++){
			Product p = new Product();
			p.setName("Product "+i);
			p.setPrice(i*25);
			products.add(p);
		}
		return products;
	}
}
