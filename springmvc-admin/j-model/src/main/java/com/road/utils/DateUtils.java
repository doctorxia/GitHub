package com.road.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description :
 * @FileName: DateUtils.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月9日 下午3:36:31
 * @Version:V1.00
 */
public enum DateUtils {

	DATETIME("yyyy-MM-dd HH:mm:ss") {

		@Override
		public  String format(Date date) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			simpleDateFormat.applyPattern(DATETIME.pattern);
			return simpleDateFormat.format(date);
		}
	};

	public String pattern;

	private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>();

	static {
		dateFormat.set(new SimpleDateFormat());
	}

	private DateUtils(String pattern) {
		this.pattern = pattern;
	}

	public  String format(Date date) {
		throw new AbstractMethodError();
	}

}
