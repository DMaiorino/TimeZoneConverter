package OpenTimeZoneConverter.dmaiorino.com;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.prefs.Preferences;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/30/13
 * Time: 9:45 PM
 * A simple app for converting time.
 */
public class TimezoneMenu {


    //Panel
    Panel myPanel;

    //Menu Components
    private JMenuBar menuBar;
    private JRadioButtonMenuItem standardTimezone, allTimezone, africaTimezone, americaTimezone, asiaTimezone, australiaTimezone, europeTimezone, pacificTimezone, usTimezone;


    //Item Listeners
    private ItemListener standardListener;
    private ItemListener allListener;
    private ItemListener africaListener;
    private ItemListener americaListener;
    private ItemListener asiaListener;
    private ItemListener australiaListener;
    private ItemListener europeListener;
    private ItemListener pacificListener;
    private ItemListener usListener;


    //Time Info
    String[] allTimezoneList = TimeZone.getAvailableIDs();
    String[] standardTimezoneList = {"Africa/Algiers", "Africa/Cairo", "Africa/Casablanca", "Africa/Harare", "Africa/Nairobi", "Africa/Windhoek", "America/Bogota", "America/Buenos_Aires", "America/Caracas", "America/Chihuahua", "America/Guatemala", "America/Mexico_City", "America/Montevideo", "America/Santiago", "America/Tijuana", "Asia/Amman", "Asia/Baghdad", "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Calcutta", "Asia/Colombo", "Asia/Dhaka", "Asia/Hong_Kong", "Asia/Irkutsk", "Asia/Jerusalem", "Asia/Kabul", "Asia/Karachi", "Asia/Katmandu", "Asia/Krasnoyarsk", "Asia/Kuala_Lumpur", "Asia/Kuwait", "Asia/Magadan", "Asia/Muscat", "Asia/Novosibirsk", "Asia/Rangoon", "Asia/Seoul", "Asia/Shanghai", "Asia/Taipei", "Asia/Tbilisi", "Asia/Tehran", "Asia/Tokyo", "Asia/Vladivostok", "Asia/Yakutsk", "Asia/Yekaterinburg", "Asia/Yerevan", "Atlantic/Azores", "Atlantic/Cape_Verde", "Australia/Adelaide", "Australia/Brisbane", "Australia/Darwin", "Australia/Hobart", "Australia/Perth", "Australia/Sydney", "Brazil/East", "Canada/Eastern", "Canada/Newfoundland", "Canada/Saskatchewan", "Europe/Athens", "Europe/Belgrade", "Europe/Berlin", "Europe/Brussels", "Europe/Helsinki", "Europe/London", "Europe/Minsk", "Europe/Moscow", "Europe/Paris", "Europe/Warsaw", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Guam", "Pacific/Midway", "US/Alaska", "US/Arizona", "US/Central", "US/East-Indiana", "US/Eastern", "US/Hawaii", "US/Mountain", "US/Pacific", "UTC"};
    String[] africaTimezoneList = {"Abidjan", "Accra", "Addis_Ababa", "Algiers", "Asmera", "Bamako", "Bangui", "Banjul", "Bissau", "Blantyre", "Brazzaville", "Bujumbura", "Cairo", "Casablanca", "Ceuta", "Conakry", "Dakar", "Dar_es_Salaam", "Djibouti", "Douala", "El_Aaiun", "Freetown", "Gaborone", "Harare", "Johannesburg", "Kampala", "Khartoum", "Kigali", "Kinshasa", "Lagos", "Libreville", "Lome", "Luanda", "Lubumbashi", "Lusaka", "Malabo", "Maputo", "Maseru", "Mbabane", "Mogadishu", "Monrovia", "Nairobi", "Ndjamena", "Niamey", "Nouakchott", "Ouagadougou", "Porto-Novo", "Sao_Tome", "Timbuktu", "Tripoli", "Tunis", "Windhoek"};
    String[] americaTimezoneList = {"Belize", "Boa_Vista", "Bogota", "Boise", "Buenos_Aires", "Cambridge_Bay", "Campo_Grande", "Cancun", "Caracas", "Catamarca", "Cayenne", "Cayman", "Chicago", "Chihuahua", "Cordoba", "Costa_Rica", "Cuiaba", "Curacao", "Danmarkshavn", "Dawson", "Dawson_Creek", "Denver", "Detroit", "Dominica", "Edmonton", "Eirunepe", "El_Salvador", "Ensenada", "Fort_Wayne", "Fortaleza", "Glace_Bay", "Godthab", "Goose_Bay", "Grand_Turk", "Grenada", "Guadeloupe", "Guatemala", "Guayaquil", "Guyana", "Halifax", "Havana", "Hermosillo", "Indiana/Indianapolis", "Indiana/Knox", "Indiana/Marengo", "Indiana/Vevay", "Indianapolis", "Inuvik", "Iqaluit", "Jamaica", "Jujuy", "Juneau", "Kentucky/Louisville", "Kentucky/Monticello", "Knox_IN", "La_Paz", "Lima", "Los_Angeles", "Louisville", "Maceio", "Managua", "Manaus", "Martinique", "Mazatlan", "Mendoza", "Menominee", "Merida", "Mexico_City", "Miquelon", "Monterrey", "Montevideo", "Montreal", "Montserrat", "Nassau", "New_York", "Nipigon", "Nome", "Noronha", "North_Dakota/Center", "Panama", "Pangnirtung", "Paramaribo", "Phoenix", "Port_of_Spain", "Port-au-Prince", "Porto_Acre", "Porto_Velho", "Puerto_Rico", "Rainy_River", "Rankin_Inlet", "Recife", "Regina", "Rio_Branco", "Rosario", "Santiago", "Santo_Domingo", "Sao_Paulo", "Scoresbysund", "Shiprock", "St_Johns", "St_Kitts", "St_Lucia", "St_Thomas", "St_Vincent", "Swift_Current", "Tegucigalpa", "Thule", "Thunder_Bay", "Tijuana", "Toronto", "Tortola", "Vancouver", "Virgin", "Whitehorse", "Winnipeg", "Yakutat", "Yellowknife"};
    String[] asiaTimezoneList = {"Aden", "Almaty", "Amman", "Anadyr", "Aqtau", "Aqtobe", "Ashgabat", "Ashkhabad", "Baghdad", "Bahrain", "Baku", "Bangkok", "Beirut", "Bishkek", "Brunei", "Calcutta", "Choibalsan", "Chongqing", "Chungking", "Colombo", "Dacca", "Damascus", "Dhaka", "Dili", "Dubai", "Dushanbe", "Gaza", "Harbin", "Hong_Kong", "Hovd", "Irkutsk", "Istanbul", "Jakarta", "Jayapura", "Jerusalem", "Kabul", "Kamchatka", "Karachi", "Kashgar", "Katmandu", "Krasnoyarsk", "Kuala_Lumpur", "Kuching", "Kuwait", "Macao", "Macau", "Magadan", "Makassar", "Manila", "Muscat", "Nicosia", "Novosibirsk", "Omsk", "Oral", "Phnom_Penh", "Pontianak", "Pyongyang", "Qatar", "Qyzylorda", "Rangoon", "Riyadh", "Riyadh87", "Riyadh88", "Riyadh89", "Saigon", "Sakhalin", "Samarkand", "Seoul", "Shanghai", "Singapore", "Taipei", "Tashkent", "Tbilisi", "Tehran", "Tel_Aviv", "Thimbu", "Thimphu", "Tokyo", "Ujung_Pandang", "Ulaanbaatar", "Ulan_Bator", "Urumqi", "Vientiane", "Vladivostok", "Yakutsk", "Yekaterinburg", "Yerevan"};
    String[] australiaTimezoneList = {"ACT", "Adelaide", "Brisbane", "Broken_Hill", "Canberra", "Darwin", "Hobart", "LHI", "Lindeman", "Lord_Howe", "Melbourne", "North", "NSW", "Perth", "Queensland", "South", "Sydney", "Tasmania", "Victoria", "West", "Yancowinna"};
    String[] europeTimezoneList = {"Amsterdam", "Andorra", "Athens", "Belfast", "Belgrade", "Berlin", "Bratislava", "Brussels", "Bucharest", "Budapest", "Chisinau", "Copenhagen", "Dublin", "Gibraltar", "Helsinki", "Istanbul", "Kaliningrad", "Kiev", "Lisbon", "Ljubljana", "London", "Luxembourg", "Madrid", "Malta", "Minsk", "Monaco", "Moscow", "Nicosia", "Oslo", "Paris", "Prague", "Riga", "Rome", "Samara", "San_Marino", "Sarajevo", "Simferopol", "Skopje", "Sofia", "Stockholm", "Tallinn", "Tirane", "Tiraspol", "Uzhgorod", "Vaduz", "Vatican", "Vienna", "Vilnius", "Warsaw", "Zagreb", "Zaporozhye", "Zurich"};
    String[] pacificTimezoneList = {"Apia", "Auckland", "Chatham", "Easter", "Efate", "Enderbury", "Fakaofo", "Fiji", "Funafuti", "Galapagos", "Gambier", "Guadalcanal", "Guam", "Honolulu", "Johnston", "Kiritimati ", "Kosrae", "Kwajalein", "Majuro", "Marquesas", "Midway", "Nauru", "Niue", "Norfolk", "Noumea", "Pago_Pago", "Palau", "Pitcairn", "Ponape", "Port_Moresby", "Rarotonga", "Saipan", "Samoa", "Tahiti", "Tarawa", "Tongatapu", "Truk", "Wake", "Wallis", "Yap"};
    String[] usTimezoneList = {"Alaska", "Aleutian", "Arizona", "Central", "East-Indiana", "Eastern", "Hawaii", "Indiana-Starke", "Michigan", "Mountain", "Pacific", "Pacific-New", "Samoa"};

    //JCombo boxes for Timezone
    final JComboBox<String> baseTimezoneBox;
    JComboBox<String> newTimezoneBox;

    //Base components
    final JXDatePicker baseDatePicker;
    final JSpinner baseTimeSpinner;


    Preferences preferences = Preferences.userNodeForPackage(TimezoneMenu.class);

    public TimezoneMenu(JComboBox<String> baseTimezoneBox, JComboBox<String> newTimezoneBox, JXDatePicker baseDatePicker, JSpinner baseTimeSpinner) {
        this.baseTimezoneBox = baseTimezoneBox;
        this.newTimezoneBox = newTimezoneBox;
        this.baseDatePicker = baseDatePicker;
        this.baseTimeSpinner = baseTimeSpinner;
        createMenuBar();
    }

    public void createMenuBar() {

        JMenu menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        standardListener = new standardListener();
        allListener = new allListener();
        africaListener = new africaListener();
        americaListener = new americaListener();
        asiaListener = new asiaListener();
        australiaListener = new australiaListener();
        europeListener = new europeListener();
        pacificListener = new pacificListener();
        usListener = new usListener();

        //Main  Menu
        JMenuItem saveItem = new JMenuItem("Save", KeyEvent.VK_Q); //Save function
        JMenuItem restoreItem = new JMenuItem("Restore", KeyEvent.VK_R); //Restore function
        JMenuItem menuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menuItem.addActionListener(new quitListener());

        saveItem.addActionListener(new saveListener());
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        restoreItem.addActionListener(new restoreListener());
        restoreItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));

