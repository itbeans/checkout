package com.supermkt.test;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.supermkt.dao.PriceRuleDao;
import com.supermkt.dao.PriceRuleDaoImpl;
import com.supermkt.service.SuperMarketImpl;

/**
 * JUnit test case for testing PriceRuleDAO
 * 
 * @author Gautam
 *
 */
public class PriceRuleDaoTest {

	PriceRuleDao priceRuleDao;
	
	@Before
	public void setUp() throws Exception {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		priceRuleDao = container.instance().select(PriceRuleDaoImpl.class).get();
		weld.shutdown();
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
