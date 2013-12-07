package OpenTimeZoneConverter.dmaiorino.com;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/12/13
 * Time: 1:12 PM
 * A simple app for converting time.
 */
public class Panel extends JPanel{

    //The JPanel to be returned
    JPanel leftPanel;
    JPanel rightPanel;

    //Border
    TitledBorder leftTitleBorder;
    TitledBorder rightTitleBorder;

    //Base Components
    JXDatePicker baseDatePicker;
    JComboBox<String> baseTimezoneBox;
    JSpinner baseTimeSpinner;

    //New Components
    JComboBox<String> newTimezoneBox;
    static String header;
    JLabel newDateLabel;
    JLabel newTimeLabel;

    // Convert on/off switch
    static Boolean activeSwitch;

    public Panel(){
        setup();
    }

    public void setup(){

        setLayout(new GridBagLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //Configure Borders
        leftTitleBorder = BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Current Time");
        leftPanel.setBorder(leftTitleBorder);
        rightTitleBorder = BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "New Time");
        rightPanel.setBorder(rightTitleBorder);

        //Setting my constraints here
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,0);
        c.weightx = 0.5;
        c.weighty = 0.5;

        //Add the base time components
        baseTimezoneBox = new JComboBox<String>();
        baseTimezoneBox.addActionListener(new converterAction());
        c.gridx = 0;
        c.gridy = 0;
        leftPanel.add(baseTimezoneBox, c);

        baseDatePicker = new JXDatePicker();
        baseDatePicker.setDate(Calendar.getInstance().getTime());
        baseDatePicker.addActionListener(new converterAction());
        baseDatePicker.setFont(new Font("Times New Roman", Font.BOLD, 20));
        JFormattedTextField tf = baseDatePicker.getEditor();
        tf.setHorizontalAlignment(JFormattedTextField.CENTER);
        c.gridy = 1;
        leftPanel.add(baseDatePicker, c);

        baseTimeSpinner = new JSpinner(new SpinnerDateModel());
        baseTimeSpinner.setEditor(new JSpinner.DateEditor(baseTimeSpinner, "HH:mm"));
        baseTimeSpinner.setFont(new Font("Times New Roman", Font.BOLD, 20));
        baseTimeSpinner.addChangeListener(new converterChange());
        tf = ((JSpinner.DefaultEditor) baseTimeSpinner.getEditor()).getTextField() ;
        tf.setHorizontalAlignment(JFormattedTextField.CENTER);
        c.gridy = 2;
        leftPanel.add(baseTimeSpinner, c);


        //Add the new time components
        newTimezoneBox = new JComboBox<String>();
        //newTimezoneBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        newTimezoneBox.addActionListener(new converterAction());
        c.insets = new Insets(0,5,0,5);
        c.gridx = 0;
        c.gridy = 0;
        rightPanel.add(newTimezoneBox, c);

        newDateLabel = new JLabel("Sun 01/01/1970", SwingConstants.CENTER);
        newDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        c.gridy = 1;
        rightPanel.add(newDateLabel, c);

        newTimeLabel = new JLabel("00:00", SwingConstants.CENTER);
        newTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c.gridy = 2;
        rightPanel.add(newTimeLabel, c);

        //Add sub panels to main panel
        c.gridx = 0;
        c.gridy = 0;
        add(leftPanel, c);
        c.gridx = 1;
        add(rightPanel, c);

        //Set String header to default
        header = "";

    }

    public void convertTime(){

        Conversion theConverter = new Conversion();

        // Splitting action to get hour and minute from the Spinner
        String[] fullTime = baseTimeSpinner.getValue().toString().split(" ");
        String[] baseTime = fullTime[3].split(":");
        Integer baseHour = Integer.parseInt(baseTime[0]);
        Integer baseMinute = Integer.parseInt(baseTime[1]);

        // Splitting action to get month, day, and year.
        String[] fullDate = baseDatePicker.getDate().toString().split(" ");
        Integer baseYear = Integer.parseInt(fullDate[5]);
        Integer baseDay = Integer.parseInt(fullDate[2]);
        Integer baseMonth = baseDatePicker.getDate().getMonth(); //Have to return a int, using deprecated date method :(

        // Set the base date, which will be changed to the new time
        Calendar baseDate = new GregorianCalendar(TimeZone.getTimeZone( header + baseTimezoneBox.getSelectedItem().toString()));
        baseDate.set(baseYear, baseMonth, baseDay, baseHour, baseMinute);

        // Make Conversion Calls Here
        Calendar newTime = theConverter.getNewTime(baseDate, header + newTimezoneBox.getSelectedItem().toString());

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

    public JComboBox<String> getBaseTimezoneBox(){
        return  baseTimezoneBox;
    }

    public JComboBox<String> getNewTimezoneBox(){
        return  newTimezoneBox;
    }

    public JXDatePicker getBaseDatePicker(){
        return baseDatePicker;
    }

    public JSpinner getBaseTimeSpinner(){
        return baseTimeSpinner;
    }

    public static void setTimezoneheader(String newHeader){
        header = newHeader;
    }

    public class converterAction implements ActionListener {

        public void actionPerformed(ActionEvent a){
            if (activeSwitch){
                convertTime();
            }
        }
    }

    public class converterChange implements ChangeListener {
        public void stateChanged(ChangeEvent a){
            if (activeSwitch){
                convertTime();
            }
        }
    }

    public static void turnOnActiveSwitch(){
        activeSwitch = true;
    }

    public static void turnOffActiveSwitch(){
        activeSwitch = false;
    }

}
