package com.example.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses(AddTest.class)
public class AddTest extends TestCase {

	private Add ad;

	@Before
	protected void setUp() throws Exception {
		ad = new Add();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	private int a = 2;
	private int b = 1;
	private int cexpend = 3;
	private int dresult;

	
	
	@Test
	public void testadd() {

		dresult = ad.add(a, b);
		Assert.assertEquals(dresult, cexpend);

	}

}
