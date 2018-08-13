package com.zhh.util;

/**
* @ClassName: ReturnResult
* @Description: 返回操作成功与失败
* @author zhh
* @date 2017-5-6 下午5:18:59
* 
*/

public class ReturnResult {
	//0表示成功，1表示失败
	private int status;
	
	private String msg;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
