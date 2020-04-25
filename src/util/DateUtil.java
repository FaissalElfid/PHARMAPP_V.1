package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtil {
	private static String FORMAT_YY_MM_DD = "yyyy-MM-dd";
    private static String FORMAT_YYYY = "yyyy";
    
    public static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD);
        return simpleDateFormat.format(date);
	}
    public static Date parse(String dateAsString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD);
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException exception) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }
    public static Date parseToYear(String dateAsString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY);
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException exception) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }
	public int periodMonth(String date1Str, String date2Str) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate2 = LocalDate.parse(date2Str, format);
        LocalDate localDate1 = LocalDate.parse(date1Str, format);
        Period period = Period.between(localDate2, localDate1);
        return period.getYears() * 12 + period.getMonths();

    }
	
}
