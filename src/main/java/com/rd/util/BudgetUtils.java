package com.rd.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BudgetUtils {
	
	static String DATE_FORMAT ="mm/dd/yy";
	static String REGEX ="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}";
	
    @SuppressWarnings("unused")
	public static String searchDate(String desc) {
  	  String searchDate =null;
  	  Matcher m = Pattern.compile(REGEX).matcher(desc);
  	  while (m.find()) {
  		  searchDate = m.group();
  	  }
  	  return searchDate;
  	}
    
    public static Double convertStringToDouble(String price) 
    {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number=null;
		try {
			number = format.parse(price);
		} catch (ParseException e) {
			e.printStackTrace();
		}
       return number.doubleValue();
    }
    
    public static Date convertStringToDate(String stringDate) 
    {
    	Date date = null;
    	try {
    		date=  new SimpleDateFormat(DATE_FORMAT).parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
       
    }
    

}
