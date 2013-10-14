import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.*;

import java.util.Calendar;
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
        mainPanel.add(button, c);


        //Setup the Frame
        frame = new Frame("Timezone Converter");
        frame.getContentPane().add(mainPanel);
        frame.pack();

    }



}