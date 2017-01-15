package com.weikehui.democpic.kaoping.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.weikehui.core.util.ExcelUtils;
import com.weikehui.democpic.kaoping.entity.KpRyztEntity;
import com.weikehui.democpic.kaoping.entity.KpSubjectEntity;
import com.weikehui.democpic.kaoping.pojo.Message;
import com.weikehui.democpic.kaoping.pojo.Status;
import com.weikehui.democpic.kaoping.repo.KpRyztRepo;
import com.weikehui.democpic.kaoping.repo.KpSubjectRepo;
import com.weikehui.democpic.kaoping.service.KaopingService;

@Service
public class KaopingServiceImpl implements KaopingService {
	
	@Autowired
	private KpRyztRepo kpRyztRepo;
	@Autowired
	private KpSubjectRepo kpSubjectRepo;

	@Override
	public String test() {
		System.out.println("------test------------");
		return "test";
	}

	@Override
	public void kpimport() {
		System.out.println("asfdasf");
	}

	@Override
	public Message readFile(MultipartFile file) {
		List<List<String>> lists = ExcelUtils.readFromExcel(file);
		Boolean flag = true;
		Message msg = new Message();
		
		for (int index = 1; index < lists.size(); index++) {
			List<String> list = lists.get(index);
			try {
				System.out.println(String.format("导入中，0=%s,1=%s,2=%s",list.get(0),list.get(1),list.get(2)) );
				// 保存导入信息
				KpRyztEntity ryzt = new KpRyztEntity();
				ryzt.setKprName(list.get(0));
				ryzt.setBkprName(list.get(1));
				ryzt.setEvaluationSubject(list.get(2));
				kpRyztRepo.save(ryzt);				
			} catch (Exception e) {
				System.out.println(String.format("导入失败，0=%s,1=%s,2=%s",list.get(0),list.get(1),list.get(2)) );
				flag = false;
			}			
			
		}
		
		if(flag){
			msg.setStatus(Status.SUCCESS);
			msg.setStatusMsg("File upload success");
		}else{
			msg.setStatus(Status.ERROR);
			msg.setStatusMsg("File upload error");			
		}
		
		return msg;
	}

	@Override
	public Message readSubjectFile(MultipartFile file) {

		List<List<String>> lists = ExcelUtils.readFromExcel(file);
		Boolean flag = true;
		Message msg = new Message();
		
		for (int index = 1; index < lists.size(); index++) {
			List<String> list = lists.get(index);
			try {
				System.out.println(String.format("导入中，json=%s",new Gson().toJson(list)));
				// 保存导入信息
				KpSubjectEntity subject = new KpSubjectEntity();
				subject.setSubject(StringUtils.isEmpty(list.get(0)) ? "" : list.get(0));
				subject.setFirstClass(StringUtils.isEmpty(list.get(1)) ? "" : list.get(1));
				subject.setSecClass(StringUtils.isEmpty(list.get(2)) ? "" : list.get(2));
				subject.setSecClassDesc(StringUtils.isEmpty(list.get(3)) ? "" : list.get(3));
				subject.setScore(new BigDecimal(StringUtils.isEmpty(list.get(4)) ? "0" : list.get(4)));
				kpSubjectRepo.save(subject);
			} catch (Exception e) {
				System.out.println(String.format("导入失败，json=%s",new Gson().toJson(list)));
				flag = false;
			}
		}
		
		if(flag){
			msg.setStatus(Status.SUCCESS);
			msg.setStatusMsg("File upload success");
		}else{
			msg.setStatus(Status.ERROR);
			msg.setStatusMsg("File upload error");			
		}
		
		return msg;
	
	}

}
