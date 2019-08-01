package com.cafe.item;

import com.cafe.discount.ApplyDiscountOnAmount;
import com.cafe.entity.Beverages;
import com.cafe.entity.Discount;
import com.cafe.item.beverages.Coffee;
import com.cafe.item.beverages.ColdDrinks;
import com.cafe.item.beverages.Tea;

public class CafeItemLoader {

	private static CafeItem cafeItems = new CafeItem();

	public static CafeItem getItems() {
		return cafeItems;
	}

	public static void load() {

		getItems().addItem("Tea","TM", "Masala", 10);
		getItems().addItem("Tea","TI", "Iced", 15);
		getItems().addItem("Tea","TL", "Lemon", 15);

		getItems().addItem("Coffee", "CC", "Cold", 15);
		getItems().addItem("Coffee", "CL", "Latte", 30);
		getItems().addItem("Coffee", "CM", "Mocha", 40);
		
		getItems().addItem("ColdDrinks", "CDC", "Coke", 20);
		getItems().addItem("ColdDrinks", "CDP", "Pepsi", 20);
		getItems().addItem("ColdDrinks", "CDS", "Sprite", 15);
		
		getItems().addDiscount(new ApplyDiscountOnAmount(100, 200, 10));
		getItems().addDiscount(new ApplyDiscountOnAmount(200, 0, 20));

	}

}
