package com.cafe.entity;

public class Discount {

	int discountPercentage;
	
	

	public Discount(int discountPercentage) {
		super();
		this.discountPercentage = discountPercentage;
	}


	public double applyDiscount(double billAmount) {
		return 0;
	}

	public boolean isCalculationNeeded(double billAmount) {
		return false;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}


	@Override
	public String toString() {
		return "Discount - " + discountPercentage + "%";
	}
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof Discount)) return false;
        Discount that = (Discount) o;
        if (Double.compare(that.discountPercentage, discountPercentage) != 0) return false;
        return true;
	}
}
