package com.rd.util;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class MyDateFormat {
 

	private static String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}";
	//private static String regex = "(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?=\\W)|\\b(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])?|(?:(?:16|[2468][048]|[3579][26])00)?)))(?=\\W)|\\b(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))(\\4)?(?:(?:1[6-9]|[2-9]\\d)?\\d{2})?(?=\\b)";
	
	
	//private static String regex = "(^|\\s|\\()((([1-9]){1}|([0][1-9]){1}|([1][012]){1}){1}[\\/-]((2[0-9]){1}|(3[01]){1}|([01][1-9]){1}|([1-9]){1}){1}[\\/-](((19|20)([0-9][0-9]){1}|([0-9][0-9]){1})){1}(([\\s|\\)|:])|(^|\\s|\\()((([0-9]){1}|([0][1-9]){1}|([1][012]){1}){1}[\\/-](([11-31]){1}|([01][1-9]){1}|([1-9]){1}){1}[\\/-](((19|20)([0-9][0-9]){1}|([0-9][0-9]){1})){1}(([\\s|\\)|:|$|\\&gt;])){1}){1}){1}){1}";
	//private static String regex = "(\\d|\\d\\d)(\\p{Blank}*)[- /.](\\p{Blank}*)(\\d|\\d\\d)" + "(\\p{Blank}*)[- /.](\\p{Blank}*)((19|20)\\d\\d|\\d\\d)";
    private static Pattern dateFrmtPtrn =Pattern.compile(regex);
    
    public static boolean validateDateFormat(String userName){
         
        Matcher mtch = dateFrmtPtrn.matcher(userName);
        if(mtch.matches()){
            return true;
        }
        return false;
    }
    public static void main(String a[]){
    	/*System.out.println("****************");
        System.out.println(" 09/29/17 "+validateDateFormat("09/29/17 a valid date format"));
        System.out.println("Is '12/23/2012' a valid date format? "
                        +validateDateFormat("12/23/2012"));
        System.out.println("Is '12/12/12' a valid date format? "
                        +validateDateFormat("09/28/17"));
        System.out.println("Is '4/5/91' a valid date format? "
                        +validateDateFormat("01/1/01"));*/
        
        String dates = getDate("9/29/17 CHECKCARD  0928 SO EAST BAY PEDIATRIC M FREMONT      CA 24755427271282713698627 -10.00");
        String dates2 = getDate("Date Description Amount");
        System.out.println(dates);
        System.out.println(dates2);

    }
    
    
    
    private static String getDate(String desc) {
    	  String searchDate =null;
    	  Matcher m = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}").matcher(desc);
    	  while (m.find()) {
    		  searchDate = m.group();
    	  }
    	  return searchDate;
    	}
}