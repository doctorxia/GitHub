package com.road.model.config;

/**
 * @Description :错误码，服务端定义
 * @FileName: ErrorCode.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月9日 下午3:46:17
 * @Version:V1.00
 */
public enum ErrorCode {

	ERROR_SYSTEM(100, "系统错误"),

	ERROR_PARAM(101, "参数不合法");

	public int code;

	public String desc;

	private ErrorCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
