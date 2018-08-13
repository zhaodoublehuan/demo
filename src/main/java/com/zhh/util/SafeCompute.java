package com.zhh.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算用工具类，用于小数的加减乘除求余等操作
 * @author 315238
 *
 */
public class SafeCompute {
	
	/*默认保留小数点后2位小数*/
	private static final int DEFAULT_SCALE = 2;
	public static final double DOUBLE_ZERO = BigDecimal.ZERO.doubleValue();
	
	/**
	 * 加法
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double add(Double d1,Double d2){
		BigDecimal b1,b2;
		if(d1==null){
			b1 = BigDecimal.ZERO;
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		if(d2==null){
			b2 = BigDecimal.ZERO;
		}else{
			b2 = BigDecimal.valueOf(d2);
		}
		BigDecimal result = b1.add(b2);
		return result.doubleValue();
	}
	
	/**
	 * 减法
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double sub(Double d1,Double d2){
		BigDecimal b1,b2;
		if(d1==null){
			b1 = BigDecimal.ZERO;
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		if(d2==null){
			b2 = BigDecimal.ZERO;
		}else{
			b2 = BigDecimal.valueOf(d2);
		}
		BigDecimal result = b1.subtract(b2);
		return result.doubleValue();
	}
	
	/**
	 * 除法
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double divide(Double d1,Double d2){
		BigDecimal b1,b2;
		if(d2==null){
			return null;
		}else{
			b2 = BigDecimal.valueOf(d2);
		}
		if(d1==null){
			return BigDecimal.ZERO.doubleValue();
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		BigDecimal result = b1.divide(b2);
		return result.doubleValue();
	}

	/**
	 * 乘法
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double multiply(Double d1,Double d2){
		BigDecimal b1,b2;
		if(d1==null){
			return DOUBLE_ZERO;
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		if(d2==null){
			return DOUBLE_ZERO;
		}else{
			b2 = BigDecimal.valueOf(d2);
		}
		BigDecimal result = b1.multiply(b2);
		return result.doubleValue();
	}
	
	/**
	 * 比较
	 * @param d1
	 * @param d2
	 * @return d1>d2:1  d1=d2:0  d1<d2:-1
	 */
	public static Integer compare(Double d1,Double d2){
		BigDecimal b1,b2;
		if(d1==null){
			b1 = BigDecimal.ZERO;
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		if(d2==null){
			b2 = BigDecimal.ZERO;
		}else{
			b2 = BigDecimal.valueOf(d2);
		}
		return b1.compareTo(b2);
	}
	
	/**
	 * 设置精度
	 * @param d1
	 * @return
	 */
	public static Double setScale(Double d1){
		return setScale(d1,DEFAULT_SCALE,RoundingMode.HALF_UP);
	}
	
	/**
	 * 设置精度
	 * @param d1
	 * @param scale 保留小数位数  如：2表示小数点后2位小数； -2表示保留到百位
	 * @param roundingMode 舍入方式，常见：
	 * 		RoundingMode.HALF_UP：四舍五入
	 * 		RoundingMode.UP：向上取整
	 * 		RoundingMode.FLOOR：向下取整
	 * @return
	 */
	public static Double setScale(Double d1,Integer scale,RoundingMode roundingMode){
		BigDecimal b1;
		if(d1==null){
			return BigDecimal.ZERO.doubleValue();
		}else{
			b1 = BigDecimal.valueOf(d1);
		}
		if(roundingMode==null){
			roundingMode = RoundingMode.HALF_UP;
		}
		if(scale==null){
			scale = 0;
		}
		return b1.setScale(scale,roundingMode).doubleValue();
	}
}
