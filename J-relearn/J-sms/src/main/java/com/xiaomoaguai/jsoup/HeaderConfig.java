package com.xiaomoaguai.jsoup;

/**
 * @Description :
 * @FileName: HeaderConfig.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月1日 下午6:24:20
 * @Version:V1.00
 */
public class HeaderConfig {

	public static final String Header_Accept = "Accept";
	public static final String Header_Accept_Encoding = "Accept-Encoding";
	public static final String Header_Accept_Language = "Accept-Language";
	public static final String Header_Connection = "Connection";
	public static final String Header_Host = "Host";
	public static final String Header_User_Agent = "User-Agent";

	public static final String Header_Accept_value = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	public static final String Header_Accept_Encoding_value = "gzip, deflate";
	public static final String Header_Accept_Language_value = "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3";
	public static final String Header_Connection_value = "keep-alive";
	public static final String Header_User_Agent_value = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0";

	private String accept;
	private String acceptEncoding;
	private String acceptLanguage;
	private String connection;
	private String userAgent;

	public HeaderConfig() {

	}

	public HeaderConfig(String accept, String acceptEncoding, String acceptLanguage, String connection, String userAgent) {
		super();
		this.accept = accept;
		this.acceptEncoding = acceptEncoding;
		this.acceptLanguage = acceptLanguage;
		this.connection = connection;
		this.userAgent = userAgent;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String toString() {
		return "HeaderConfig [accept=" + accept + ", acceptEncoding=" + acceptEncoding + ", acceptLanguage=" + acceptLanguage + ", connection="
				+ connection + ", userAgent=" + userAgent + "]";
	}

}
