package com.supermkt.entity;

/**
 * Entity representing pricing details. In this exercise, it is obtained
 * from the ProductRuleDB singleton instance as if coming out of database.
 * In real implementation, only some annotations or an xml file having 
 * mappings to the actual database table columns are required to be added.
 * 
 * @author Gautam
 *
 */
public class ProductPrice {

	private String product;
	private int price;
	private int specialPriceQty = 0;
	private int specialPrice = 0;
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSpecialPriceQty() {
		return specialPriceQty;
	}
	public void setSpecialPriceQty(int specialPriceQty) {
		this.specialPriceQty = specialPriceQty;
	}
	public int getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(int specialPrice) {
		this.specialPrice = specialPrice;
	}
	
}
