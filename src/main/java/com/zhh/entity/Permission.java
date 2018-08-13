package com.zhh.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
* @ClassName: Permission
* @Description: 权限实体类
* @author zhh
* @date 2016-8-12 上午9:16:33
* 
*/
@Getter
@Setter
public class Permission implements Serializable{
	
	private static final long serialVersionUID = -8025597823572680802L;

	/**
	* @Fields id : 主键
	*/
	private String id;
	
	/**
	* @Fields name : 权限名称
	*/
	private String name;
	  
	/**
	* @Fields description : 权限描述
	*/
	private String description;
	
	/**
	* @Fields insertDate : 插入时间
	*/
	private Date insertDate;
	
	/**
	* @Fields updateDate : 修改时间
	*/
	private Date updateDate;

}
