package com.example.tests;

import java.sql.Time;

import junit.framework.Assert;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class A {

	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		// System.setProperty("webdriver.firefox.driver",
		// "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		selenium = new DefaultSelenium("localhost", 4444,
				"*firefox D:/Program Files (x86)/Mozilla Firefox/firefox.exe",
				"https://www.baidu.com/");
		
		selenium.start();
	}

	@Test
	public void testTest() throws Exception {
		
		
		
		//String keyWordsLocator = "document.getElementById('kw')";     
	   // String search = "document.getElementById('su')";
		// 鐧惧害缃戝潃
		//selenium.open("/");
		
		selenium.open("https://www.baidu.com/");
		//selenium.click("id=kw");
		//测试登录自动化，涉及用到CSS获取元素,进程需要sleep一段时间，因页面弹出框没有这么快
		selenium.click("css=#u1 > a[name=\"tj_login\"]");
		
		Thread.sleep(20000);
		
		System.out.println("复选框的状态"+selenium.getValue("id=TANGRAM__PSP_8__memberPass"));
		
		//selenium.waitForFrameToLoad("css=#u1", "a.name");;
		selenium.click("id=TANGRAM__PSP_8__userName");
		//selenium.click("xpath=//input[@name='username']");
		selenium.type("id=TANGRAM__PSP_8__userName", "娃哈waha娃哈");
		selenium.click("id=TANGRAM__PSP_8__password");
		selenium.type("id=TANGRAM__PSP_8__password", "peng2011");
		
		selenium.click("id=TANGRAM__PSP_8__memberPassWrapper");
		
		System.out.println("复选框的状态"+selenium.getValue("id=TANGRAM__PSP_8__memberPass"));
		
		selenium.click("id=TANGRAM__PSP_8__submit");
	//	selenium.click(keyWordsLocator);
		Thread.sleep(50000);	
		selenium.click("id=kw");
		selenium.type("id=kw", "test");
		System.out.println(selenium.getValue("xpath=//input[@name='wd']"));
			
		selenium.click("id=su");
		//selenium.click(search);
		//selenium.waitForPageToLoad("50000");
		
		System.out.println("获取浏览器的标题"+selenium.getTitle());
		
		Thread.sleep(5000);	
		System.out.println("获取浏览器的标题"+selenium.getTitle());
		
	    //判断页面跳转是不是想要的页面
	    Assert.assertEquals(selenium.getTitle(), "test_百度搜索");
		//Assert.IsTrue(selenium.getTitle().contains("Google"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
