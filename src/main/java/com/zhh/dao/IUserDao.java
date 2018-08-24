package com.zhh.dao;

import java.util.List;

import com.zhh.condition.user.UserCondition;
import com.zhh.entity.base.UserEntity;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
	
	int add(UserEntity user);
	
	int update(UserEntity user);
	
	List<UserEntity> selectPageList(@Param("condition") UserCondition condition, @Param("page")PageUtil page);
	
	UserEntity findUserByLoginNo(@Param("loginNo") String loginNo);

	int selectPageCountByCondition(@Param("condition") UserCondition condition);

	void lockUser(@Param("userIds") List<String> ids);

	void unLockUser(@Param("userIds") List<String> ids);
}
