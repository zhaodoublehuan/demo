package com.zhh.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
* @ClassName: UserRole
* @Description: 用户角色实体
* @author zhh
* @date 2016-8-12 上午9:14:37
* 
*/
@Getter
@Setter
public class UserRole {

	/**
	* @Fields userId : 用户id

	*/
	private String loginNo;
	
	/**
	* @Fields roleId : 角色id
	*/
	private String roleId;
	
	/**
	* @Fields insertDate : 插入时间
	*/
	private Date insertDate;


}
