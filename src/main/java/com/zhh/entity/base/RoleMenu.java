package com.zhh.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class RoleMenu {
	
	private String menuId;
	
	/**
	* @Fields roleId : 角色id
	*/
	private String roleId;
	
	/**
	* @Fields active : 使用状态
	*/
	private String active;
	
	/**
	* @Fields insertDate : 插入时间
	*/
	private Date insertDate;
	
	/**
	* @Fields updateDate : 修改时间
	*/
	private Date updateDate;

}
