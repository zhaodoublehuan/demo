package com.zhh.service.base;

import com.alibaba.fastjson.JSON;
import com.zhh.condition.user.UserCondition;
import com.zhh.dao.IUserDao;
import com.zhh.entity.base.UserEntity;
import com.zhh.exception.ZhhException;
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

	/**
	 * 新建用户
	 * @param user
	 * @return
	 * @throws ZhhException
	 */
	public int add(UserEntity user) throws ZhhException {
		
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
			throw new ZhhException("添加用户失败！");
		}
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(UserEntity user) {
		LOGGER.warn("修改用户信息为========"+JSON.toJSONString(user));
		return userDao.update(user);
	}

	/**
	 * 根据查询条件获取用户信息
	 * @param condition
	 * @param page
	 * @return
	 */
	public List<UserEntity> selectUsers(UserCondition condition, PageUtil page) {
		return userDao.selectPageList(condition,page);
	}

	/**
	 * 通过账号查询用户信息
	 * @param loginNo
	 * @return
	 */
	public UserEntity findUserByLoginNo(String loginNo) {
		UserEntity user = userDao.findUserByLoginNo(loginNo);
		return user;
	}


	/**
	 * 查询用户数量
	 * @param conditio
	 * @return
	 */
	public int selectPageCountByCondition(UserCondition conditio) {
		return userDao.selectPageCountByCondition(conditio);
	}

	/**
	 * 批量锁定用户
	 * @param ids
	 * @return
	 */
	public int lockUser(List<String> ids) {
		if(ids !=null && ids.size()>0 ){
			userDao.lockUser(ids);
		}
		return 0;
	}

	/**
	 * 批量解锁用户
	 * @param ids
	 * @return
	 */
	public int unLockUser(List<String> ids) {
		if(ids !=null && ids.size()>0 ){
			userDao.unLockUser(ids);
		}
		return 0;
	}
}
