package com.supermkt.db;

import java.util.ArrayList;
import java.util.List;

import com.supermkt.entity.ProductPrice;

/**
 * This class is in in memory simulation of database storing pricing details
 * 
 * @author Gautam
 *
 */
public class ProductRuleDB {
	
	private static ProductRuleDB productRuleDB = null;
	
	private List<ProductPrice> productPriceList;
	
	protected ProductRuleDB(){
		initialize();
	}
	
	public static ProductRuleDB getInstance() {
		if (productRuleDB == null) {
			productRuleDB = new ProductRuleDB();
		}
		return productRuleDB;
	}
	
	public List<ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(List<ProductPrice> productPriceList) {
		this.productPriceList = productPriceList;
	}
	
	public ProductPrice getProductPrice(String product) {
		
		for(ProductPrice productPrice : productPriceList) {
			if (productPrice.getProduct().equals(product)) {
				return productPrice;
			}
		}
		return null;
	}
	
	public void addProductPrice(ProductPrice productPrice) {
		productPriceList.add(productPrice);
	}

	final void initialize(){
		productPriceList = new ArrayList<ProductPrice>();
		
		ProductPrice product = new ProductPrice();
		product.setProduct("A");
		product.setPrice(20);
		productPriceList.add(product);
		
		product = new ProductPrice();
		product.setProduct("B");
		product.setPrice(50);
		product.setSpecialPriceQty(5);
		product.setSpecialPrice(150);
		productPriceList.add(product);
		
		product = new ProductPrice();
		product.setProduct("C");
		product.setPrice(30);
		productPriceList.add(product);
	}
	
	
}
