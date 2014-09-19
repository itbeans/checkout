package com.supermkt.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.supermkt.db.ProductRuleDB;
import com.supermkt.entity.ProductPrice;

/**
 * Data access object to interact with the database layer. This class implements
 * 		findAll() - find all items and its price and any special pricing
 * 		findPriceFor(product) - find pricing rule for a specific product/item
 * 		addProductPrice(product, price, specialPriceQuantity, specialPrice) -
 * 			this method persists new pricing details to database
 *  
 * @author Gautam
 *
 */
@Named("PriceRuleDao")
public class PriceRuleDaoImpl implements PriceRuleDao {
	
	@Inject
	private ProductRuleDB productRuleDB;

	/**
	 * 
	 * @return List - list of all pricing details
	 */
	@Override
	public List<ProductPrice> findAll() {
		return productRuleDB.getProductPriceList();
	}

	/**
	 * @param product - product/item name
	 * 
	 * @return ProductPrice - pricing detail of the supplied item name
	 */
	@Override
	public ProductPrice findPriceFor(String product) {
		return productRuleDB.getProductPrice(product);
	}
	
	/**
	 * @param product item/product name
	 * @param price   item/product price
	 * @param specialPriceQty Quantity at special price applicable - if zero, then not applicable
	 * @param specialPrice Special price overrides the per unit price
	 * 
	 */
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
