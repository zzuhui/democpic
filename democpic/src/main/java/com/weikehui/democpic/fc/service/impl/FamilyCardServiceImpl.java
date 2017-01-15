package com.weikehui.democpic.fc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.weikehui.democpic.fc.entity.PlanDetail;
import com.weikehui.democpic.fc.repo.PlanDetailRepo;
import com.weikehui.democpic.fc.service.FamilyCardService;

@Service
public class FamilyCardServiceImpl implements FamilyCardService {
	
	@Autowired
	private PlanDetailRepo planDetailRepo;
	
	@Override
	public List<PlanDetail> getPlansByMonth(Date dailydate,Sort sort) {		
		return planDetailRepo.findAll(sort);
	}
	
}
