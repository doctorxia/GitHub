package com.road.aop;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.road.utils.DateUtils;

/**
 * @Description :请求日志
 * @FileName: RequestLogAop.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月9日 下午3:21:50
 * @Version:V1.00
 */
@Aspect
@Component
public class RequestLogAop {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RequestLogAop.class);

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void cutController() {
	}

	@SuppressWarnings("unchecked")
	@Around("cutController()")
	public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
		String strMethodName = point.getSignature().getName();
		String strClassName = point.getTarget().getClass().getName();
		Object[] params = point.getArgs();
		StringBuffer bfParams = new StringBuffer();
		Enumeration<String> paraNames = null;
		HttpServletRequest request = null;
		if (params != null && params.length > 0) {
			request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			paraNames = request.getParameterNames();
			String key;
			String value;
			while (paraNames.hasMoreElements()) {
				key = paraNames.nextElement();
				value = request.getParameter(key);
				bfParams.append(key).append("=").append(value).append("&");
			}
			if (StringUtils.isBlank(bfParams)) {
				bfParams.append(request.getQueryString());
			}
		}

		String remoteAddr = "";
		String requestURI = "";
		Enumeration<String> headers = null;
		if (request != null) {
			remoteAddr = request.getRemoteAddr();
			requestURI = request.getRequestURI();
			headers = request.getHeaderNames();

		}

		LOGGER.info("-------------------{}--------------------",
				DateUtils.DATETIME.format(new Date()));
		LOGGER.info("----[类名:]{}------------------------------", strClassName);
		LOGGER.info("----[方法:]{}------------------------------", strMethodName);
		LOGGER.info("----[参数:]{}-------------------------", bfParams.toString());
		LOGGER.info("----[请求IP:]{}----------------------------", remoteAddr);
		LOGGER.info("----[request-uri:]{}----------------------", requestURI);
		if (headers != null) {
			while (headers.hasMoreElements()) {
				String header = headers.nextElement();
				LOGGER.info("----[{}:]{}---------------", header,
						request.getHeader(header));
			}
		}
		LOGGER.info("------------------------------------------");

		return point.proceed();
	}

	// private boolean isWriteLog(String method) {
	// String[] pattern = { "login", "logout", "add", "edit", "delete",
	// "grant" };
	// for (String s : pattern) {
	// if (method.indexOf(s) > -1) {
	// return true;
	// }
	// }
	// return false;
	// }
}
