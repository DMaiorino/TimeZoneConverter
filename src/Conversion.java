import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/17/13
 * Time: 11:44 PM
 * A simple app for converting time.
 */
public class Conversion {

    public Calendar getNewTime(Calendar baseDate, String newTimezone){

        Calendar newCalendar = Calendar.getInstance(TimeZone.getTimeZone(newTimezone));
        newCalendar.setTimeInMillis(baseDate.getTimeInMillis());

        return newCalendar;

    }


}
