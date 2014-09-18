package com.supermkt.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.supermkt.dao.PriceRuleDao;
import com.supermkt.dao.PriceRuleDaoImpl;

public class PriceRuleDaoTest {

	PriceRuleDao priceRuleDao;
	
	@Before
	public void setUp() throws Exception {
		priceRuleDao = new PriceRuleDaoImpl();
	}

	@Test
	public final void testFindAll() {
		Assert.assertNotNull(priceRuleDao.findAll());
		Assert.assertEquals(3, priceRuleDao.findAll().size());
	}

	@Test
	public final void testFindPriceFor() {
		Assert.assertEquals(20, priceRuleDao.findPriceFor("A").getPrice());
		Assert.assertEquals(50, priceRuleDao.findPriceFor("B").getPrice());
		Assert.assertEquals(30, priceRuleDao.findPriceFor("C").getPrice());
	}

}
