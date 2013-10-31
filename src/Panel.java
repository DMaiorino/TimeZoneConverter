import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/12/13
 * Time: 1:12 PM
 * A simple app for converting time.
 */
public class Panel{

    //The JPanel to be returned
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

    // Convert Button
    JButton button;


    public Panel(){
        setup();
    }

    public void setup(){

        mainPanel = new JPanel();

        mainPanel.setLayout(new GridBagLayout());

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

        baseTimezoneBox = new JComboBox();
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

        newTimezoneBox = new JComboBox();
        c.gridy = 1;
        mainPanel.add(newTimezoneBox, c);

        newDateLabel = new JLabel("Sun 01/01/1970", SwingConstants.CENTER);
        newDateLabel.setFont(new Font("Times New Roman", 0, 18));
        c.gridy = 2;
        mainPanel.add(newDateLabel, c);

        newTimeLabel = new JLabel("00:00", SwingConstants.CENTER);
        newTimeLabel.setFont(new Font("Times New Roman", 0, 18));
        c.gridy = 3;
        mainPanel.add(newTimeLabel, c);

        //Add bottom button
        button = new JButton("Convert");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        button.addActionListener(new converterAction());
        mainPanel.add(button, c);

    }

    public void convertTime(){

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

        newTimeLabel.setText(hour.toString() + ":" + minute);


        //Set the new date label
        Integer day = newTime.get(Calendar.DAY_OF_MONTH);
        Integer dayOfWeek = newTime.get(Calendar.DAY_OF_WEEK);
        String nameDayOfWeek = theConverter.getDayOfWeekName(dayOfWeek);
        Integer month = newTime.get(Calendar.MONTH) + 1; //Add one as months start with 0
        Integer year = newTime.get(Calendar.YEAR);

        newDateLabel.setText(nameDayOfWeek + " " + month + "/" + day + "/" + year);

    }

    public JPanel getPanel(){
        return  mainPanel;
    }

    public JComboBox getBaseTimezoneBox(){
        return  baseTimezoneBox;
    }

    public JComboBox getNewTimezoneBox(){
        return  newTimezoneBox;
    }

    public class converterAction implements ActionListener {

        public void actionPerformed(ActionEvent a){
            convertTime();
        }

    }

}
