package com.zhh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 * 时间工具类，用于时间字符串与date的相互转换
 * @author wjf
 *
 */
public class DateUtils {

	private static final Log logger = LogFactory.getLog(DateUtils.class);


	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";

	public static final String DAYTIME_START = "00:00:00";
	public static final String DAYTIME_END = "23:59:59";

	private DateUtils() {
		
	}

	private static final String[] FORMATS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mm:ss", "HH:mm", "HH:mm:ss", "yyyy-MM",
			"yyyy-MM-dd HH:mm:ss.S" };

	/**
	 * 转换字符串至时间格式
	 * @param str
	 * @return
	 */
	public static Date convert(String str) {
		if (str != null && str.length() > 0) {
			if (str.length() > 10 && str.charAt(10) == 'T') {
				str = str.replace('T', ' ');
			}
			for (String format : FORMATS) {
				if (str.length() != format.length()) {
					continue;
				}
				try {
					Date date = new SimpleDateFormat(format).parse(str);
					return date;
				} catch (ParseException e) {
					logger.warn(e.getMessage());
				}
			}
		}
		return null;
	}
	/**
	 * 转换字符串至时间格式
	 * @param str
	 * @return
	 */
	public static Date convert(String str, String format) {
		if (!StringUtils.isEmpty(str)) {
			try {
				Date date = new SimpleDateFormat(format).parse(str);
				return date;
			} catch (ParseException e) {
				logger.warn(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 转换时间格式至字符串
	 * @param str
	 * @return
	 */
	public static String convert(Date date) {
		return convert(date, DATE_TIME_FORMAT);
	}
	/**
	 * 转换时间格式至字符串
	 * @param str
	 * @return
	 */
	public static String convert(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}
		if (null == dateFormat) {
			dateFormat = DATE_TIME_FORMAT;
		}
		return new SimpleDateFormat(dateFormat).format(date);
	}

	/**
	 * 设置某天的开始时间:日期后追加00:00:00
	 * @param date
	 * @return
	 */
	public static Date getStartDatetime(Date date) {
		String thisdate = convert(date, DATE_FORMAT);
		return convert(thisdate + " " + DAYTIME_START);
	}

	/**
	 * 获取几日后的开始时间
	 */
	public static Date getStartDatetime(Date date, Integer diffDays) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60
				* diffDays);
		return convert(thisdate + " " + DAYTIME_START);
	}

	public static Date getEndDatetime(Date date) {
		String thisdate = convert(date, DATE_FORMAT);
		return convert(thisdate + " " + DAYTIME_END);

	}

	public static Date getEndDatetime(Date date, Integer diffDays) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60
				* diffDays);
		return convert(thisdate + " " + DAYTIME_END);

	}

	public static String addDay(Date date, int day) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(new Date(date.getTime() + 1000l * 24 * 60 * 60 * day));
	}

	public static Date addDayToDate(Date date, int day) {
		return new Date(date.getTime() + 1000l * 24 * 60 * 60 * day);
	}

	public static Long getTimeDiff(String startTime, String endTime) {
		Long days = null;
		Date startDate = null;
		Date endDate = null;
		try {
			if (startTime.length() == 10 && endTime.length() == 10) {
				startDate = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
				endDate = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
			} else {
				startDate = new SimpleDateFormat(DATE_TIME_FORMAT)
						.parse(startTime);
				endDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(endTime);
			}

			days = getTimeDiff(startDate, endDate);
		} catch (ParseException e) {
			logger.warn(e.getMessage());
			days = null;
		}
		return days;
	}

	public static Long getTimeDiff(Date startTime, Date endTime) {
		Long days = null;

		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		long l_start = c.getTimeInMillis();
		c.setTime(endTime);
		long l_end = c.getTimeInMillis();
		days = (l_end - l_start) / 86400000;
		return days;
	}

	public static Long getMinuteDiff(Date startTime, Date endTime) {
		Long minutes = null;

		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		long l_s = c.getTimeInMillis();
		c.setTime(endTime);
		long l_e = c.getTimeInMillis();
		minutes = (l_e - l_s) / (1000l * 60);
		return minutes;
	}

	public static String getPidFromDate(Date date) {
		if (date == null) {
			return "";
		}

		String m = convert(date, "yyyyMM");
		String d = convert(date, "dd");

		if (Integer.valueOf(d) <= 10) {
			d = "01";
		} else if (Integer.valueOf(d) <= 20) {
			d = "02";
		} else {
			d = "03";
		}

		return m.concat(d);
	}

	public static String formatDate(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatDate(Date date) {
		return formatDate(date, DATE_TIME_FORMAT);
	}

	public static String formatDate() {
		return formatDate(new Date(), DATE_TIME_FORMAT);
	}

	public static Date parseDate(String format, String dateStr)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}

	public static Date parseDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		return sdf.parse(dateStr);
	}

	public static String getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return month < 10 ? "0" + month : "" + month;
	}

	public static String getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return "" + year;
	}

	public static Date addDate(Date date, int type, int step) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, step);
		return calendar.getTime();
	}

	public static Date convertToDate(XMLGregorianCalendar cal) {
		if (cal != null) {
			GregorianCalendar ca = cal.toGregorianCalendar();
			return ca.getTime();
		} else {
			return null;
		}
	}

	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return gc;
	}

	public static String getMonth(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String time = format.format(c.getTime());
		return time;

	}

	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static String getLastYear(String time) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DateUtils.parseDate("yyyy-MM", time));
		} catch (ParseException e) {
			logger.warn("warn", e);
		}
		cal.add(Calendar.YEAR, -1);
		String lastYear = DateUtils.formatDate(cal.getTime(), "yyyy-MM");
		return lastYear;
	}

	public static String getLastMonth(String time, int i) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DateUtils.parseDate("yyyy-MM", time));
		} catch (ParseException e) {
			logger.warn("warn", e);
		}
		cal.add(Calendar.MONTH, i);
		String lastYear = DateUtils.formatDate(cal.getTime(), "yyyy-MM");
		return lastYear;
	}

	public static String getMonthOfYear(String time, int count) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DateUtils.parseDate("yyyy-MM", time));
		} catch (ParseException e) {
			logger.warn("warn", e);
		}
		cal.add(Calendar.YEAR, count);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		StringBuffer endStr = new StringBuffer().append(
				DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd")).append(
				" 23:59:59");
		return endStr.toString();
	}

	public static int getMonthSpace(Date date1, Date date2)
			throws ParseException {

		int result = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(date1);
		c2.setTime(date2);

		result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);

		return result == 0 ? 0 : Math.abs(result);

	}
}
