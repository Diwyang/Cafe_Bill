package com.cafe.entity;

public class Billing {

	String itemName;
	double itemPrice;
	int count;
	
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Billing(String itemName, double itemPrice, int count) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.count = count;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Billing)) return false;

        Billing that = (Billing) o;

        if (count != that.count) return false;
        if (!itemName.equals(that.itemName)) return false;
        return (Double.compare(that.itemPrice, itemPrice) == 0);
        
    }
}
