import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/5/13
 * Time: 5:45 PM
 * A simple app for converting time.
 */

public class GUI{


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
    JPanel mainPanel;


    public void start(){

        //Create panel
        mainPanel = new JPanel();
        panel = new Panel();
        mainPanel = panel.getPanel();

        this.baseTimezoneBox = panel.getBaseTimezoneBox();
        this.newTimezoneBox = panel.getNewTimezoneBox();

        //Setup Menu, Timezones
        timezoneMenuObject = new TimezoneMenu(baseTimezoneBox, newTimezoneBox);
        for (String timezone : timezoneMenuObject.getStandardTimezoneList()) {
            baseTimezoneBox.addItem(timezone);
            newTimezoneBox.addItem(timezone);
        }
        timezoneMenu = timezoneMenuObject.getMenuBar();

        //Setup the Frame
        frame = new Frame("Open Time Zone Converter");
        frame.setJMenuBar(timezoneMenu);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        //Update the new time once (Currently set to UTC )
        panel.convertTime();
        frame.setSize(new Dimension(400,250));

    }


    public void componentHidden(ComponentEvent e) {
        //
    }

    public void componentMoved(ComponentEvent e) {
        //
    }


}
