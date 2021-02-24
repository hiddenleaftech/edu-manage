package com.hiddenleaf.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

public class Utils {
	
	public static final String DATE_TIME_FORMAT="yyyyMMdd-HHmmss";
	
	private final Logger log = LoggerFactory.getLogger(Utils.class);
	
	public  double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();	    
	 
	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public boolean checkIfProfile(Environment environment, String profile) {
	
	 String[] profileArray  = environment.getActiveProfiles();
	 
	 if(profileArray != null) {
		 List<String> list = Arrays.asList(profileArray);
		 return list.contains(profile);
	 }
	 return false;
	}
	
	public Date getDateFor(int year, int month, int date, int hours, int mini, int sec, int milli) {
		
		Calendar cal = Calendar.getInstance(); 
		cal.set(year, month, date, hours, mini, sec);
		Date d = cal.getTime();
		return d;
	}
	
	
	public int getLastDay(int year, int month, int date) {
		Calendar cal = Calendar.getInstance(); 
		cal.set(year, month, date);
		return cal.getActualMaximum(Calendar.DATE);
	}
	
	
	public Date getNextMonday(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int weekday = now.get(Calendar.DAY_OF_WEEK);
		if (weekday != Calendar.MONDAY)
		{
		    // calculate how much to add
		    // the 2 is the difference between Saturday and Monday
		    int days = (Calendar.SATURDAY - weekday + 2) % 7;
		    now.add(Calendar.DAY_OF_YEAR, days);
		}
		now.set(Calendar.HOUR_OF_DAY, 05);
		now.set(Calendar.MINUTE, 0);
		// now is the date you want
		Date mondayDate = now.getTime();
		System.out.println("Next Monday date "+mondayDate);
		return mondayDate;
	}
	
	
	public Date getNextSaturday(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int weekday = now.get(Calendar.DAY_OF_WEEK);
		if (weekday != Calendar.SATURDAY)
		{
		    // calculate how much to add
		    // the 2 is the difference between Saturday and Monday
		    int days = (Calendar.SATURDAY - weekday + 0) % 7;
		    now.add(Calendar.DAY_OF_YEAR, days);
		}
		now.set(Calendar.HOUR_OF_DAY, 05);
		now.set(Calendar.MINUTE, 0);
		// now is the date you want
		Date saturDay = now.getTime();
		System.out.println("Next Saturday date "+saturDay);
		return saturDay;
	}
	
	public static String convertDateToStringFormat(Date inputDate,String sFormat){
		if(inputDate!=null && sFormat!=null && !sFormat.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
			return sdf.format(inputDate);
		}else{
			return null;
		}
	}
	
	public static void main(String args[]) {
		
		double profit = -5;
		double start = -9999;
		double ends = -5;
		
		if (profit > start && profit <= ends) {
			System.out.println("matched");
		}else {
			System.out.println("not matched");
		}
	}

	private static boolean isNaN(Double profit) {
		// TODO Auto-generated method stub
		return false;
	}
}
