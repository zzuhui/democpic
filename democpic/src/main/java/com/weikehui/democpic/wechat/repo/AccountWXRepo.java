package com.weikehui.democpic.wechat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weikehui.democpic.wechat.entity.AccountWXEntity;

/**
 * 微信账号管理Repo
 * @author TIT
 *
 */
public interface AccountWXRepo extends JpaRepository<AccountWXEntity, Long> {

}
