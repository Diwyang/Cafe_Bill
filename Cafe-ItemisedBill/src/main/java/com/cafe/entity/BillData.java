package com.cafe.entity;

import java.util.List;

public class BillData {
	
	private List<Billing> itemRequest;
	private double total;
	private Discount discount;
	private double finalAmount;
	
	
	public BillData(List<Billing> itemRequest, double total, Discount discount, double finalAmount) {
		super();
		this.itemRequest = itemRequest;
		this.total = total;
		this.discount = discount;
		this.finalAmount = finalAmount;
	}


	public BillData() {
		super();
	}


	public List<Billing> getItemRequest() {
		return itemRequest;
	}


	public void setItemRequest(List<Billing> itemRequest) {
		this.itemRequest = itemRequest;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Discount getDiscount() {
		return discount;
	}


	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


	public double getFinalAmount() {
		return finalAmount;
	}


	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillData)) return false;

        BillData that = (BillData) o;

        if (Double.compare(that.total, total) != 0) return false;
        if (Double.compare(that.finalAmount, finalAmount) != 0) return false;
        if (!itemRequest.equals(that.itemRequest)) return false;
        return discount.equals(that.discount);
    }
	
}
