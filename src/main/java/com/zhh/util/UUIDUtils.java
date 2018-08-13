package com.zhh.util;

import java.util.UUID;

/**
* @ClassName: UUIDUtils
* @Description: 获取uuid
* @author zhh
* @date 2016-8-11 下午3:43:46
* 
*/

public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
