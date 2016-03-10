package com.road.utils;

/**
 * @Description :
 * @FileName: MessageModel.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月7日 下午5:36:13
 * @Version:V1.00
 */
public class MessageModel {

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public MessageModel() {
		super();
	}

	public MessageModel(boolean success) {
		super();
		this.success = success;
	}

	public MessageModel(String msg, Object obj) {
		super();
		this.msg = msg;
		this.obj = obj;
	}

	public MessageModel(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "MessageModel [success=" + success + ", msg=" + msg + ", obj="
				+ obj + "]";
	}

}
