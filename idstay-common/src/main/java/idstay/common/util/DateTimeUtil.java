package idstay.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    public static final String KST = "Asia/Seoul";


    public static Date getLocalDate() {
        TimeZone timeZone = TimeZone.getTimeZone(KST);
        Calendar calendar = Calendar.getInstance(timeZone);

        return calendar.getTime();
    }

    public static String getLocalDateString() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        return df.format(getLocalDate());
    }
}
