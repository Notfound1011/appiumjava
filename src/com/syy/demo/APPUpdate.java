package com.syy.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class APPUpdate {
	public static void main(String[] args) {
		String classname = "", filename = "";   //创建参数
		File directory = new File("");			//实例化directory对象
		String abPath = directory.getAbsolutePath();   //给abPath赋值，
		System.out.println(abPath);

		File file = new File(abPath + "/apk");
		// File file = new File("/Users/dahaohaozai/Desktop" + "/apk");
		File[] file2 = file.listFiles();	//将文件存入列表
		for (int i = 0; i < file2.length; i++) {
			File apk = file2[i];
			String path = apk.getAbsolutePath();
			filename = path;
			classname = "com.zhongduomei.rrmj.society";
			// new APPUpdate(classname, filename, false);
			new APPUpdate(classname, filename, false);
			// app.execCmd("cmd /c adb shell uiautomator runtest uiautomator.jar -c testpackage.NO1Test");
			// execCmd("cmd /c adb shell uiautomator runtest uiautomator.jar -c testpackage.NO1Test");

		}
	}

	// 通过key控制卸载安装还是直接安装
	public APPUpdate(String classname, String filename, boolean key) {
		if (key) {
			// uninstall(classname);
			install(filename);
		} else {
			uninstall(classname);
			install(filename);
		}

	}

	// 安装
	@SuppressWarnings("static-access")
	public void install(String filename) {
		execCmd("cmd /c adb install " + filename);

		System.out.println("安装成功！");
		try {
			Thread thread = Thread.currentThread();
			thread.sleep(14000);// 暂停14秒后程序继续执行
			rrsp exectest = new rrsp();
			try {
				exectest.login();
				exectest.loginbyqq();
				exectest.loginbyWechat();
				exectest.loginbyWeibo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// execCmd("cmd /c adb shell uiautomator runtest uiautomator.jar -c testpackage.NO1Test");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 卸载
	public void uninstall(String classname) {
		execCmd("cmd /c adb uninstall " + classname);
		System.out.println("卸载成功！");
	}

	public void execCmd(String cmd) {
		System.out.println("----execCmd:  " + cmd);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			// 正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				// 因为安装过程中，会不断输出发送百分比，这里就只输出“Success”
				if (line.equalsIgnoreCase("Success")) {
					System.out.println(line);
				}
				// 虽然上一步屏蔽了一些信息，但还是会写入log文件中
				saveToFile(line, "runlog.log", false);
			}
			// 错误输出流，这里就不屏蔽任何错误信息了
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(
					new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
				saveToFile(eline, "runlog.log", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*  */ 

	public void saveToFile(String text, String path, boolean isClose) {
		File file = new File("runlog.log");
		BufferedWriter bf = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
			bf = new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();

			if (isClose) {
				bf.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
