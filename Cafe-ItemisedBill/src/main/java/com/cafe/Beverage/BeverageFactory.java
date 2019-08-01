package com.cafe.Beverage;

import com.cafe.entity.Beverages;
import com.cafe.item.beverages.Coffee;
import com.cafe.item.beverages.ColdDrinks;
import com.cafe.item.beverages.Tea;

public class BeverageFactory {
	
	public static Beverages getBeverage(String type, String code,String description, double price) {
		
		if("Tea".equalsIgnoreCase(type)) {
			return new Tea(code, description, price);
		} else if("Coffee".equalsIgnoreCase(type)) {
			return new Coffee(code, description, price);
		} else if ("ColdDrinks".equalsIgnoreCase(type)) {
			return new ColdDrinks(code, description, price);			
		}
		return new Beverages(type, description, price);
	}

}
