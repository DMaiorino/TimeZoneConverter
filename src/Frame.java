import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/12/13
 * Time: 1:17 PM
 * A simple app for converting time.
 */
public class Frame extends JFrame {

    //Window
    JFrame frame;

    //Base Components
    JComboBox<String> baseTimezoneBox;
    JComboBox<String> newTimezoneBox;

    //Time Info
    TimezoneMenu timezoneMenuObject;
    JMenuBar timezoneMenu;

    //Panel Instances
    Panel panel;
    JXDatePicker baseDatePicker;
    JSpinner baseTimeSpinner;

    public Frame(){
        setup();
    }

    public void setup(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400,250));
        setTitle("Open Time Zone Converter");

        //Create panel
        panel = new Panel();
        panel.setVisible(true);

        //Get Panel Components
        this.baseTimezoneBox = panel.getBaseTimezoneBox();
        this.newTimezoneBox = panel.getNewTimezoneBox();
        this.baseDatePicker = panel.getBaseDatePicker();
        this.baseTimeSpinner = panel.getBaseTimeSpinner();

        //Setup Menu
        timezoneMenuObject = new TimezoneMenu(baseTimezoneBox, newTimezoneBox, baseDatePicker, baseTimeSpinner);
        for (String timezone : timezoneMenuObject.getStandardTimezoneList()) {
            baseTimezoneBox.addItem(timezone);
            newTimezoneBox.addItem(timezone);
        }
        timezoneMenu = timezoneMenuObject.getMenuBar();

        //Setup the Frame
        setJMenuBar(timezoneMenu);
        getContentPane().add(panel);
        pack();

        //Update the new time once (Currently set to UTC )
        panel.convertTime();

        setSize(new Dimension(400,250));

    }

}
