package com.xiaomoaguai.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description :
 * @FileName: JsoupRequest.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月1日 下午5:50:19
 * @Version:V1.00
 */
public final class JsoupRequest {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsoupRequest.class);

	public static Document request(String requestUrl, boolean settingHeader) {
		Document document = null;
		Connection conn = Jsoup.connect(requestUrl);// 获取请求连接
		if (settingHeader) {
			configHeader(conn, requestUrl);
		}
		try {
			document = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.warn("conn.get() failed, please apply  config");
		}
		return document;
	}

	private static void configHeader(Connection conn, String requestUrl) {
		conn.header(HeaderConfig.Header_Accept, HeaderConfig.Header_Accept_value);
		conn.header(HeaderConfig.Header_Accept_Encoding, HeaderConfig.Header_Accept_Encoding_value);
		conn.header(HeaderConfig.Header_Accept_Language, HeaderConfig.Header_Accept_Language_value);
		conn.header(HeaderConfig.Header_Connection, HeaderConfig.Header_Connection_value);
		conn.header(HeaderConfig.Header_Host, requestUrl);
		conn.header(HeaderConfig.Header_User_Agent, HeaderConfig.Header_User_Agent_value);
	}

}
