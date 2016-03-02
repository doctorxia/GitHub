package com.xiaomaoguai.player;

import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @FileName: sample.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年2月29日 下午9:47:01
 * @Version:V1.00
 */
public class Sample {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			TimeUnit.SECONDS.sleep(1);
			PlayerCharge.infoLog();
			PlayerUpgrades.infoLog();
		}
	}
}
