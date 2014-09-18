package com.supermkt.entity;

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
