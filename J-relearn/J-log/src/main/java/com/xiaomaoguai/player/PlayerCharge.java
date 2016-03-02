package com.xiaomaoguai.player;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description :
 * @FileName: PlayerUpgrades.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年2月29日 下午9:12:35
 * @Version:V1.00
*/
public class PlayerCharge {


	private final static Logger LOG = LoggerFactory.getLogger(PlayerCharge.class);

	public static void infoLog() {
		LOG.info("玩家充值");
	}

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			TimeUnit.SECONDS.sleep(1);
			infoLog();
		}
	}
}
