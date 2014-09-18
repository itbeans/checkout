package com.supermkt.dao;

import java.util.List;

import com.supermkt.db.ProductRuleDB;
import com.supermkt.entity.ProductPrice;

public class PriceRuleDaoImpl implements PriceRuleDao {
	
	private ProductRuleDB productRuleDB = ProductRuleDB.getInstance();

	@Override
	public List<ProductPrice> findAll() {
		return productRuleDB.getProductPriceList();
	}

	@Override
	public ProductPrice findPriceFor(String product) {
		return productRuleDB.getProductPrice(product);
	}
	
	@Override
	public void addProductPrice(String product, int price, int specialPriceQty, int specialPrice) {
		ProductPrice productPrice = new ProductPrice();
		productPrice.setProduct(product);
		productPrice.setPrice(price);
		productPrice.setSpecialPriceQty(specialPriceQty);
		productPrice.setSpecialPrice(specialPrice);
		productRuleDB.addProductPrice(productPrice);
	}

}
