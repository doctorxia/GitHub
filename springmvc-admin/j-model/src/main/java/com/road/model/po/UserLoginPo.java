package com.road.model.po;

/**
 * @Description :用户登录实体
 * @FileName: UserLoginPo.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月8日 下午5:25:21
 * @Version:V1.00
 */
public class UserLoginPo {

	private String loginName; // 邮箱、手机号、用户名
	private String password; // 客户端加密密码

	public UserLoginPo() {
		super();
	}

	public UserLoginPo(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginPo [loginName=" + loginName + ", password=" + password
				+ "]";
	}

}
