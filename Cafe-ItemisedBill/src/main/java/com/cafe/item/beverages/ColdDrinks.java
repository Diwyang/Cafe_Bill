package com.cafe.item.beverages;

import com.cafe.entity.Beverages;

public class ColdDrinks extends Beverages {

	public ColdDrinks(String id, String description, double price) {
		super(id, description, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cold Drinks - " + getDescription();
	}
	
	
	

}
