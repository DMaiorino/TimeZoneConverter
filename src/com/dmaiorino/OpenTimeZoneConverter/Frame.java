package com.dmaiorino.OpenTimeZoneConverter;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
        setMinimumSize(new Dimension(400,200));
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
        timezoneMenuObject = new TimezoneMenu(baseTimezoneBox, newTimezoneBox, baseDatePicker, baseTimeSpinner, panel);
        for (String timezone : timezoneMenuObject.getSimplifiedTimezoneList()) {
            baseTimezoneBox.addItem(timezone);
            newTimezoneBox.addItem(timezone);
        }
        timezoneMenu = timezoneMenuObject.getMenuBar();

        //Setup the Frame
        getContentPane().add(panel);
        setJMenuBar(timezoneMenu);
        pack();

        //Add image
        URL imgURL = this.getClass().getResource("kworldclock.png");
        ImageIcon worldClock =  new ImageIcon(imgURL);
        setIconImage(worldClock.getImage());


        //Update the new time once (Currently set to UTC )
        panel.convertTime();
        setSize(getMinimumSize());


    }

}
