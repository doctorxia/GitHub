package com.road.exception;

import com.road.model.config.ErrorCode;

/**
 * @Description :
 * @FileName: AppException.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月9日 下午3:49:46
 * @Version:V1.00
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;

	/**
	 * 默认全局异常
	 * @param msg
	 */
	public AppException(String msg) {
		super(msg);
		this.errorCode = ErrorCode.ERROR_SYSTEM.code;
	}

	/**
	 * 不同业务异常
	 * @param errorcode
	 */
	public AppException(ErrorCode errorcode) {
		super(errorcode.desc);
		this.errorCode = errorcode.code;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
