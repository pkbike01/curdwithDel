package com.crudoperationRestApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class A {
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
//		System.out.print(date);
		
		
		
//		------------------------------------------------------
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date1 = simpleDateFormat.format(new Date());
		System.out.println(date1);
		Date date2=new SimpleDateFormat("YYYY-MM-dd").parse(date1);  

		System.out.println();
		
		System.out.println(date2);
		
		
//		-------------------------------------------------
		String dateString = "2023-10-31"; // Replace with your input string

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
	    try {
	        Date date3 = sdf.parse(dateString);
	        System.out.println("Parsed Date: " + date3);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    
//	    ---------------------------------------------
	    String inputDateStr = "Fri Jul 16 00:00:00 IST 6";

        // Step 1: Parse the original date using the source format
        SimpleDateFormat sourceDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z y");
        Date parsedDate = null;

        try {
            parsedDate = sourceDateFormat.parse(inputDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Format the parsed date to the target format
        SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String outputDateStr = targetDateFormat.format(parsedDate);

        System.out.println("Converted Date: " + outputDateStr);
    }
	
	
	


}