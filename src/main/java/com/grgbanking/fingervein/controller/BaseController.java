package com.grgbanking.fingervein.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.grgbanking.fingervein.entity.User;

public class BaseController {

	/**
	 * 取得当前登录用户
	 * @return
	 */
	protected User getCurrentUser() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		User user = (User) session.getAttribute("currentUser");
		return user;
	}
}
