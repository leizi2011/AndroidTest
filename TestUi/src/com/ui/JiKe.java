package com.ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.input.ReaderInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiKe {
	public static void main(String[] args) throws IOException {
		String URL = "http://111.47.240.151/DSP-MONITOR/login.action";
		// 设置打开浏览器驱动类型，获取网站的title
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Navigation navigation = driver.navigate();
		navigation.to(URL);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement passwd = driver.findElement(By.id("passwd"));
		passwd.sendKeys("111111");
		WebElement validCode = driver.findElement(By.id("validCode"));
		// validCode.sendKeys("");
		WebElement img = driver.findElement(By.id("validImg"));

		URL url = new URL(img.getAttribute("src"));
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		OutputStream os = new FileOutputStream("valid.jpg");
		while (in.read() != 0) {
			os.write(in.read());
		}
		os.close();
		in.close();

		System.out.println(img.getAttribute("src"));
		System.out.println(img.toString());
		System.out.println("11111111111");

	}
}
