package org.lanqiao.controller;

import org.lanqiao.entity.User;
import org.lanqiao.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping("list")
	public String index(String error) {
		return "index";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("checkUser")
	public String checkUer(User user, Model model, HttpSession session) {
		boolean retUser = userService.checkIsExist(user);
		if (retUser) {
			session.setAttribute("user", user);
			return "forward:index";
		} else {
			model.addAttribute("error", "用户名或密码错误！");
			return "login";
		}
		// if (user.getUserName().equals("111") &&
		// user.getPassword().equals("111")) {
		// session.setAttribute("user", user);
		// return "forward:index";
		// } else {
		// model.addAttribute("error", "用户名或密码错误！");
		// return "login";
		// }
	}

	// @RequestMapping("checkUser")
	// public String check(Users user, Model model, HttpSession session) {
	// UserServiceImpl service = new UserServiceImpl();
	// boolean flag = service.checkIsExist(user);
	//
	// if (user.getUserName().equals("111") && user.getPassword().equals("111"))
	// {
	// session.setAttribute("userBean", user);
	// return "forward:index";
	// } else {
	// model.addAttribute("error", "用户名或密码错误！");
	// return "login";
	// }
	// }

	@RequestMapping("checkUserAjax")
	@ResponseBody
	public Object checkUserAjax(User user) {
		userService.checkIsExist(user);
		return user;
	}
}
