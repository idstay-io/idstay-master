package idstay.common.util;

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
}
