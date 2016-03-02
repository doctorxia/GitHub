package com.xiaomoaguai.sample;

import org.aeonbits.owner.Config;

/**
 * @Description :
 * @FileName: AppConfig.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年2月17日 下午7:29:01
 * @Version:V1.00
 */
@Config.Sources("classpath:config.properties")
public interface AppConfig extends Config {

	@Key("smsUrl")
	@DefaultValue("")
	String smsUrl();

	@Key("sendInterval")
	@DefaultValue("30000")
	int sendInterval();

	@Key("phone")
	@DefaultValue("")
	String getPackageName();
}
