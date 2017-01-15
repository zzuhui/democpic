package com.weikehui.democpic.kaoping.service;

import org.springframework.web.multipart.MultipartFile;

import com.weikehui.democpic.kaoping.pojo.Message;

public interface KaopingService {
	public String test();

	public void kpimport();
	/**
	 * 读文件
	 * @param file
	 */
	public Message readFile(MultipartFile file);

	/**
	 * 读取考评主题信息
	 * @param file
	 * @return
	 */
	public Message readSubjectFile(MultipartFile file);
	
}
