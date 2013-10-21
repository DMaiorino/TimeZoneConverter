import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/5/13
 * Time: 5:45 PM
 * A simple app for converting time.
 */

public class GUI {

    // Need to classify
    JButton button;

    //Window
    JFrame frame;
    JPanel mainPanel;

    //Base Components
    JXDatePicker baseDatePicker;
    JComboBox baseTimezoneBox;
    JLabel baseLabel;
    JSpinner baseTimeSpinner;

    //New Components
    JComboBox newTimezoneBox;
    JLabel newLabel;
    JLabel newDateLabel;
    JLabel newTimeLabel;

    //Time Info
    String currentTZ = Calendar.getInstance().getTimeZone().getID();
    String[] timezoneList = {"Africa/Algiers", "Africa/Cairo", "Africa/Casablanca", "Africa/Harare", "Africa/Nairobi", "Africa/Windhoek", "America/Bogota", "America/Buenos_Aires", "America/Caracas", "America/Chihuahua", "America/Guatemala", "America/Mexico_City", "America/Montevideo", "America/Santiago", "America/Tijuana", "Asia/Amman", "Asia/Baghdad", "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Calcutta", "Asia/Colombo", "Asia/Dhaka", "Asia/Hong_Kong", "Asia/Irkutsk", "Asia/Jerusalem", "Asia/Kabul", "Asia/Karachi", "Asia/Katmandu", "Asia/Krasnoyarsk", "Asia/Kuala_Lumpur", "Asia/Kuwait", "Asia/Magadan", "Asia/Muscat", "Asia/Novosibirsk", "Asia/Rangoon", "Asia/Seoul", "Asia/Taipei", "Asia/Tbilisi", "Asia/Tehran", "Asia/Tokyo", "Asia/Vladivostok", "Asia/Yakutsk", "Asia/Yekaterinburg", "Asia/Yerevan", "Atlantic/Azores", "Atlantic/Cape_Verde", "Australia/Adelaide", "Australia/Brisbane", "Australia/Darwin", "Australia/Hobart", "Australia/Perth", "Australia/Sydney", "Brazil/East", "Canada/Eastern", "Canada/Newfoundland", "Canada/Saskatchewan", "Europe/Athens", "Europe/Belgrade", "Europe/Berlin", "Europe/Brussels", "Europe/Helsinki", "Europe/London", "Europe/Minsk", "Europe/Moscow", "Europe/Paris", "Europe/Warsaw", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Guam", "Pacific/Midway", "US/Alaska", "US/Arizona", "US/Central", "US/East-Indiana", "US/Eastern", "US/Hawaii", "US/Mountain", "US/Pacific", "UTC"} ;


    public void start(){


        mainPanel = new Panel();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0,10,0,10);
        c.weightx = 0.5;
        c.weighty = 0.5;

        //Add the base time components
        baseLabel = new JLabel("Current Time", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(baseLabel, c);

        baseTimezoneBox = new JComboBox(timezoneList);
        baseTimezoneBox.setSelectedItem(currentTZ);
        c.gridy = 1;
        mainPanel.add(baseTimezoneBox, c);

        baseDatePicker = new JXDatePicker();
        baseDatePicker.setDate(Calendar.getInstance().getTime());
        c.gridy = 2;
        mainPanel.add(baseDatePicker, c);

        baseTimeSpinner = new JSpinner(new SpinnerDateModel());
        baseTimeSpinner.setEditor(new JSpinner.DateEditor(baseTimeSpinner, "HH:mm"));
        c.gridy = 3;
        mainPanel.add(baseTimeSpinner, c);


        //Add the new time components
        newLabel = new JLabel("New Time", SwingConstants.CENTER);
        c.gridx = 1; //Move to next column
        c.gridy = 0;
        mainPanel.add(newLabel, c);

        newTimezoneBox = new JComboBox(timezoneList);
        newTimezoneBox.setSelectedItem("UTC");
        c.gridy = 1;
        mainPanel.add(newTimezoneBox, c);

        newDateLabel = new JLabel("Sun 01/01/1970", SwingConstants.CENTER);
        newDateLabel.setFont(new Font("Times New Roman", 0, 24));
        c.gridy = 2;
        mainPanel.add(newDateLabel, c);

        newTimeLabel = new JLabel("00:00", SwingConstants.CENTER);
        newTimeLabel.setFont(new Font("Times New Roman", 0, 24));
        c.gridy = 3;
        mainPanel.add(newTimeLabel, c);

        //Add bottom button
        button = new JButton("Convert");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        button.addActionListener(new converter());
        mainPanel.add(button, c);


        //Setup the Frame
        frame = new Frame("Timezone Converter");
        frame.getContentPane().add(mainPanel);
        frame.pack();
    }

    public class converter implements ActionListener{


        public void actionPerformed(ActionEvent a){

            Conversion theConverter = new Conversion();

            // Splitting action to get hour and minute from the Spinner
            String[] fullTime = baseTimeSpinner.getValue().toString().split(" ");
            String[] baseTime = fullTime[3].toString().split(":");
            Integer baseHour = Integer.parseInt(baseTime[0]);
            Integer baseMinute = Integer.parseInt(baseTime[1]);

            // Splitting action to get month, day, and year.
            String[] fullDate = baseDatePicker.getDate().toString().split(" ");
            Integer baseYear = Integer.parseInt(fullDate[5]);
            Integer baseDay = Integer.parseInt(fullDate[2]);
            Integer baseMonth = baseDatePicker.getDate().getMonth(); //Have to return a int, using deprecated date method :(

            // Set the base date, which will be converted to the new time
            Calendar baseDate = new GregorianCalendar(TimeZone.getTimeZone(baseTimezoneBox.getSelectedItem().toString()));
            baseDate.set(baseYear, baseMonth, baseDay, baseHour, baseMinute);

            // Make Conversion Calls Here
            Calendar newTime = theConverter.getNewTime(baseDate, newTimezoneBox.getSelectedItem().toString());

            //Set the new time label
            Integer hour = newTime.get(Calendar.HOUR_OF_DAY);
            Integer numMinute = newTime.get(Calendar.MINUTE);

            //Since minute may return a single digit, add a 0 if it is single.
            String minute = numMinute.toString();
            if (minute.length() == 1){
                minute = "0" + minute ;
            }

            newTimeLabel.setText(hour.toString() + ":" + minute.toString());


            //Set the new date label
            Integer day = newTime.get(Calendar.DAY_OF_MONTH);
            Integer dayOfWeek = newTime.get(Calendar.DAY_OF_WEEK);
            String nameDayOfWeek = theConverter.getDayOfWeekName(dayOfWeek);
            Integer month = newTime.get(Calendar.MONTH) + 1; //Add one as months start with 0
            Integer year = newTime.get(Calendar.YEAR);

            newDateLabel.setText(nameDayOfWeek + " " + month + "/" + day + "/" + year);

        }

    }



}
