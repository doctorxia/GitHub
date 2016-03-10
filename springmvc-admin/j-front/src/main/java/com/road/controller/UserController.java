package com.road.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.road.exception.AppException;
import com.road.model.config.ErrorCode;
import com.road.model.entity.User;
import com.road.model.po.UserLoginPo;
import com.road.service.UserService;
import com.road.utils.ResponseEntity;

/**
 * @Description :
 * @FileName: UserController.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月8日 下午5:20:30
 * @Version:V1.00
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody UserLoginPo userLoginPo)
			throws Exception {
		ResponseEntity<User> response = new ResponseEntity<User>(false);
		System.out.println(userLoginPo);
		if (StringUtils.isBlank(userLoginPo.getLoginName())) {
			throw new AppException(ErrorCode.ERROR_PARAM);
		}
		if (StringUtils.isBlank(userLoginPo.getPassword())) {
			throw new AppException(ErrorCode.ERROR_PARAM);
		}
		User user = userService.findUserByLoginName(userLoginPo.getLoginName());
		if (user == null) {
			response.setMsg("用户不存在");
		} else {
			if (!userLoginPo.getPassword().equals("123456")) {
				response.setMsg("密码错误");
			} else {
				response.setSuccess(true);
				response.setResult(user);
			}
		}
		return response;
	}

}
