package com.syy.demo;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class yingxiang {
	public static void main(String[] args) {
		try {
			yingxiang login = new yingxiang();
			login.login();
			login.loginbyqq();
			login.loginbyWechat();
			login.loginbyWeibo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("rawtypes")
	public  AndroidDriver driver() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "Appium"); // appium做自动化
		// cap.setCapability("app", "D:\\software\\rrmj.apk"); //安装apk
		// cap.setCapability("browserName", "chrome"); //设置HTML5的自动化，打开谷歌浏览器
		cap.setCapability("deviceName", "HuaWei P10"); // 设备名称
		cap.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
		cap.setCapability("platformVersion", "7.0"); // 安卓操作系统版本
		cap.setCapability("udid", "58Y0217C03001231"); // 设备的udid (adb
														// devices查看到的)
		cap.setCapability("appPackage", "com.yingxiang.rrsp.society"); // 被测app的包名 com.yingxiang.rrsp.society
		cap.setCapability("appActivity", "com.zhongduomei.rrmj.society.function.launch.activity.LaunchActivity");// 被测app的入口Activity名称		.function.launch.activity.LaunchActivity
		cap.setCapability("unicodeKeyboard", "True"); // 支持中文输入
		cap.setCapability("resetKeyboard", "True"); // 支持中文输入，必须两条都配置
		cap.setCapability("noSign", "True"); // 不重新签名apk
		cap.setCapability("noReset", "False"); // 启动后结束后不清空应用数据  False/True
		// cap.setCapability("newCommandTimeout", "30"); // 没有新命令，appium30秒退出
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);// 把以上配置传到appium服务端并连接手机
		return driver;
	}

	public void login() throws Exception {
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new yingxiang().driver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 隐式等待
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_account")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/sdv_my")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,2)]")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/start_account_psw_login")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/et_input_phone")).sendKeys("17521684314");
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/et_input_password")).sendKeys("123456");
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/start_login")).click();
		/* 断言：用户名是否为预期的 */
		String text = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).getText();
		assertEquals(text, "无敌四多么寂寞");
		System.out.println("使用账号密码登陆成功,账号为:"+text);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).isDisplayed();
		if (flag) {
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/iv_setting")).click();
			Thread.sleep(1000);
			Actions.swipeUp(driver, 100, 2);
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_user_exit_login")).click();
			driver.findElement(By.id("android:id/button1")).click();
		}
		driver.quit();
	}

	public void loginbyqq() throws Exception {
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new yingxiang().driver();
		// System.out.println(driver.currentActivity());
		// Thread.sleep(10000);
		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//
		 * 隐式等待
		 * driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_account"
		 * )).click();
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_account")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/sdv_my")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,2)]")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_login_SNS_qq")).click();
		Thread.sleep(2000);
		Actions.tap(driver, 0.5, 0.76, 1);
		
		/* 断言：用户名是否为预期的 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).getText();
		assertEquals(text,  "无敌四多么寂寞");
		System.out.println("使用QQ登陆成功,账号为:"+text);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).isDisplayed();
		if (flag) {
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/iv_setting")).click();
			Thread.sleep(1000);
			Actions.swipeUp(driver, 100, 2);
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_user_exit_login")).click();
			driver.findElement(By.id("android:id/button1")).click();
		}
		driver.quit();
	}
	public void loginbyWechat() throws Exception {
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new yingxiang().driver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_account")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/sdv_my")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,2)]")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_login_SNS_weixin")).click();
		/* 断言：用户名是否为预期的 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).getText();
		assertEquals(text, "无敌四多么寂寞");
		System.out.println("使用微信登陆成功,账号为:"+text);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).isDisplayed();
		if (flag) {
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/iv_setting")).click();
			Thread.sleep(1000);
			Actions.swipeUp(driver, 100, 2);
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_user_exit_login")).click();
			driver.findElement(By.id("android:id/button1")).click();
		}
		driver.quit();
	}
	
	public void loginbyWeibo() throws Exception{
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new yingxiang().driver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_account")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/sdv_my")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,2)]")).click();
		driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_login_SNS_weibo")).click();
		/* 断言：用户名是否为预期的 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).getText();
		assertEquals(text, "无敌四多么寂寞");
		System.out.println("使用微博登陆成功,账号为:"+text);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.id("com.yingxiang.rrsp.society:id/tv_nickname")).isDisplayed();
		if (flag) {
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/iv_setting")).click();
			Thread.sleep(1000);
			Actions.swipeUp(driver, 100, 2);
			driver.findElement(By.id("com.yingxiang.rrsp.society:id/btn_user_exit_login")).click();
			driver.findElement(By.id("android:id/button1")).click();
		}
		driver.quit();
	}
}