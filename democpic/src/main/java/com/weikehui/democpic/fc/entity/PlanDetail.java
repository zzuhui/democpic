package com.weikehui.democpic.fc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.weikehui.core.util.entity.BaseEntity;

/**
 * 每日计划详情表
 * @author TIT
 *
 */
@Entity
@Table(name = "t_plan_detail")
public class PlanDetail extends BaseEntity {
	//主题
	private String subject;
	//计划时间
	private Date planDate;
	//活动地点
	private String place;
	//计划详情
	private String details;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
