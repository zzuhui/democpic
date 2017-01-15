package com.weikehui.democpic.fc.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.weikehui.democpic.fc.entity.PlanDetail;

public interface FamilyCardService {
	/**
	 * 根据日期获取计划任务
	 * @param dailydate
	 * @return
	 */
	public List<PlanDetail> getPlansByMonth(Date dailydate,Sort sort);
}
