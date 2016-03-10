package com.road.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.road.utils.MessageModel;

@Controller
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/index";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "/index";
    }

    /**
     * GET 登录
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        LOGGER.info("GET请求登录");
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "/login";
    }

    /**
     * POST 登录 shiro 写法
     *
     * @param username 用户名
     * @param password 密码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageModel loginPost(String username, String password, HttpServletRequest request, Model model) {
        LOGGER.info("POST请求登录");
        MessageModel messageModel = new MessageModel(false);
        if (StringUtils.isBlank(username)) {
        	messageModel.setMsg("用户名不能为空");
            return messageModel;
        }
        if (StringUtils.isBlank(password)) {
        	messageModel.setMsg("密码不能为空");
            return messageModel;
        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
        token.setRememberMe(true);
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            LOGGER.error("账号不存在：{}", e);
            messageModel.setMsg("账号不存在");
            return messageModel;
        } catch (DisabledAccountException e) {
            LOGGER.error("账号未启用：{}", e);
            messageModel.setMsg("账号未启用");
            return messageModel;
        } catch (IncorrectCredentialsException e) {
            LOGGER.error("密码错误：{}", e);
            messageModel.setMsg("密码错误");
            return messageModel;
        } catch (RuntimeException e) {
            LOGGER.error("未知错误,请联系管理员：{}", e);
            messageModel.setMsg("未知错误,请联系管理员");
            return messageModel;
        }
        messageModel.setSuccess(true);
        return messageModel;
    }

    /**
     * 未授权
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/unauth")
    public String unauth(Model model) {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login";
        }
        return "/unauth";
    }

    /**
     * 退出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public MessageModel logout(HttpServletRequest request) {
        LOGGER.info("登出");
        Subject subject = SecurityUtils.getSubject();
        MessageModel result = new MessageModel(true);
        subject.logout();
        return result;
    }
}
