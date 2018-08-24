package com.zhh.entity.base;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
* @ClassName: Role
* @Description: 角色实体类
* @author zhh
* @date 2016-8-12 上午9:15:54
* 
*/
@Getter
@Setter
@ToString
public class Role implements Serializable {
	
	private static final long serialVersionUID = -4987248128309954399L;

	/**
	* @Fields id : 主键
	*/
	private String id;
	
	/**
	* @Fields name : 角色名称
	*/
	private String name;
	
	/**
	* @Fields description : 角色描述
	*/
	private String description;
	/**
	 * 角色编码
	 */
	private String code;
	/**
	 * 角色状态
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
	  
	/**
	* @Fields permissionSet : 角色拥有的权限集合
	*/
	private Set<Permission> permissionSet = new HashSet<Permission>();

}
