package com.weikehui.democpic.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.weikehui.democpic.wechat.service.MenuGZHService;

@Service
public class MenuGZHServiceImpl implements MenuGZHService {

	@Override
	public Gson createMenu(Gson gson) {
		Gson resultgson = new Gson();
		
		return resultgson;
	}
	
}
