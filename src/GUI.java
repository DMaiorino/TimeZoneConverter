import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/5/13
 * Time: 5:45 PM
 * A simple app for converting time.
 */

public class GUI {


    //Window
    JFrame frame;

    //Base Components
    JComboBox baseTimezoneBox;
    JComboBox newTimezoneBox;

    //Time Info
    TimezoneMenu tz;
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
        tz = new TimezoneMenu(baseTimezoneBox, newTimezoneBox);
        baseTimezoneBox.addItem(tz.getStandardTimezoneList());
        newTimezoneBox.addItem(tz.getStandardTimezoneList());
        timezoneMenu = tz.getMenuBar();

        //Setup the Frame
        frame = new Frame("Timezone Converter");
        frame.setJMenuBar(timezoneMenu);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        //Update the new time once (Currently set to UTC )
        panel.convertTime();
        frame.setSize(new Dimension(400,250));
    }

}
