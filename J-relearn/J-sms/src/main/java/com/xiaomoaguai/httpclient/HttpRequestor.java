package com.xiaomoaguai.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description :
 * @FileName: AbstractHttpClient.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月1日 下午8:35:33
 * @Version:V1.00
 */
public class HttpRequestor {

	protected static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestor.class);

	public static String doGet(HttpClient httpClient, String requestUrl) {
		String result = null;
		HttpGet get = new HttpGet(requestUrl);
		config(get);
		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String doPost(HttpClient httpClient, String requestUrl, Map<String, String> param) {
		String result = null;
		HttpPost post = new HttpPost(requestUrl);
		List<BasicNameValuePair> formparams = new ArrayList<>();

		Set<String> keySet = param.keySet();
		for (String key : keySet) {
			formparams.add(new BasicNameValuePair(key, param.get(key)));
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void config(HttpRequestBase httpRequestBase) {
		httpRequestBase.setHeader("User-Agent", "Mozilla/5.0");
		httpRequestBase.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequestBase.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");// "en-US,en;q=0.5");
		httpRequestBase.setHeader("Accept-Charset", "ISO-8859-1,utf-8,gbk,gb2312;q=0.7,*;q=0.7");

		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(3000).setConnectTimeout(3000).setSocketTimeout(3000).build();
		httpRequestBase.setConfig(requestConfig);
	}
}
