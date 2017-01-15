package com.weikehui.democpic.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.weikehui.core.util.entity.BaseEntity;
/**
 * 微信账号
 * @author TIT
 *
 */
@Entity
@Table(name = "t_wx_account")
public class AccountWXEntity extends BaseEntity {
	/**
	 * 微信账号
	 */
	@Column(name="account",columnDefinition="varchar(150) COMMENT '微信账号'",unique=true)
	private String account;
	/**
	 * 微信账号类型:0-订阅号；1-服务号；2-企业号
	 */
	@Column(name="account_type",columnDefinition="varchar(2) COMMENT '微信账号类型:0-订阅号；1-服务号；2-企业号'",nullable=false)
	private String account_type;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
}
