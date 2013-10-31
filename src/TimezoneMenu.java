import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/30/13
 * Time: 9:45 PM
 * A simple app for converting time.
 */
public class TimezoneMenu {

    //Menu Components
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem standardTimezone;
    JRadioButtonMenuItem allTimezone;
    ItemListener standardListener;
    ItemListener allListener;


    //Time Info
    String currentTZ = Calendar.getInstance().getTimeZone().getID();
    String[] allTimezoneList  = TimeZone.getAvailableIDs();
    String[] standardTimezoneList = {"Africa/Algiers", "Africa/Cairo", "Africa/Casablanca", "Africa/Harare", "Africa/Nairobi", "Africa/Windhoek", "America/Bogota", "America/Buenos_Aires", "America/Caracas", "America/Chihuahua", "America/Guatemala", "America/Mexico_City", "America/Montevideo", "America/Santiago", "America/Tijuana", "Asia/Amman", "Asia/Baghdad", "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Calcutta", "Asia/Colombo", "Asia/Dhaka", "Asia/Hong_Kong", "Asia/Irkutsk", "Asia/Jerusalem", "Asia/Kabul", "Asia/Karachi", "Asia/Katmandu", "Asia/Krasnoyarsk", "Asia/Kuala_Lumpur", "Asia/Kuwait", "Asia/Magadan", "Asia/Muscat", "Asia/Novosibirsk", "Asia/Rangoon", "Asia/Seoul", "Asia/Taipei", "Asia/Tbilisi", "Asia/Tehran", "Asia/Tokyo", "Asia/Vladivostok", "Asia/Yakutsk", "Asia/Yekaterinburg", "Asia/Yerevan", "Atlantic/Azores", "Atlantic/Cape_Verde", "Australia/Adelaide", "Australia/Brisbane", "Australia/Darwin", "Australia/Hobart", "Australia/Perth", "Australia/Sydney", "Brazil/East", "Canada/Eastern", "Canada/Newfoundland", "Canada/Saskatchewan", "Europe/Athens", "Europe/Belgrade", "Europe/Berlin", "Europe/Brussels", "Europe/Helsinki", "Europe/London", "Europe/Minsk", "Europe/Moscow", "Europe/Paris", "Europe/Warsaw", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Guam", "Pacific/Midway", "US/Alaska", "US/Arizona", "US/Central", "US/East-Indiana", "US/Eastern", "US/Hawaii", "US/Mountain", "US/Pacific", "UTC"} ;

    //JCombo boxes for Timezone
    final JComboBox baseTimezoneBox;
    final JComboBox newTimezoneBox;

    public TimezoneMenu(JComboBox baseTimezoneBox, JComboBox newTimezoneBox){
        this.baseTimezoneBox = baseTimezoneBox;
        this.newTimezoneBox = newTimezoneBox;
        createMenuBar();
    }

    public void createMenuBar() {

        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        standardListener = new standardListener();
        allListener = new allListener();

        //a group of check box menu items
        standardTimezone = new JRadioButtonMenuItem("Regular Timezone");
        standardTimezone.setMnemonic(KeyEvent.VK_S);
        standardTimezone.addItemListener(standardListener);
        menu.add(standardTimezone);

        allTimezone = new JRadioButtonMenuItem("All Timezone");
        allTimezone.setMnemonic(KeyEvent.VK_A);
        allTimezone.addItemListener(allListener);
        menu.add(allTimezone);

        menuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new quitListener());

        menu.addSeparator();
        menu.add(menuItem);
        standardTimezone.setSelected(true);
        menuBar.add(menu);

    }

    public void setTimezoneList(String[] timezoneList){

        Arrays.sort(timezoneList);

        baseTimezoneBox.removeAllItems();
        newTimezoneBox.removeAllItems();
        for (String tz : timezoneList){
            baseTimezoneBox.addItem(tz);
            newTimezoneBox.addItem(tz);
        }

        baseTimezoneBox.setSelectedItem(currentTZ);
        newTimezoneBox.setSelectedItem("UTC");

    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

    public String[] getStandardTimezoneList(){
        return  standardTimezoneList;
    }

    public class quitListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    public class allListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            if (standardTimezone.isSelected()){
                standardTimezone.removeItemListener(standardListener);
                standardTimezone.setSelected(false);
                standardTimezone.addItemListener(standardListener);
            }
            setTimezoneList(allTimezoneList);
        }
    }

    public class standardListener implements ItemListener{
        public  void itemStateChanged(ItemEvent e){
            if (allTimezone.isSelected()){
                allTimezone.removeItemListener(allListener);
                allTimezone.setSelected(false);
                allTimezone.addItemListener(allListener);
            }
            setTimezoneList(standardTimezoneList);
        }
    }

}
