package com.zhh.util;

/**
* @ClassName: PageReturnParam
* @Description: 分页返回的参数
* @author zhh
* @date 2017-5-6 上午11:10:36
*
*/

public class PageReturnParam {

	private int sEcho;

	private int iTotalRecords;

	private int iTotalDisplayRecords;

	private Object aaData;

	public PageReturnParam(){

	}

    public PageReturnParam(int sEcho, int count,Object aaData) {
		this.sEcho = sEcho;
		this.iTotalDisplayRecords = count;
		this.iTotalRecords=count;
		this.aaData = aaData;
    }

    public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object getAaData() {
		return aaData;
	}

	public void setAaData(Object aaData) {
		this.aaData = aaData;
	}
}
