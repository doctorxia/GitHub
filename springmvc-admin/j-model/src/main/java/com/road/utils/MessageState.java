package com.road.utils;

/**
 * @Description :
 * @FileName: MessageState.java
 * @Author :WeiHui.Zhang
 * @Data : 2015年9月23日 下午2:05:03
 * @Version:V1.00
 */
public enum MessageState {

	FAILURE(0, false), SUCCESS(1, true), EXCEPTION(2, false);
	public final int index;
	public final boolean success;

	MessageState(int index, boolean success) {
		this.index = index;
		this.success = success;
	}
}
