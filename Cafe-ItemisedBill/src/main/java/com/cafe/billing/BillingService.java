package com.cafe.billing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cafe.entity.Beverages;
import com.cafe.entity.Billing;
import com.cafe.entity.Order;
import com.cafe.item.CafeItemLoader;

public class BillingService {

	List<Billing> billList = new ArrayList<Billing>();
	double totalBillAmountWithOutDisc;
	
	
	public List<Billing> getBillList() {
		return billList;
	}



	public void setBillList(List<Billing> billList) {
		this.billList = billList;
	}


	public double getTotalBillAmountWithOutDisc() {
		return totalBillAmountWithOutDisc;
	}



	public void setTotalBillAmountWithOutDisc(double totalBillAmountWithOutDisc) {
		this.totalBillAmountWithOutDisc = totalBillAmountWithOutDisc;
	}



	public List<Billing> displayBill(List<Order> orderList) {
		calculateBill(orderList);
		return getBillList();
		
	}

	private void calculateBill(List<Order> orderList) {
		if (orderList.size() > 0) {
			Iterator<Order> itr = orderList.iterator();
			Order order = null;
			Beverages beverage = null;
			while (itr.hasNext()) {
				order = itr.next();
				beverage = CafeItemLoader.getItems().getItem(order.getId());
				getBillList().add(new Billing(beverage.toString(),
						getTotalItemAmount(beverage.getPrice(),
								order.getQuantity()),
						order.getQuantity()));
			}

		}
		
	}



	private double getTotalItemAmount(double price, int quantity) {
		setTotalBillAmountWithOutDisc(getTotalBillAmountWithOutDisc() + (quantity * price));
		return quantity * price;
	}
	
	
}
