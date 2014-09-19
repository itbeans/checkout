package com.supermkt.service;

/**
 * Defines interface of service implementing checkout method and addPriceRule
 * @author Gautam
 *
 */
public interface SuperMarket {

	int checkout(String items);
	
	void addPriceRule(String product, int price, int specialPriceQuantity, int specialPrice);
	
}
