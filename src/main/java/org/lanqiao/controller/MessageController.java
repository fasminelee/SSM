package org.lanqiao.controller;

import java.util.Date;

import org.lanqiao.entity.Message;
import org.lanqiao.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MessageController {

	@Autowired
	MessageServiceImpl msgService;

	@RequestMapping("leaveMessages")
	public String leaveMessages(Message message) {
		message.setCreateTime(new Date());
		msgService.add(message);
		return "redirect:messages";
	}

	@RequestMapping("showMessages")
	String showMsgServlet(@RequestParam(value = "page", defaultValue = "") String page, Model model) {
		int pageSize = 3;
		int pageNum;
		int MaxPage = msgService.getMaxPage(pageSize);
		if(!page.equals("")&&page!=null){
			pageNum=Integer.parseInt(page);
		}
		else{
			pageNum=1;
		}
		model.addAttribute("page", pageNum);
		model.addAttribute("MaxPage", MaxPage);
		if(!model.containsAttribute("list")){
			model.addAttribute("list", msgService.getByPage(pageNum, pageSize));
		}
		return "messages";
	}

}
