package com.supermkt.service;

import java.util.HashMap;
import java.util.Map;

import com.supermkt.dao.PriceRuleDao;
import com.supermkt.dao.PriceRuleDaoImpl;
import com.supermkt.entity.ProductPrice;
import com.supermkt.exception.ProductUndefinedException;

/**
 * This class implements checkout service. It implements following two public methods:
 * 		checkout: for taking order as item string and returning total order value
 * 		addPriceRule: for adding new product and its price with or without special pricing offer
 * The class also contains two private methods,
 * 		getItemCount: to get counts for each unique item in the items string
 * 		getAmountForItem: to obtain total amount receivable applying pricing rules
 * @author Gautam
 *
 */
public class SuperMarketImpl implements SuperMarket {

	PriceRuleDao priceRuleDao = new PriceRuleDaoImpl();
	
	/**
	 * 
	 * @param items a String having items ordered - e.g. ABBACBABBAB
	 * @throws ProductUndefinedException Exception thrown when database
	 * 				does not contain specified product/item
	 */
	@Override
	public int checkout(String items) {

		// Create a map of all items with the number of that item
		Map<String, Integer> itemsCount = getItemsCount(items);
		
		// Compute total value
		int orderTotal = 0;
		for (String name : itemsCount.keySet()) {
			int orderQuantity = itemsCount.get(name);
			orderTotal = orderTotal + getAmountForItem(name, orderQuantity);
		}
		return orderTotal;
	}

	private Map<String, Integer> getItemsCount(String items) {

		Map<String, Integer> itemCount = new HashMap<String, Integer>();
		
		// validate if the items string is not null
		if (items == null) {
			throw new IllegalArgumentException();
		}
		
		if ("".equals(items)) {
			return itemCount;
		}
		
		String[] itemArray = items.split("(?!^)");
		
		for (String item : itemArray) {
			if (itemCount.containsKey(item)) {
				int count = itemCount.get(item);
				count++;
				itemCount.put(item, count);
			} else {
				itemCount.put(item, 1);
			}
		}
		return itemCount;
	}
	
	private int getAmountForItem(String name, int orderQuantity) {
		int itemTotal = 0;
		ProductPrice productPrice = priceRuleDao.findPriceFor(name);
		if (productPrice == null) {
			throw new ProductUndefinedException();
		}
		if (productPrice.getSpecialPriceQty() > 0) {
			int amountAtSpecialPrice = (orderQuantity / productPrice.getSpecialPriceQty()) * productPrice.getSpecialPrice();
			int amountAtRegularPrice = (orderQuantity % productPrice.getSpecialPriceQty()) * productPrice.getPrice();
			itemTotal = amountAtSpecialPrice + amountAtRegularPrice;
		} else {
			itemTotal = orderQuantity * productPrice.getPrice();
		}
		return itemTotal;
	}

	/**
	 * @param product item/product name
	 * @param price   item/product price
	 * @param specialPriceQuantity Quantity at special price applicable - if zero, then not applicable
	 * @param specialPrice Special price overrides the per unit price
	 * 
	 */
	@Override
	public void addPriceRule(String product, int price,
								int specialPriceQuantity, int specialPrice) {
		priceRuleDao.addProductPrice(product, price, specialPriceQuantity, specialPrice);
		
	}

}
