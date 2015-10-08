package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test {
	public static void main(String[] args) throws Exception {
		String URL ="http://www.baidu.com";
		// 设置打开浏览器驱动类型，获取网站的title
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		//System.setProperty("webdriver.firefox.driver",
			//	"D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		Navigation navigation = driver.navigate();
		navigation.to(URL);
		WebElement baiduLogin = driver.findElement(By.linkText("登录"));	
		baiduLogin.click();
		//WebElement baiduLogin1 = driver.findElement(By.name("tj_trtieba"));
		//baiduLogin1.click();
				
		Thread.sleep(10000);
		WebElement rememberuser = driver.findElement(By.id("TANGRAM__PSP_8__userName"));
		rememberuser.sendKeys("娃哈waha娃哈");
		WebElement rememberpa = driver.findElement(By.id("TANGRAM__PSP_8__password"));
		rememberpa.sendKeys("peng2011");
		//复选框是否选择判断
		WebElement rememberme = driver.findElement(By.id("TANGRAM__PSP_8__memberPass"));
		if(rememberme.isSelected())
		{
			System.out.println(rememberme.isSelected()+"复选框被选中");
		}
		else
		{
			System.out.println(rememberme.isSelected()+"复选框未被选中");
			rememberme.click();
		}
		
		WebElement rememberlogin = driver.findElement(By.id("TANGRAM__PSP_8__submit"));
		rememberlogin.click();
		System.out.print("ssddsd" + driver.getTitle()+"登录成功");
		Thread.sleep(20000);
		WebElement search = driver.findElement(By.id("kw"));
		search.clear();
		search.sendKeys("你好");
		WebElement su = driver.findElement(By.id("su"));
		su.click();
		
		//WebElement search1 = driver.findElement(By.cssSelector("#s_ipt"));
		//search1.sendKeys("你好");
	}
	
	
	
}

