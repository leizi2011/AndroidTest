package com.demo.test;

import java.io.File;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException {
		UiDevice.getInstance().pressHome();
		UiObject brower = new UiObject(new UiSelector().text("Browser"));
		brower.clickAndWaitForNewWindow();
		UiObject edit = new UiObject(
				new UiSelector().className("android.webkit.WebView"));
		edit.click();
		UiDevice.getInstance().pressDelete();
		edit.setText("http://sina.cn");
		UiDevice.getInstance().pressEnter();
		sleep(2000);
	}

	public static void main(String[] args) {
		String jarName = "DemoTest";
		String testClass = "com.demo.test.Test";
		String testName = "testWatch";
		String androidId = "11";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testPress() throws RemoteException, UiObjectNotFoundException {
		UiDevice.getInstance().sleep();

		if (!UiDevice.getInstance().isScreenOn()) {
			UiDevice.getInstance().wakeUp();
		}
		sleep(3000);
		UiDevice.getInstance().swipe(159, 325, 300, 325, 100);
		sleep(3000);
		UiDevice.getInstance().pressHome();
		UiObject brower = new UiObject(new UiSelector().text("Browser"));
		brower.clickAndWaitForNewWindow();
		UiObject edit = new UiObject(
				new UiSelector().className("android.webkit.WebView"));
		edit.click();
		UiDevice.getInstance().pressDelete();
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_H);
		UiDevice.getInstance().pressEnter();
		UiDevice.getInstance().takeScreenshot(new File("/data/local/test.png"));
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		System.out.println("kaishile");
		Bundle bun = new Bundle();
		bun.putString("key1", "value1");
		bun.putString("key2", "value2");
		bun.putString("key3", "value3");
		bun.putString("key4", "value4");
		getAutomationSupport().sendStatus(10, bun);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
		System.out.println("kaishile");
		Bundle bun = new Bundle();
		bun.putString("key1", "value1");
		bun.putString("key2", "value2");
		bun.putString("key3", "value3");
		bun.putString("key4", "value4");
		getAutomationSupport().sendStatus(11, bun);
	}

	public void testR() throws UiObjectNotFoundException {
		// 环境初始化
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		UiObject me = new UiObject(new UiSelector().text("Messaging"));
		UiObject msg = new UiObject(new UiSelector().text("No conversations."));
		me.clickAndWaitForNewWindow();
		assertTrue(msg.exists());
		System.out.println("kaishile");
		Bundle bun = new Bundle();
		bun.putString("key1", "value1");
		bun.putString("key2", "value2");
		bun.putString("key3", "value3");
		bun.putString("key4", "value4");
		getAutomationSupport().sendStatus(12, bun);

	}

	public void testCall() throws UiObjectNotFoundException

	{
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		UiObject call = new UiObject(new UiSelector().text("Phone"));
		// UiObject da=new UiObject(new UiSelector().description("dial pad"));
		// UiObject da=new UiObject(new
		// UiSelector().resourceId("com.android.dialer:id/dialpad_button"));
		UiCollection col = new UiCollection(
				new UiSelector().className("android.widget.FrameLayout"));
		UiSelector childPattern = new UiSelector()
				.className("android.widget.ImageButton");
		int instance = 1;
		UiObject da = col.getChildByInstance(childPattern, instance);
		// UiObject da=new UiObject(new
		// UiSelector().className("android.widget.ImageButton"));
		call.clickAndWaitForNewWindow();
		da.clickAndWaitForNewWindow();
		Bundle b = getParams();
		String phone = (String) b.get("phone");
		for (int i = 0; i < phone.length(); i++)

		{
			String c = phone.charAt(i) + "";
			UiObject phnum = new UiObject(new UiSelector().text(c));
			phnum.click();
			sleep(1200);
		}

	}

	public void testAction() throws UiObjectNotFoundException { // 滑动时延获取
		long timeaction = Configurator.getInstance()
				.getActionAcknowledgmentTimeout();
		System.out.println("延迟时间" + timeaction);
		// 滑动时延获取
		long timeakey = Configurator.getInstance().getKeyInjectionDelay();
		System.out.println("延迟时间" + timeakey);

		long timescroll = Configurator.getInstance()
				.getScrollAcknowledgmentTimeout();
		System.out.println("延迟时间" + timescroll);

		long timeid = Configurator.getInstance().getWaitForIdleTimeout();
		System.out.println("延迟时间" + timeid);
		UiScrollable sc = new UiScrollable(
				new UiSelector().className("android.app.ActionBar$Tab"));
		sc.scrollTextIntoView("");
		sc.setAsHorizontalList();
		sc.scrollBackward();
		sleep(3000);
		sc.scrollForward();
		// UiSelector ui=new UiSelector().text("");

	}

	/**
	 * 
	 * 实现多次快速点击，通过Configurator点击时间间隔，按键操作时间
	 * 
	 * 
	 */
	public void quickClick(int num, int x, int y) {
		long actionTime = Configurator.getInstance()
				.getActionAcknowledgmentTimeout();
		Configurator.getInstance().setActionAcknowledgmentTimeout(0);
		for (int i = 0; i < num; i++) {
			UiDevice.getInstance().click(x, y);
		}
		Configurator.getInstance().setActionAcknowledgmentTimeout(actionTime);
	}

	public void testWatch() throws UiObjectNotFoundException {
		
		UiDevice.getInstance().registerWatcher("phone", new UiWatcher() {
			
			@Override
			public boolean checkForCondition() {
				//处理异常信息步骤
				return false;
			}
		});
		UiObject ui = new UiObject(new UiSelector().className(
				"android.widget.LinearLayout").index(4))
				.getChild(new UiSelector().text("Sound"));
		UiObject back = new UiObject(
				new UiSelector().description("Sound, Navigate up"));

		for (int i = 0; i < 20; i++) {
			ui.clickAndWaitForNewWindow();
			sleep(2000);
			back.clickAndWaitForNewWindow();
			sleep(2000);
		}
	}
}
