package com.cafe.discount;

import com.cafe.entity.Discount;

public class ApplyDiscountOnAmount extends Discount{
	
	double maxBillAmount;
	double minBillAmount;
	
	public ApplyDiscountOnAmount(double minBillAmount, double maxBillAmount, int discountPercentage) {
		super(discountPercentage);
		this.maxBillAmount = maxBillAmount;
		this.minBillAmount = minBillAmount;
	}

	public boolean isCalculationNeeded(double billAmount) {
		return ((this.minBillAmount == 0 || billAmount > this.minBillAmount) && (billAmount <= this.maxBillAmount || 0 == this.maxBillAmount));
	}

	public double applyDiscount(double billAmount) {
			return (billAmount *  getDiscountPercentage()) / 100;
	}
	
	@Override
	public String toString() {
		return "Discount - " + getDiscountPercentage() + "%";
	}

}
