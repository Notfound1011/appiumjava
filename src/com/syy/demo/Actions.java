package com.syy.demo;

import io.appium.java_client.android.AndroidDriver;

public class Actions {

	public static void goSleep(int i) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 上滑
	 *
	 * @param driver
	 * @param a  横坐标百分比
	 * @param b  纵坐标百分比
	 * @param num  点击次数
	 */
	public static void tap(AndroidDriver<?> driver,double a, double b, int num) {
//		float x = driver.manage().window().getSize().width ;
//		float y = driver.manage().window().getSize().height ;
		float[] f = getresolution(driver);
//		int x1 = (int) (x*a);
//		int y1 = (int) (y*b);
		int x1 = (int) (f[0]*a);
		int y1 = (int) (f[1]*b);
		for (int i = 0; i < num; i++) {
			driver.tap(1, x1, y1, 100);
			goSleep(300);
		}
	}

	public static float[] getresolution(AndroidDriver<?> driver){
		float x = driver.manage().window().getSize().width ;
		float y = driver.manage().window().getSize().height ;
		float[] f = {x,y};
		return f;
	}

	/**
	 * 上滑
	 *
	 * @param driver
	 * @param during
	 * @param num   滑动次数
	 */
	public static void swipeUp(AndroidDriver<?> driver, int during, int num) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++) {
			driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
			goSleep(300);
		}
	}

	/**
	 * 下拉
	 *
	 * @param driver
	 * @param during
	 * @param num  滑动次数
	 */
	public static void swipeDown(AndroidDriver<?> driver, int during, int num) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
		for (int i = 0; i < num; i++) {
			driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
			goSleep(300);
		}
	}

	/**
	 * 向左滑动
	 *
	 * @param driver
	 * @param during
	 * @param num	滑动次数
	 */
	public static void swipeLeft(AndroidDriver<?> driver, int during, int num) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++) {
			driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
			goSleep(300);
		}
	}

	/**
	 * 向右滑动
	 *
	 * @param driver
	 * @param during
	 * @param num	滑动次数
	 */
	public static void swipeRight(AndroidDriver<?> driver, int during, int num) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++) {
			driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
			goSleep(300);
		}
	}

}