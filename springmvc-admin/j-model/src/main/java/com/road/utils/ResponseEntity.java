package com.road.utils;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回码
	 */
	private Integer code;
	/**
	 * 是否成功 <li> {@link MessageState#SUCCESS} 成功 {@link MessageState#FAILURE} 失败
	 * {@link MessageState#EXCEPTION} 异常</li>
	 */
	private boolean success;
	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回结果集 用户自定义对象
	 */
	private T result;

	public ResponseEntity() {
	}

	public ResponseEntity(MessageState state) {
		this.code = state.index;
		this.success = state.success;
	}

	public ResponseEntity(MessageState state, String msg) {
		this.code = state.index;
		this.success = state.success;
		this.msg = msg;
	}

	public ResponseEntity(boolean success) {
		this(success, null);
	}

	public ResponseEntity(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
		if (success)
			this.code = MessageState.SUCCESS.index;
		else
			this.code = MessageState.FAILURE.index;
	}

	public ResponseEntity(Integer code, boolean success, String msg) {
		this.code = code;
		this.success = success;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", success=" + success
				+ ", msg=" + msg + ", result=" + result + "]";
	}

}