package com.zhh.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @ClassName: Menu
* @Description: 菜单对应的实体类
* @author zhh
* @date 2016-8-13 上午10:23:15
* 
*/
@Getter
@Setter
public class Menu implements Serializable {

	private static final long serialVersionUID = -703248937151545172L;
	
	/**
	* @Fields id : 主键
	*/
	private String id;

    /**
    * @Fields menuUrl : 菜单地址
    */
    private String menuUrl;
    
    /**
    * @Fields menuName : 菜单名称
    */
    private String menuName;

    private String iconClass;

	/**
    * @Fields level : 菜单级别

    */
    private String level;
    
    /**
    * @Fields state : 菜单折叠状态 默认“close”
    */
    private String state;
    
    /**
    * @Fields sort : 菜单顺序
    */
    private String sort;
    
    /**
    * @Fields leaf : 是否子叶节点
    */
    private String leaf;

    /**
    * @Fields description : 菜单描述
    */
    private String description;
    
    /**
    * @Fields status : 菜单状态
    */
    private String active;

    /**
    * @Fields parentId : 父菜单id
    */
    private String parentId;

    /**
    * @Fields insertDate : 插入时间
    */
    private Date insertDate;

    /**
    * @Fields updateDate : 修改时间
    */
    private Date updateDate;
    
    /**
    * @Fields childrenMenu : 子级菜单
    */
    private List<Menu> childrenMenus;

}
