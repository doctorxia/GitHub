package com.road.httpclient;

import org.junit.Test;

import com.road.httpclient.utils.AbstractClient;
import com.road.model.po.UserLoginPo;

/**
 * @Description :
 * @FileName: AppTest.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月10日 下午3:18:37
 * @Version:V1.00
 */
public class AppTest extends AbstractClient {

	@Test
	public void testLogin() throws Exception {
		doPost("/user/login", new UserLoginPo("admin", "123456"));
	}

}
