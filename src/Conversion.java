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


    public String getDayOfWeekName(Integer dayOfWeek){

           switch (dayOfWeek){

               case 1:
                   return "Sun";
               case 2:
                   return "Mon";
               case 3:
                   return "Tue";
               case 4:
                   return "Wed";
               case 5:
                   return "Thu";
               case 6:
                   return "Fri";
               case 7:
                   return "Sat";

               default:
                   return "ERROR";

           }

    }

}
