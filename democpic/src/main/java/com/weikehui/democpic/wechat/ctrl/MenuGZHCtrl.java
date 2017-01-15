package com.weikehui.democpic.wechat.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公众号菜单管理
 * @author TIT
 *
 */
@Controller
@RequestMapping("/wx/gzh/menu")
public class MenuGZHCtrl {
	
	@RequestMapping("/list")
	public String createMenu(Model model) {
		model.addAttribute("title", "微信菜单维护");
		return "wx/gzh/menu/list";
	}	
}
