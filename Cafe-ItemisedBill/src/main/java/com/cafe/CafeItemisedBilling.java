package com.cafe;

import com.cafe.item.CafeItemLoader;
import com.cafe.order.OrderImpl;

public class CafeItemisedBilling {

	public static void main(String[] args) {

		CafeItemLoader.load();

		OrderImpl oImpl = new OrderImpl();

		oImpl.placeOrder("CL", 1);
		oImpl.placeOrder("TI", 3);
		oImpl.placeOrder("CDP", 2);

/*		oImpl.placeOrder("CM", 3);
		oImpl.placeOrder("TL", 3);
		oImpl.placeOrder("CDC", 3);
*/
		oImpl.generateBill();
		
	}

}
