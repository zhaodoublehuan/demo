package com.zhh.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: PageUtil
 * @Description: 分页工具类
 * @author zhh
 * @date 2016年8月15日 下午8:34:10
 * 
 */

public class PageUtil {

	/**
	 * @Fields pageSize : 每页显示的条数
	 */
	private int pageSize;

	/**
	 * @Fields recordCount :总共的条数
	 */
	private int recordCount;
	/**
	 * 开始索引
	 */
	private int recordStart;
	
	/**
	* @Fields sEcho : 记录操作次数
	*/
	private int sEcho;
	
	/**
	 * 构造方法
	 */
	public PageUtil(){
		
	}

	/**
	 * 构造方法
	 * 
	 * @param pageSize
	 * @param recordCount
	 */

	public PageUtil(int pageSize, int recordStart) {
		this.pageSize = pageSize;
		this.recordStart = recordStart;
	}
	
	/**
	 * 获取分页需要的参数
	 * @param aoData
	 * @return
	 */
	public static PageUtil getPageParams(String aoData) {
		List<ParamsUtil> paramList = JSON.parseArray(aoData, ParamsUtil.class);
		PageUtil page = new PageUtil();
		for(ParamsUtil param : paramList){
			if (param.getName().equals("sEcho"))
				 page.setsEcho(Integer.parseInt(param.getValue())+1);
	        if (param.getName().equals("iDisplayStart"))
	        	page.setRecordStart(Integer.parseInt(param.getValue()));
	        if (param.getName().equals("iDisplayLength"))
	        	page.setPageSize(Integer.parseInt(param.getValue()));
		}
		return page;
	}
	/** 
	* @Title: getPageSize 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/ 
	
	public int getPageSize() {
		return pageSize;
	}

	/** 
	* @Title: setPageSize 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageSize    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 
	* @Title: getRecordCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/ 
	
	public int getRecordCount() {
		return recordCount;
	}

	/** 
	* @Title: setRecordCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param recordCount    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getRecordStart() {
		return recordStart;
	}

	public void setRecordStart(int recordStart) {
		this.recordStart = recordStart;
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
}
