package com.cafe.entity;

public class Order {

	String id;
	int quantity = 0;
	
	public Order(String id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
