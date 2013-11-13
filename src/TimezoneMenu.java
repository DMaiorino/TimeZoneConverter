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
    String currentTZ = Calendar.getInstance().getTimeZone().getID();
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
    final JComboBox<String> newTimezoneBox;

    public TimezoneMenu(JComboBox<String> baseTimezoneBox, JComboBox<String> newTimezoneBox) {
        this.baseTimezoneBox = baseTimezoneBox;
        this.newTimezoneBox = newTimezoneBox;
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
        JMenuItem menuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menuItem.addActionListener(new quitListener());

        menu.add(saveItem);
        menu.addSeparator();
        menu.add(menuItem);

        //TimezoneMenu Bar
        JMenu timezoneMenu = new JMenu("Timezone");
        timezoneMenu.setMnemonic(KeyEvent.VK_R);
        JMenu regionMenu = new JMenu("Region");
        regionMenu.setMnemonic(KeyEvent.VK_R);

        standardTimezone = new JRadioButtonMenuItem("Regular Timezone");
        standardTimezone.setMnemonic(KeyEvent.VK_S);
        standardTimezone.addItemListener(standardListener);
        timezoneMenu.add(standardTimezone);

        allTimezone = new JRadioButtonMenuItem("All Timezone");
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


        //Add menus to the menu bar
        standardTimezone.setSelected(true);
        menuBar.add(menu);
        menuBar.add(timezoneMenu);
        menuBar.add(helpMenu);

    }

    public void setTimezoneList(String[] timezoneList) {

        Arrays.sort(timezoneList);

        baseTimezoneBox.removeAllItems();
        newTimezoneBox.removeAllItems();

        for (String tz : timezoneList) {
            baseTimezoneBox.addItem(tz);
            newTimezoneBox.addItem(tz);
        }

        baseTimezoneBox.setSelectedItem(currentTZ);
        newTimezoneBox.setSelectedItem("UTC");

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


    public class quitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class allListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            allTimezone.setSelected(true);
            setTimezoneList(allTimezoneList);
            addListeners();
        }
    }

    public class standardListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            standardTimezone.setSelected(true);
            setTimezoneList(standardTimezoneList);
            addListeners();
        }
    }

    public class africaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("Africa/");
            africaTimezone.setSelected(true);
            setTimezoneList(africaTimezoneList);
            addListeners();
        }
    }

    public class americaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("America/");
            americaTimezone.setSelected(true);
            setTimezoneList(americaTimezoneList);
            addListeners();
        }
    }

    public class asiaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("Asia/");
            asiaTimezone.setSelected(true);
            setTimezoneList(asiaTimezoneList);
            addListeners();
        }
    }

    public class australiaListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("Australia/");
            australiaTimezone.setSelected(true);
            setTimezoneList(australiaTimezoneList);
            addListeners();
        }
    }

    public class europeListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("Europe/");
            europeTimezone.setSelected(true);
            setTimezoneList(europeTimezoneList);
            addListeners();
        }
    }

    public class pacificListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("Pacific/");
            pacificTimezone.setSelected(true);
            setTimezoneList(pacificTimezoneList);
            addListeners();
        }
    }

    public class usListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            removeListeners();
            deselectItems();
            Panel.setTimezoneheader("US/");
            usTimezone.setSelected(true);
            setTimezoneList(usTimezoneList);
            addListeners();
        }
    }

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

}
