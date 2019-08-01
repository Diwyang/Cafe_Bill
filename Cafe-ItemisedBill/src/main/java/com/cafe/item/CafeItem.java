package com.cafe.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cafe.Beverage.BeverageFactory;
import com.cafe.entity.Beverages;
import com.cafe.entity.Discount;

public class CafeItem {

	private final Map<String,Beverages> beveragesMap = new HashMap<>();

    private final List<Discount> discountList = new ArrayList<>();

    public void addItem(String type, String code, String description, double price){
        beveragesMap.put(code, BeverageFactory.getBeverage(type, code, description, price));
    }

    public void removeItem(String code){
        beveragesMap.remove(code);
    }

    public Beverages getItem(String code){
        return beveragesMap.get(code);
    }

    public void addDiscount(Discount discount){
        discountList.add(discount);
    }

    public List<Discount> getDiscountList(){
        return discountList;
    }
    
    
}
