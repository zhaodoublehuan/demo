package com.zhh.util;

/**
* @ClassName: ParamsUtil
* @Description: 参数工具类
* @author zhh
* @date 2016-8-17 上午9:08:43
* 
*/

public class ParamsUtil {

	/**
	* @Fields name : 参数名称
	*/
	private String name;
	
	/**
	* @Fields value : 参数值
	*/
	private String value;

	/** 
	* @Title: getName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	public String getName() {
		return name;
	}

	/** 
	* @Title: setName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param name    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setName(String name) {
		this.name = name;
	}

	/** 
	* @Title: getValue 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	public String getValue() {
		return value;
	}

	/** 
	* @Title: setValue 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param value    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setValue(String value) {
		this.value = value;
	}
}
