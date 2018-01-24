package com.rd.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Test {
	
    
	public static void main(String args[]) throws ParseException {
	      
    /*    // This is how to get today's date in Java
        Date today = new Date();
      
        //If you print Date, you will get un formatted output
        System.out.println("Today is : " + today);
      
        //formatting date in Java using SimpleDateFormat
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yyyy format : " + date);
      
        //Another Example of formatting Date in Java using SimpleDateFormat
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd/MM/yy pattern : " + date);
      
        //formatting Date with time information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);
      
        //SimpleDateFormat example - Date with timezone information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS Z");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SSZ : " + date);
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String dateInString = "09/29/17"; //dateInString = "09/29/2017";dd-MMM-yyyy
        
        DateFormat sdfp = new SimpleDateFormat("mm/dd/yy");
        Date d = sdfp.parse(dateInString);
        System.out.println("----done-----"+d);
        DateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdff.format(d);

        
        Date date1=new SimpleDateFormat("mm/dd/yy").parse(dateInString);
        System.out.println("date1"+"-----------"+date1);
        try {

            Date date2 = formatter.parse(dateInString);
            System.out.println(date2);
            System.out.println(formatter.format(date2));

        } catch (ParseException e) {
            e.printStackTrace();
        }*/
		String monthlyRecord="2017-01";
      String f="from Spending  spending WHERE spending.transactionDate LIKE '"+monthlyRecord+"%'";
    		  System.out.println(f);
    		  
    		  
    		 Date t = new Date();
    		 
    		 java.sql.Date s = new java.sql.Date(t.getTime());
    		 
    		 String date = "2015-04-12";
    		 java.sql.Date dat = java.sql.Date.valueOf(date);

    		 LocalDate localDate = dat.toLocalDate();
    		 System.out.println(localDate.getDayOfMonth());
    		 System.out.println(localDate.getMonthValue());
    		 System.out.println(localDate.getYear());
    		 
    		 Double testValue=90.0d; 
    		 System.out.println(0-testValue);
    		 
  
}

	
}
