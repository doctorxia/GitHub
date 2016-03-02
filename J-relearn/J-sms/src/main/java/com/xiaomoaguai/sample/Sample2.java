package com.xiaomoaguai.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @Description :
 * @FileName: Smaple.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月1日 下午5:21:21
 * @Version:V1.00
 */
public class Sample2 {

	private static final long delay = 0;
	private static final long period = 1000 * 60 * 2;
	protected static final String phone = "13129975361";

	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					doRequest(phone);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, delay, period);

	}

	private static void doRequest(String phone) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String request = "http://www.5idhl.com//easypay/getMobileCode.action?time=" + System.currentTimeMillis();
		HttpPost post = new HttpPost(request);
		List<BasicNameValuePair> formparams = new ArrayList<>();
		formparams.add(new BasicNameValuePair("mm", phone));
		post.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
		CloseableHttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		System.out.println(content);
	}
}
