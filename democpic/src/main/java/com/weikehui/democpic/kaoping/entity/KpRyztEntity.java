package com.weikehui.democpic.kaoping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.weikehui.core.util.entity.BaseEntity;

/**
 * 考评人员与主题关系表
 * @author TIT
 *
 */
@Entity
@Table(name = "t_kp_ryzt")
public class KpRyztEntity extends  BaseEntity{
	/**
	 * 考评人 
	 */
	@Column(name="kpr_name")
	private String kprName;
	/**
	 * 被考评人
	 */
	@Column(name="bkpr_name")
	private String bkprName;	
	/**
	 * 考评主题
	 */
	@Column(name="evaluation_subject")
	private String evaluationSubject;
	/**
	 * 考评状态 00-未评；10-已评
	 */
	@Column(name="kp_state")
	private String kpState;

	public String getKprName() {
		return kprName;
	}
	public void setKprName(String kprName) {
		this.kprName = kprName;
	}
	public String getBkprName() {
		return bkprName;
	}
	public void setBkprName(String bkprName) {
		this.bkprName = bkprName;
	}
	public String getEvaluationSubject() {
		return evaluationSubject;
	}
	public void setEvaluationSubject(String evaluationSubject) {
		this.evaluationSubject = evaluationSubject;
	}
	public String getKpState() {
		return kpState;
	}
	public void setKpState(String kpState) {
		this.kpState = kpState;
	}
	
}
