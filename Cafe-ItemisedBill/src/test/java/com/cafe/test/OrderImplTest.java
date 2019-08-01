package com.cafe.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cafe.billing.BillingService;
import com.cafe.entity.BillData;
import com.cafe.entity.Billing;
import com.cafe.entity.Discount;
import com.cafe.item.CafeItemLoader;
import com.cafe.order.OrderImpl;

public class OrderImplTest {
	
	@Test  
    public void testcalculateforDiscount10(){
		OrderImpl oImpl = new OrderImpl();

		oImpl.placeOrder("CL", 1);
		oImpl.placeOrder("TI", 3);
		oImpl.placeOrder("CDP", 2);

		BillingService billingService = new BillingService();
		List<Billing> billingList = billingService.displayBill(oImpl.getOrderList());
		BillData billData = new BillData();
		billData.setItemRequest(billingList);
		billData.setTotal(billingService.getTotalBillAmountWithOutDisc());
		billData.setDiscount(calculateDiscount(billingService.getTotalBillAmountWithOutDisc()));
		billData.setFinalAmount(billData.getTotal() - billData.getDiscount().applyDiscount(billData.getTotal()));
		BillData expecBillData = getExpectedBillDataFor10();
		
		
		assertEquals(expecBillData,billData);
		
    }
	
	@Test
	public void testcalculateForDiscount20(){
		OrderImpl oImpl = new OrderImpl();

		oImpl.placeOrder("CM", 3);
		oImpl.placeOrder("TL", 3);
		oImpl.placeOrder("CDC", 3);

		BillingService billingService = new BillingService();
		List<Billing> billingList = billingService.displayBill(oImpl.getOrderList());
		BillData billData = new BillData();
		billData.setItemRequest(billingList);
		billData.setTotal(billingService.getTotalBillAmountWithOutDisc());
		billData.setDiscount(calculateDiscount(billingService.getTotalBillAmountWithOutDisc()));
		billData.setFinalAmount(billData.getTotal() - billData.getDiscount().applyDiscount(billData.getTotal()));
		BillData expecBillData = getExpectedBillDataFor20();
		
		
		assertEquals(expecBillData,billData);
		
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
	
	private BillData getExpectedBillDataFor10() {
		
		BillData billData = new BillData();
		List<Billing> billingList = new ArrayList<Billing>();
		billingList.add(new Billing("Coffee - Latte", 30, 1));
		billingList.add(new Billing("Tea - Iced", 45, 3));
		billingList.add(new Billing("Cold Drinks - Pepsi", 40, 2));
		
		billData.setItemRequest(billingList);
		billData.setTotal(115);
		billData.setDiscount(new Discount(10));
		billData.setFinalAmount(103.5);
		
		return billData;
	}

private BillData getExpectedBillDataFor20() {
		
		BillData billData = new BillData();
		List<Billing> billingList = new ArrayList<Billing>();
		billingList.add(new Billing("Coffee - Mocha", 120, 3));
		billingList.add(new Billing("Tea - Lemon", 45, 3));
		billingList.add(new Billing("Cold Drinks - Coke", 60, 3));
		
		billData.setItemRequest(billingList);
		billData.setTotal(225);
		billData.setDiscount(new Discount(20));
		billData.setFinalAmount(180);
		
		return billData;
	}
	@Before
	public void initilize() {
		CafeItemLoader.load();
	}
}