        menu.add(saveItem);
        menu.add(restoreItem);
        menu.addSeparator();
        menu.add(menuItem);

        //TimezoneMenu Bar
        JMenu timezoneMenu = new JMenu("Timezone");
        timezoneMenu.setMnemonic(KeyEvent.VK_R);
        JMenu regionMenu = new JMenu("Region");
        regionMenu.setMnemonic(KeyEvent.VK_R);

        standardTimezone = new JRadioButtonMenuItem("Regular_Timezone");
        standardTimezone.setMnemonic(KeyEvent.VK_S);
        standardTimezone.addItemListener(standardListener);
        timezoneMenu.add(standardTimezone);

        allTimezone = new JRadioButtonMenuItem("All_Timezone");
        allTimezone.setMnemonic(KeyEvent.VK_A);
        allTimezone.addItemListener(allListener);
        timezoneMenu.add(allTimezone);

        africaTimezone = new JRadioButtonMenuItem("Africa");
        africaTimezone.addItemListener(africaListener);
        regionMenu.add(africaTimezone);

        americaTimezone = new JRadioButtonMenuItem("America");
        americaTimezone.addItemListener(americaListener);
        regionMenu.add(americaTimezone);

        asiaTimezone = new JRadioButtonMenuItem("Asia");
        asiaTimezone.addItemListener(asiaListener);
        regionMenu.add(asiaTimezone);

