package com.road.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.road.common.config.Constants;
import com.road.exception.AppException;
import com.road.model.entity.User;

/**
 * @Description :
 * @FileName: AbstractController.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月9日 下午4:42:06
 * @Version:V1.00
 */
public abstract class AbstractController {

	protected final static String DISPOSITION_FORM_DATA_ATTACHMENT = "attachment";

	protected final static String DISPOSITION_FORM_DATA_INLINE = "inline";

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractController.class);

	protected Long getCurrentUser(HttpSession session) {
		User user = this.getCurrentUserInfo(session);
		return user != null ? user.getId() : null;
	}

	protected User getCurrentUserInfo(HttpSession session) {
		return (User) session.getAttribute(Constants.CURRENT_USER);
	}

	/**
	 *
	 * @Name: excption
	 * @Description:只接受有错误码的异常
	 * @Author: WeiHui.Zhang
	 * @Version: V1.00
	 * @Date: 2016年3月9日下午4:03:56
	 * @param request
	 * @param ex
	 * @return
	 * @Return: ResponseEntity<Integer>
	 */
	@ExceptionHandler(value = AppException.class)
	@ResponseBody
	public com.road.utils.ResponseEntity<Integer> excption(
			HttpServletRequest request, AppException ex) {
		com.road.utils.ResponseEntity<Integer> responseEntity = new com.road.utils.ResponseEntity<Integer>(
				false);
		int errorCode = ex.getErrorCode();
		responseEntity.setCode(errorCode);
		return responseEntity;
	}

	/**
	 * 设置客户端可以回显图片
	 */
	protected ResponseEntity<byte[]> showImages(File file) {
		HttpHeaders headers = this.getHttpHeaders(DISPOSITION_FORM_DATA_INLINE,
				file.getAbsolutePath());
		try {
			return new ResponseEntity<byte[]>(
					FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected ResponseEntity<byte[]> showImages(String path) {
		HttpHeaders headers = this.getHttpHeaders(DISPOSITION_FORM_DATA_INLINE,
				path);
		try {
			return new ResponseEntity<byte[]>(
					FileUtils.readFileToByteArray(new File(path)), headers,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 设置客户端可以下载文件
	 */
	protected ResponseEntity<byte[]> setDownloadAttachment(File file)
			throws AppException {
		/* 在这里指定service的导出方法，并将导出的结果放在fileFullName 文件里 */

		if (file == null || !file.exists() || !file.canRead()) {// if
																// 文件为空，或者文件不存在，或者文件存在但不能读,都不允许操作
			throw new AppException("【附件下载:】请输入正确的文件，该文件必须存在且可读。");
		}

		try {
			// 1、
			HttpHeaders headers = this
					.getHttpHeaders(DISPOSITION_FORM_DATA_ATTACHMENT,
							new String(
									file.getAbsolutePath().getBytes("utf-8"),
									"ISO-8859-1"));

			return new ResponseEntity<byte[]>(
					FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected ResponseEntity<byte[]> setDownloadAttachment(String path)
			throws AppException {
		/* 在这里指定service的导出方法，并将导出的结果放在fileFullName 文件里 */

		if (StringUtils.isEmpty(path)) {// if 文件为空，或者文件不存在，或者文件存在但不能读,都不允许操作

			throw new AppException("【附件下载:】请输入正确的文件，该文件必须存在且可读。");
		}

		try {
			// 1、
			HttpHeaders headers = this.getHttpHeaders(
					DISPOSITION_FORM_DATA_ATTACHMENT,
					new String(path.getBytes("utf-8"), "ISO-8859-1"));

			return new ResponseEntity<byte[]>(
					FileUtils.readFileToByteArray(new File(path)), headers,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private HttpHeaders getHttpHeaders(String dispositionFormData, String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData(dispositionFormData, path);
		return headers;
	}

	protected void setNoCache(HttpServletResponse response) {
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires",0);
	}
}
