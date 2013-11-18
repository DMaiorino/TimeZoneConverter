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

public class GUI implements ComponentListener{


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

    //Labels
    JLabel newDateLabel;
    JLabel newTimeLabel;

    //Spinners
    JSpinner baseTimeSpinner;

    //Button
    JButton convertButton;

    //DatePicker
    JXDatePicker baseDatePicker;

    public void start(){

        //Create panel
        mainPanel = new JPanel();
        panel = new Panel();
        mainPanel = panel.getPanel();

        //Get Labels
        newDateLabel = panel.getNewDateLabel();
        newTimeLabel = panel.getNewTimeLabel();

        //Get Spinner
        baseTimeSpinner = panel.getBaseTimeSpinner();

        //Button
        convertButton = panel.getConvertButton();

        // Get DatePicker
        baseDatePicker = panel.getBaseDatePicker();

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
        frame = new Frame("Timezone Converter");
        frame.setJMenuBar(timezoneMenu);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        //Update the new time once (Currently set to UTC )
        panel.convertTime();
        frame.setSize(new Dimension(400,250));
        frame.addComponentListener(this);

    }


    public void componentHidden(ComponentEvent e) {
        //
    }

    public void componentMoved(ComponentEvent e) {
        //
    }

    public void componentResized(ComponentEvent e) {

        int fontSize = resizeLabelFont(newDateLabel);

        Font resizeFont = new Font("New Times Roman",Font.BOLD,fontSize);

        newDateLabel.setFont(resizeFont);
        newTimeLabel.setFont(resizeFont);
        baseTimezoneBox.setFont(resizeFont);
        newTimezoneBox.setFont(resizeFont);
        convertButton.setFont(resizeFont);
        baseDatePicker.setFont(resizeFont);
        panel.setBaseTimeSpinnerFont(fontSize);

    }

    public void componentShown(ComponentEvent e) {
        //
    }

    private int resizeLabelFont(JLabel label){

        Font labelFont = label.getFont();
        String labelText = label.getText();

        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize() * widthRatio) -4 ;
        int componentHeight = label.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentWidth);

        return fontSizeToUse;

    }


}