        australiaTimezone = new JRadioButtonMenuItem("Australia");
        australiaTimezone.addItemListener(australiaListener);
        regionMenu.add(australiaTimezone);

        europeTimezone = new JRadioButtonMenuItem("Europe");
        europeTimezone.addItemListener(europeListener);
        regionMenu.add(europeTimezone);

        pacificTimezone = new JRadioButtonMenuItem("Pacific");
        pacificTimezone.addItemListener(pacificListener);
        regionMenu.add(pacificTimezone);

        usTimezone = new JRadioButtonMenuItem("US");
        usTimezone.addItemListener(usListener);
        regionMenu.add(usTimezone);

        timezoneMenu.add(regionMenu);


        //Add Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new aboutListener());

        helpMenu.add(aboutItem);

        //Add menus to the menu bar
        standardTimezone.setSelected(true);
        menuBar.add(menu);
        menuBar.add(timezoneMenu);
        menuBar.add(helpMenu);

        myPanel = new Panel();

    }

    public void setTimezoneList(String[] timezoneList) {

        Arrays.sort(timezoneList);

        //We need to turn off the converterAction, so that we can update the timezone boxes
        Panel.turnOffActiveSwitch();

        baseTimezoneBox.removeAllItems();
        newTimezoneBox.removeAllItems();


        for (String tz : timezoneList) {
            baseTimezoneBox.addItem(tz);
            newTimezoneBox.addItem(tz);
        }

        //We will update with the save times if they match the current timezone region.
        String defaultTimezone = "UTC"; //In case no value is returned
        baseTimezoneBox.setSelectedItem(preferences.get("baseTimezoneBox", defaultTimezone));
        newTimezoneBox.setSelectedItem(preferences.get("newTimezoneBox", defaultTimezone));

        //Turn converterAction back on.
        Panel.turnOnActiveSwitch();


    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public String[] getStandardTimezoneList() {
        return standardTimezoneList;
    }

    public void deselectItems() {
        standardTimezone.setSelected(false);
        allTimezone.setSelected(false);
        africaTimezone.setSelected(false);
        americaTimezone.setSelected(false);
        asiaTimezone.setSelected(false);
        australiaTimezone.setSelected(false);
        europeTimezone.setSelected(false);
        pacificTimezone.setSelected(false);
        usTimezone.setSelected(false);
    }

    public class saveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           savePanel();
        }
    }


    private void savePanel(){

        JRadioButtonMenuItem saveTZ = getSelectedTimezone();

        preferences.put("baseTimezoneBox", baseTimezoneBox.getSelectedItem().toString() );
        preferences.put("newTimezoneBox", newTimezoneBox.getSelectedItem().toString() );


        try {

            // Save the Timezone region menu item.
            XMLEncoder xmlEncoderTzRegion = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("OpenTimeZoneConverter/dmaiorino/com/save.xml")));
            xmlEncoderTzRegion.writeObject(saveTZ);
            xmlEncoderTzRegion.writeObject(baseDatePicker);
            xmlEncoderTzRegion.writeObject(baseTimeSpinner);
            xmlEncoderTzRegion.close();
        }catch (IOException io){
            System.err.println("FileNotFoundException: " + io.getMessage());
        }
    }

    public class restoreListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            restorePanel();
        }
    }

    private void restorePanel(){

        JRadioButtonMenuItem restoreTZ;
        JXDatePicker restoredBaseDatePicker;
        JSpinner restoredBaseTimeSpinner;

        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("OpenTimeZoneConverter/dmaiorino/com/save.xml")));

            //Get saved timezone
            Object objectTZ = xmlDecoder.readObject();
            restoreTZ = (JRadioButtonMenuItem)objectTZ;

            //Get saved date
            Object objectBaseDatePicker = xmlDecoder.readObject();
            restoredBaseDatePicker = (JXDatePicker)objectBaseDatePicker;

            //Get saved time
            Object objectBaseTimeSpinner = xmlDecoder.readObject();
            restoredBaseTimeSpinner = (JSpinner)objectBaseTimeSpinner;

            //Set panel components with restored values.
            baseTimeSpinner.setValue(restoredBaseTimeSpinner.getValue());
            baseDatePicker.setDate(restoredBaseDatePicker.getDate());
            setSelectedTimezone(restoreTZ.getText());

            //OK, I'm done. Let's close this guy out.
            xmlDecoder.close();
        }catch (IOException io){
            System.err.println("FileNotFoundException: " + io.getMessage());
        }

    }

    public class quitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class aboutListener implements ActionListener {

        JFrame aboutWindow;

        public void actionPerformed(ActionEvent e) {


            JTextPane aboutText = new JTextPane();
            JButton exitButton = new JButton("Exit");
            Border blackline = BorderFactory.createLineBorder(Color.black);

            //Setup the Window. We need to add the components here, as these will be static.
            aboutWindow = new JFrame("About Open Time Zone Converter");
            aboutWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            aboutWindow.setLayout(null);
            aboutWindow.getContentPane().add(exitButton);
            aboutWindow.getContentPane().add(aboutText);


            //Top Text area
            Insets insets = aboutWindow.getInsets();
            aboutText.setBackground(null);
            aboutText.setEditable(false);
            aboutText.setOpaque(false);
            aboutText.setBorder(blackline);
            aboutText.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
            aboutText.setText("<b><center>Open Time Zone Converter</center></b><br>Version: 1.0.0<br><br>A small open app for converting the time across time zones.<br><br>Have any ideas? Fork me on <a href=\"https://github.com/DMaiorino/TimeZoneConverter\">GitHub</a>!<br><br>This program comes with <b>ABSOLUTELY NO WARRANTY</b>.<br>For details, visit <a href=\"http://opensource.org/licenses/MIT\">http://opensource.org/licenses/MIT/<a><br>");
            aboutText.setText("<center>Created by: David Maiorino<br><br>Icon designed by: Alexander Moore</center>");
            aboutText.setBackground(null);
            Dimension size = aboutText.getPreferredSize();
            aboutText.setBounds(5 + insets.left, insets.top, size.width, size.height);

            //This listener will allow  for the user to click the hyperlink
            aboutText.addHyperlinkListener(new HyperlinkListener() {
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        if (Desktop.isDesktopSupported()) {
                            try {
                                Desktop.getDesktop().browse(e.getURL().toURI());
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            } catch (URISyntaxException urie) {
                                urie.printStackTrace();
                            }
                        }
                    }
                }
            });

            //Bottom button setup
            size = exitButton.getPreferredSize();
            exitButton.setBounds(350 + insets.left, 185 + insets.top, size.width, size.height);
            exitButton.addActionListener(new closeListener());

            //Wrap up the window settings
            aboutWindow.setSize(new Dimension(440,250));
            aboutWindow.setResizable(false);
            aboutWindow.setVisible(true);

        }

        class closeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                aboutWindow.dispose();
            }
        }
    }


    //Start defining listeners and their method
    public class standardListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForStandard();
        }
    }

    private void updateForStandard(){
        removeListeners();
        deselectItems();
        standardTimezone.setSelected(true);
        setTimezoneList(standardTimezoneList);
        addListeners();
    }

    public class allListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForAll();
        }
    }

    private void updateForAll(){
        removeListeners();
        deselectItems();
        allTimezone.setSelected(true);
        setTimezoneList(allTimezoneList);
        addListeners();
    }

    public class africaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForAfrica();
        }
    }

    private void updateForAfrica(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("Africa/");
        africaTimezone.setSelected(true);
        setTimezoneList(africaTimezoneList);
        addListeners();
    }

    public class americaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForAmerica();
        }
    }

    private void updateForAmerica(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("America/");
        americaTimezone.setSelected(true);
        setTimezoneList(americaTimezoneList);
        addListeners();
    }

    public class asiaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForAsia();
        }
    }

    private void updateForAsia(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("Asia/");
        asiaTimezone.setSelected(true);
        setTimezoneList(asiaTimezoneList);
        addListeners();
    }

    public class australiaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForAustralia();
        }
    }

    private void updateForAustralia(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("Australia/");
        australiaTimezone.setSelected(true);
        setTimezoneList(australiaTimezoneList);
        addListeners();
    }

    public class europeListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForEurope();
        }
    }

    private void updateForEurope(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("Europe/");
        europeTimezone.setSelected(true);
        setTimezoneList(europeTimezoneList);
        addListeners();
    }

    public class pacificListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForPacific();
        }
    }

    private void updateForPacific(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("Pacific/");
        pacificTimezone.setSelected(true);
        setTimezoneList(pacificTimezoneList);
        addListeners();
    }

    public class usListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateForUs();
        }
    }

    private void updateForUs(){
        removeListeners();
        deselectItems();
        Panel.setTimezoneheader("US/");
        usTimezone.setSelected(true);
        setTimezoneList(usTimezoneList);
        addListeners();
    }

    //We have to add and remove all listeners so that only the selected region will respond when clicked.
    public void removeListeners() {
        standardTimezone.removeItemListener(standardListener);
        allTimezone.removeItemListener(allListener);
        africaTimezone.removeItemListener(africaListener);
        americaTimezone.removeItemListener(americaListener);
        asiaTimezone.removeItemListener(asiaListener);
        australiaTimezone.removeItemListener(australiaListener);
        europeTimezone.removeItemListener(europeListener);
        pacificTimezone.removeItemListener(pacificListener);
        usTimezone.removeItemListener(usListener);
    }

    public void addListeners() {
        standardTimezone.addItemListener(standardListener);
        allTimezone.addItemListener(allListener);
        africaTimezone.addItemListener(africaListener);
        americaTimezone.addItemListener(americaListener);
        asiaTimezone.addItemListener(asiaListener);
        australiaTimezone.addItemListener(australiaListener);
        europeTimezone.addItemListener(europeListener);
        pacificTimezone.addItemListener(pacificListener);
        usTimezone.addItemListener(usListener);
    }

    public JRadioButtonMenuItem getSelectedTimezone(){

        if (standardTimezone.isSelected()){
            return  standardTimezone;
        }else if (allTimezone.isSelected()){
            return  allTimezone;
        }else if (africaTimezone.isSelected()){
            return africaTimezone;
        }else if (americaTimezone.isSelected()){
            return  americaTimezone;
        } else if (asiaTimezone.isSelected()){
            return asiaTimezone;
        } else if (australiaTimezone.isSelected()){
            return  australiaTimezone;
        } else if (europeTimezone.isSelected()){
            return europeTimezone;
        } else if (pacificTimezone.isSelected()){
            return pacificTimezone;
        } else if (usTimezone.isSelected()){
            return usTimezone;
        } else {
            return standardTimezone;
        }

    }

    public void setSelectedTimezone(String timezone){

        Regions selectedTimezone = Regions.valueOf(timezone);

        switch (selectedTimezone){
            case Regular_Timezone:
                updateForStandard();
                break;
            case All_Timezone:
                updateForAll();
                break;
            case Africa:
                updateForAfrica();
                break;
            case America:
                updateForAmerica();
                break;
            case Asia:
                updateForAsia();
                break;
            case Australia:
                updateForAustralia();
                break;
            case Europe:
                updateForEurope();
                break;
            case Pacific:
                updateForPacific();
                break;
            case US:
                updateForUs();
                break;
            default:
                updateForStandard();
        }
    }

}