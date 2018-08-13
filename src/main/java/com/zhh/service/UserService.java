package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.dao.IUserDao;
import com.zhh.entity.UserEntity;
import com.zhh.exception.UserException;
import com.zhh.util.CommonParams;
import com.zhh.util.PageUtil;
import com.zhh.util.UUIDUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @ClassName: UserService
* @Description: 用户信息管理实现层
* @author zhh
* @date 2016-8-11 上午9:03:50
* 
*/
@SuppressWarnings("restriction")
@Service
public class UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	@Autowired
	private IUserDao userDao;

	
	public int add(UserEntity user) throws UserException {
		
		try{
			String password = user.getPassword();
			String salt = UUIDUtils.getUUID();
			password =  new Md5Hash(password,salt,2).toHex(); 
			Date now = new Date();
			/*设置ID*/
			user.setId(UUIDUtils.getUUID());
			user.setInsertDate(now);
			user.setUpdateDate(now);
			user.setSalt(salt);
			user.setActive(CommonParams.ACTIVE);
			user.setPassword(password);
			LOGGER.warn("添加用户信息为========"+JSON.toJSONString(user));
			return userDao.add(user);
		}catch (Exception e) {
			LOGGER.error("添加用户失败========"+e.getMessage());
			throw new UserException("添加用户失败！");
		}
	}

	
	public int update(UserEntity user) {
		LOGGER.warn("修改用户信息为========"+JSON.toJSONString(user));
		return userDao.update(user);
	}


	public int delete(List<String> ids) {

			LOGGER.warn("删除用户信息为========"+JSON.toJSONString(ids));
			return userDao.delete(ids);
		
	}

	
	public List<UserEntity> selectUsers(UserEntity user,PageUtil page) {
		return userDao.selectUsers(user,page);
	}

	
	public UserEntity findUserByLoginNo(String loginNo) {
		UserEntity user = userDao.findUserByLoginNo(loginNo);
		return user;
	}


	
	public int selectUsersCount(UserEntity user) {
		return userDao.selectUsersCount(user);
	}

	

}
