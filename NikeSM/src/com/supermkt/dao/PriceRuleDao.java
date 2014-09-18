package com.supermkt.dao;

import java.util.List;

import com.supermkt.entity.ProductPrice;

public interface PriceRuleDao {

	List<ProductPrice> findAll();
	ProductPrice findPriceFor(String product);
	void addProductPrice(String product, int price, int specialPriceQuantity, int specialPrice);
	
}
