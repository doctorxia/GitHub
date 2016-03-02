package com.xiaomoaguai.execution;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description :
 * @FileName: SmsTask.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月1日 下午6:17:06
 * @Version:V1.00
 */
public abstract class SmsTimerTask extends TimerTask {

	protected static final Logger LOGGER = LoggerFactory.getLogger(SmsTimerTask.class);

	private Long createTime;

	SmsTimerTask() {
		this.createTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		exe();
		if (System.currentTimeMillis() - createTime > 1000) {
			LOGGER.warn("Runing task use too much time!");
		}
	}

	protected abstract void exe();

}
