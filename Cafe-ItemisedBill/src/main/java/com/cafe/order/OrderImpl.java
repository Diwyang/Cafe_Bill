package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

import com.cafe.billing.BillingService;
import com.cafe.entity.BillData;
import com.cafe.entity.Billing;
import com.cafe.entity.Discount;
import com.cafe.entity.Order;
import com.cafe.item.CafeItemLoader;

public class OrderImpl {

	List<Order> orderList = new ArrayList<Order>();
	List<Billing> billingList = new ArrayList<Billing>();

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public void placeOrder(String id, int quantity) {
		getOrderList().add(new Order(id, quantity));
	}

	public void generateBill() {

		BillData billData = new BillData();
		BillingService billingService = new BillingService();
		billingList = billingService.displayBill(getOrderList());
		billData.setItemRequest(billingList);
		billData.setTotal(billingService.getTotalBillAmountWithOutDisc());
		billData.setDiscount(calculateDiscount(billingService.getTotalBillAmountWithOutDisc()));
		billData.setFinalAmount(billData.getTotal() - billData.getDiscount().applyDiscount(billData.getTotal()));
		printBill(billData);

	}

	private Discount calculateDiscount(double totalBillAmountWithOutDisc) {

		List<Discount> disList = CafeItemLoader.getItems().getDiscountList();
		for (Discount discount : disList) {
			if (discount.isCalculationNeeded(totalBillAmountWithOutDisc)) {
				return discount;

			}
		}
		return new Discount(0);
	}

	public void printBill(BillData billData) {
		System.out.println("\n==============   BILL   ==============");
		System.out.println("Item Name\t\tCount\t\tPrice  (INR)");

		for (Billing billing : billData.getItemRequest()) {
			if (billing.getItemPrice() > 0) {
				System.out.println(billing.getItemName() + "\t\t" + ((billing.getCount() > 0) ? billing.getCount() : "")
						+ "\t\t" + billing.getItemPrice());
			}
		}

		System.out.println("Total\t\t" + "\t\t" + billData.getTotal());
		System.out.println(
				billData.getDiscount().toString() + "\t\t" + billData.getDiscount().applyDiscount(billData.getTotal()));
		System.out.println("Final Amount \t" + "\t\t" + billData.getFinalAmount());
	}

}
