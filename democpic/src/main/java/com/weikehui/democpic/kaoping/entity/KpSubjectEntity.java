package com.weikehui.democpic.kaoping.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.weikehui.core.util.entity.BaseEntity;

/**
 * 考评主题
 * @author TIT
 *
 */
@Entity
@Table(name = "t_kp_subject")
public class KpSubjectEntity extends  BaseEntity{

	/**
	 * 考评主题
	 */
	private String subject;
	
	/**
	 * 大类
	 */
	@Column(name="first_class")
	private String firstClass;
	/**
	 * 子类
	 */
	@Column(name="sec_class")
	private String secClass;
	/**
	 * 子类描述
	 */
	@Column(name="sec_class_desc")
	private String secClassDesc;
	/**
	 * 分值
	 */
	private BigDecimal score;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}

	public String getSecClass() {
		return secClass;
	}

	public void setSecClass(String secClass) {
		this.secClass = secClass;
	}

	public String getSecClassDesc() {
		return secClassDesc;
	}

	public void setSecClassDesc(String secClassDesc) {
		this.secClassDesc = secClassDesc;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}	
	
	
	
	
}
