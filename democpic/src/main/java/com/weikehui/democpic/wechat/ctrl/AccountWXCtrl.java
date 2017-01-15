package com.weikehui.democpic.wechat.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信账号维护
 * @author TIT
 *
 */
@Controller
@RequestMapping("/wx/account")
public class AccountWXCtrl {
	
	@RequestMapping("/list")
	public String listMenu(Model model) {
		model.addAttribute("title", "微信账号管理");
		return "wx/account/list";
	}
	
	@RequestMapping("/add")
	public String addMenu(Model model) {
		model.addAttribute("title", "微信账号添加");
		return "wx/account/create";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public void saveMenu(Model model) {
		model.addAttribute("title", "微信账号保存");
		
	}
	
}
