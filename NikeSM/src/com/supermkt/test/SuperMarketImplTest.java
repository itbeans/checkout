package com.supermkt.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.supermkt.db.ProductRuleDB;
import com.supermkt.exception.ProductUndefinedException;
import com.supermkt.service.SuperMarket;
import com.supermkt.service.SuperMarketImpl;

/**
 * JUnit test case for testing checkout and addProductRule methods of
 * SuperMarket service implementation.
 * 
 * @author Gautam
 *
 */
public class SuperMarketImplTest {
	
	ProductRuleDB productRuleDB;
	SuperMarket sm;
	
	@Before
	public void setUp() {
		productRuleDB = ProductRuleDB.getInstance();
		sm = new SuperMarketImpl();
	}

	@Test
	public final void testCheckoutNoSpecicalRule() {
		Assert.assertEquals(310, sm.checkout("AABBABCAB"));
		
	}
	
	@Test
	public final void testCheckoutWithSpecicalRule() {
		Assert.assertEquals(240, sm.checkout("ABBACBBAB"));	
	}
	
	@Test(expected=ProductUndefinedException.class)
	public final void testCheckoutProductUndefined() {
		sm.checkout("ABBACBBABX");
	}
	
	@Test
	public final void testAddProductRule() {
		sm.addPriceRule("D", 25, 0, 0);
		Assert.assertEquals(265, sm.checkout("ABBACBBABD"));
		sm.addPriceRule("E", 35, 2, 35);
		Assert.assertEquals(335, sm.checkout("EABBACBEBABDE"));
		Assert.assertEquals(335, sm.checkout("EABBACBEBABDEE"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testCheckoutWithNullItems() {
		sm.checkout(null);
	}

	@Test
	public final void testCheckoutWithNoItems() {
		Assert.assertEquals(0, sm.checkout(""));
	}

}
