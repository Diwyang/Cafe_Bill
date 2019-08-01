package com.cafe.item.beverages;

import com.cafe.entity.Beverages;

public class Coffee extends Beverages {

	public Coffee(String id, String description, double price) {
		super(id, description, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Coffee - " + getDescription();
	}

}
