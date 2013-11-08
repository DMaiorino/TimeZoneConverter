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
    private JMenu menu, submenu;
    private JMenuItem menuItem;
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
    String[] allTimezoneList  = TimeZone.getAvailableIDs();
    String[] standardTimezoneList = {"Africa/Algiers", "Africa/Cairo", "Africa/Casablanca", "Africa/Harare", "Africa/Nairobi", "Africa/Windhoek", "America/Bogota", "America/Buenos_Aires", "America/Caracas", "America/Chihuahua", "America/Guatemala", "America/Mexico_City", "America/Montevideo", "America/Santiago", "America/Tijuana", "Asia/Amman", "Asia/Baghdad", "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Calcutta", "Asia/Colombo", "Asia/Dhaka", "Asia/Hong_Kong", "Asia/Irkutsk", "Asia/Jerusalem", "Asia/Kabul", "Asia/Karachi", "Asia/Katmandu", "Asia/Krasnoyarsk", "Asia/Kuala_Lumpur", "Asia/Kuwait", "Asia/Magadan", "Asia/Muscat", "Asia/Novosibirsk", "Asia/Rangoon", "Asia/Seoul", "Asia/Shanghai","Asia/Taipei", "Asia/Tbilisi", "Asia/Tehran", "Asia/Tokyo", "Asia/Vladivostok", "Asia/Yakutsk", "Asia/Yekaterinburg", "Asia/Yerevan", "Atlantic/Azores", "Atlantic/Cape_Verde", "Australia/Adelaide", "Australia/Brisbane", "Australia/Darwin", "Australia/Hobart", "Australia/Perth", "Australia/Sydney", "Brazil/East", "Canada/Eastern", "Canada/Newfoundland", "Canada/Saskatchewan", "Europe/Athens", "Europe/Belgrade", "Europe/Berlin", "Europe/Brussels", "Europe/Helsinki", "Europe/London", "Europe/Minsk", "Europe/Moscow", "Europe/Paris", "Europe/Warsaw", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Guam", "Pacific/Midway", "US/Alaska", "US/Arizona", "US/Central", "US/East-Indiana", "US/Eastern", "US/Hawaii", "US/Mountain", "US/Pacific", "UTC"} ;
    String[] africaTimezoneList = {"Africa/Abidjan", "Africa/Accra", "Africa/Addis_Ababa", "Africa/Algiers", "Africa/Asmera", "Africa/Bamako", "Africa/Bangui", "Africa/Banjul", "Africa/Bissau", "Africa/Blantyre", "Africa/Brazzaville", "Africa/Bujumbura", "Africa/Cairo", "Africa/Casablanca", "Africa/Ceuta", "Africa/Conakry", "Africa/Dakar", "Africa/Dar_es_Salaam", "Africa/Djibouti", "Africa/Douala", "Africa/El_Aaiun", "Africa/Freetown", "Africa/Gaborone", "Africa/Harare", "Africa/Johannesburg", "Africa/Kampala", "Africa/Khartoum", "Africa/Kigali", "Africa/Kinshasa", "Africa/Lagos", "Africa/Libreville", "Africa/Lome", "Africa/Luanda", "Africa/Lubumbashi", "Africa/Lusaka", "Africa/Malabo", "Africa/Maputo", "Africa/Maseru", "Africa/Mbabane", "Africa/Mogadishu", "Africa/Monrovia", "Africa/Nairobi", "Africa/Ndjamena", "Africa/Niamey", "Africa/Nouakchott", "Africa/Ouagadougou", "Africa/Porto-Novo", "Africa/Sao_Tome", "Africa/Timbuktu", "Africa/Tripoli", "Africa/Tunis", "Africa/Windhoek"};
    String[] americaTimezoneList = {"America/Belize", "America/Boa_Vista", "America/Bogota", "America/Boise", "America/Buenos_Aires", "America/Cambridge_Bay", "America/Campo_Grande", "America/Cancun", "America/Caracas", "America/Catamarca", "America/Cayenne", "America/Cayman", "America/Chicago", "America/Chihuahua", "America/Cordoba", "America/Costa_Rica", "America/Cuiaba", "America/Curacao", "America/Danmarkshavn", "America/Dawson", "America/Dawson_Creek", "America/Denver", "America/Detroit", "America/Dominica", "America/Edmonton", "America/Eirunepe", "America/El_Salvador", "America/Ensenada", "America/Fort_Wayne", "America/Fortaleza", "America/Glace_Bay", "America/Godthab", "America/Goose_Bay", "America/Grand_Turk", "America/Grenada", "America/Guadeloupe", "America/Guatemala", "America/Guayaquil", "America/Guyana", "America/Halifax", "America/Havana", "America/Hermosillo", "America/Indiana/Indianapolis", "America/Indiana/Knox", "America/Indiana/Marengo", "America/Indiana/Vevay", "America/Indianapolis", "America/Inuvik", "America/Iqaluit", "America/Jamaica", "America/Jujuy", "America/Juneau", "America/Kentucky/Louisville", "America/Kentucky/Monticello", "America/Knox_IN", "America/La_Paz", "America/Lima", "America/Los_Angeles", "America/Louisville", "America/Maceio", "America/Managua", "America/Manaus", "America/Martinique", "America/Mazatlan", "America/Mendoza", "America/Menominee", "America/Merida", "America/Mexico_City", "America/Miquelon", "America/Monterrey", "America/Montevideo", "America/Montreal", "America/Montserrat", "America/Nassau", "America/New_York", "America/Nipigon", "America/Nome", "America/Noronha", "America/North_Dakota/Center", "America/Panama", "America/Pangnirtung", "America/Paramaribo", "America/Phoenix", "America/Port_of_Spain", "America/Port-au-Prince", "America/Porto_Acre", "America/Porto_Velho", "America/Puerto_Rico", "America/Rainy_River", "America/Rankin_Inlet", "America/Recife", "America/Regina", "America/Rio_Branco", "America/Rosario", "America/Santiago", "America/Santo_Domingo", "America/Sao_Paulo", "America/Scoresbysund", "America/Shiprock", "America/St_Johns", "America/St_Kitts", "America/St_Lucia", "America/St_Thomas", "America/St_Vincent", "America/Swift_Current", "America/Tegucigalpa", "America/Thule", "America/Thunder_Bay", "America/Tijuana", "America/Toronto", "America/Tortola", "America/Vancouver", "America/Virgin", "America/Whitehorse", "America/Winnipeg", "America/Yakutat", "America/Yellowknife"};
    String[] asiaTimezoneList = {"Asia/Aden", "Asia/Almaty", "Asia/Amman", "Asia/Anadyr", "Asia/Aqtau", "Asia/Aqtobe", "Asia/Ashgabat", "Asia/Ashkhabad", "Asia/Baghdad", "Asia/Bahrain", "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Bishkek", "Asia/Brunei", "Asia/Calcutta", "Asia/Choibalsan", "Asia/Chongqing", "Asia/Chungking", "Asia/Colombo", "Asia/Dacca", "Asia/Damascus", "Asia/Dhaka", "Asia/Dili", "Asia/Dubai", "Asia/Dushanbe", "Asia/Gaza", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Hovd", "Asia/Irkutsk", "Asia/Istanbul", "Asia/Jakarta", "Asia/Jayapura", "Asia/Jerusalem", "Asia/Kabul", "Asia/Kamchatka", "Asia/Karachi", "Asia/Kashgar", "Asia/Katmandu", "Asia/Krasnoyarsk", "Asia/Kuala_Lumpur", "Asia/Kuching", "Asia/Kuwait", "Asia/Macao", "Asia/Macau", "Asia/Magadan", "Asia/Makassar", "Asia/Manila", "Asia/Muscat", "Asia/Nicosia", "Asia/Novosibirsk", "Asia/Omsk", "Asia/Oral", "Asia/Phnom_Penh", "Asia/Pontianak", "Asia/Pyongyang", "Asia/Qatar", "Asia/Qyzylorda", "Asia/Rangoon", "Asia/Riyadh", "Asia/Riyadh87", "Asia/Riyadh88", "Asia/Riyadh89", "Asia/Saigon", "Asia/Sakhalin", "Asia/Samarkand", "Asia/Seoul", "Asia/Shanghai", "Asia/Singapore", "Asia/Taipei", "Asia/Tashkent", "Asia/Tbilisi", "Asia/Tehran", "Asia/Tel_Aviv", "Asia/Thimbu", "Asia/Thimphu", "Asia/Tokyo", "Asia/Ujung_Pandang", "Asia/Ulaanbaatar", "Asia/Ulan_Bator", "Asia/Urumqi", "Asia/Vientiane", "Asia/Vladivostok", "Asia/Yakutsk", "Asia/Yekaterinburg", "Asia/Yerevan"};
    String[] australiaTimezoneList = {"Australia/ACT", "Australia/Adelaide", "Australia/Brisbane", "Australia/Broken_Hill", "Australia/Canberra", "Australia/Darwin", "Australia/Hobart", "Australia/LHI", "Australia/Lindeman", "Australia/Lord_Howe", "Australia/Melbourne", "Australia/North", "Australia/NSW", "Australia/Perth", "Australia/Queensland", "Australia/South", "Australia/Sydney", "Australia/Tasmania", "Australia/Victoria", "Australia/West", "Australia/Yancowinna"};
    String[] europeTimezoneList = {"Europe/Amsterdam", "Europe/Andorra", "Europe/Athens", "Europe/Belfast", "Europe/Belgrade", "Europe/Berlin", "Europe/Bratislava", "Europe/Brussels", "Europe/Bucharest", "Europe/Budapest", "Europe/Chisinau", "Europe/Copenhagen", "Europe/Dublin", "Europe/Gibraltar", "Europe/Helsinki", "Europe/Istanbul", "Europe/Kaliningrad", "Europe/Kiev", "Europe/Lisbon", "Europe/Ljubljana", "Europe/London", "Europe/Luxembourg", "Europe/Madrid", "Europe/Malta", "Europe/Minsk", "Europe/Monaco", "Europe/Moscow", "Europe/Nicosia", "Europe/Oslo", "Europe/Paris", "Europe/Prague", "Europe/Riga", "Europe/Rome", "Europe/Samara", "Europe/San_Marino", "Europe/Sarajevo", "Europe/Simferopol", "Europe/Skopje", "Europe/Sofia", "Europe/Stockholm", "Europe/Tallinn", "Europe/Tirane", "Europe/Tiraspol", "Europe/Uzhgorod", "Europe/Vaduz", "Europe/Vatican", "Europe/Vienna", "Europe/Vilnius", "Europe/Warsaw", "Europe/Zagreb", "Europe/Zaporozhye", "Europe/Zurich"};
    String[] pacificTimezoneList = {"Pacific/Apia", "Pacific/Auckland", "Pacific/Chatham", "Pacific/Easter", "Pacific/Efate", "Pacific/Enderbury", "Pacific/Fakaofo", "Pacific/Fiji", "Pacific/Funafuti", "Pacific/Galapagos", "Pacific/Gambier", "Pacific/Guadalcanal", "Pacific/Guam", "Pacific/Honolulu", "Pacific/Johnston", "Pacific/Kiritimati ", "Pacific/Kosrae", "Pacific/Kwajalein", "Pacific/Majuro", "Pacific/Marquesas", "Pacific/Midway", "Pacific/Nauru", "Pacific/Niue", "Pacific/Norfolk", "Pacific/Noumea", "Pacific/Pago_Pago", "Pacific/Palau", "Pacific/Pitcairn", "Pacific/Ponape", "Pacific/Port_Moresby", "Pacific/Rarotonga", "Pacific/Saipan", "Pacific/Samoa", "Pacific/Tahiti", "Pacific/Tarawa", "Pacific/Tongatapu", "Pacific/Truk", "Pacific/Wake", "Pacific/Wallis", "Pacific/Yap"};
    String[] usTimezoneList = {"US/Alaska", "US/Aleutian", "US/Arizona", "US/Central", "US/East-Indiana", "US/Eastern", "US/Hawaii", "US/Indiana-Starke", "US/Michigan", "US/Mountain", "US/Pacific", "US/Pacific-New", "US/Samoa"};

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
        africaListener = new africaListener();
        americaListener = new americaListener();
        asiaListener = new asiaListener();
        australiaListener = new australiaListener();
        europeListener = new europeListener();
        pacificListener = new pacificListener();
        usListener = new usListener();

        //a group of check box menu items
        standardTimezone = new JRadioButtonMenuItem("Regular Timezone");
        standardTimezone.setMnemonic(KeyEvent.VK_S);
        standardTimezone.addItemListener(standardListener);
        menu.add(standardTimezone);

        allTimezone = new JRadioButtonMenuItem("All Timezone");
        allTimezone.setMnemonic(KeyEvent.VK_A);
        allTimezone.addItemListener(allListener);
        menu.add(allTimezone);

        //Sub Menu Bar
        submenu = new JMenu("Region");
        submenu.setMnemonic(KeyEvent.VK_R);

        africaTimezone = new JRadioButtonMenuItem("Africa");
        africaTimezone.addItemListener(africaListener);
        submenu.add(africaTimezone);

        americaTimezone = new JRadioButtonMenuItem("America");
        americaTimezone.addItemListener(americaListener);
        submenu.add(americaTimezone);

        asiaTimezone = new JRadioButtonMenuItem("Asia");
        asiaTimezone.addItemListener(asiaListener);
        submenu.add(asiaTimezone);

        australiaTimezone = new JRadioButtonMenuItem("Australia");
        australiaTimezone.addItemListener(australiaListener);
        submenu.add(australiaTimezone);

        europeTimezone = new JRadioButtonMenuItem("Europe");
        europeTimezone.addItemListener(europeListener);
        submenu.add(europeTimezone);

        pacificTimezone = new JRadioButtonMenuItem("Pacific");
        pacificTimezone.addItemListener(pacificListener);
        submenu.add(pacificTimezone);

        usTimezone = new JRadioButtonMenuItem("US");
        usTimezone.addItemListener(usListener);
        submenu.add(usTimezone);

        menu.add(submenu);

        //Final Quit Menu
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

    public void deselectItems(){
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
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    public class allListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            allTimezone.setSelected(true);
            setTimezoneList(allTimezoneList);
            addListeners();
        }
    }

    public class standardListener implements ItemListener{
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            standardTimezone.setSelected(true);
            setTimezoneList(standardTimezoneList);
            addListeners();
        }
    }

    public class africaListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            africaTimezone.setSelected(true);
            setTimezoneList(africaTimezoneList);
            addListeners();
        }
    }

    public class americaListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            americaTimezone.setSelected(true);
            setTimezoneList(americaTimezoneList);
            addListeners();
        }
    }

    public class asiaListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            asiaTimezone.setSelected(true);
            setTimezoneList(asiaTimezoneList);
            addListeners();
        }
    }

    public class australiaListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            australiaTimezone.setSelected(true);
            setTimezoneList(australiaTimezoneList);
            addListeners();
        }
    }

    public class europeListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            europeTimezone.setSelected(true);
            setTimezoneList(europeTimezoneList);
            addListeners();
        }
    }

    public class pacificListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            pacificTimezone.setSelected(true);
            setTimezoneList(pacificTimezoneList);
            addListeners();
        }
    }

    public class usListener implements ItemListener {
        public  void itemStateChanged(ItemEvent e){
            removeListeners();
            deselectItems();
            usTimezone.setSelected(true);
            setTimezoneList(usTimezoneList);
            addListeners();
        }
    }

    public void removeListeners(){
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

    public void addListeners(){
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
