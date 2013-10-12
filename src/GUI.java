import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.*;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/5/13
 * Time: 5:45 PM
 * A simple app for converting time.
 */
public class GUI {

    // Need to classify
    JButton button;
    String[] timezoneList = {"UTC", "JST+9"};

    //Window
    JFrame frame;
    JPanel mainPanel;

    //Base Components
    JXDatePicker baseDatePicker;
    JComboBox baseTimezoneBox;
    JLabel baseLabel;

    //New Components
    JXDatePicker newDatePicker;
    JComboBox newTimezoneBox;
    JLabel newLabel;



    public void start(){


        mainPanel = new Panel();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0,10,0,10);
        c.weightx = 0.5;
        c.weighty = 0.5;

        //Add the base time components
        baseLabel = new JLabel("Current Time", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(baseLabel, c);

        baseDatePicker = new JXDatePicker();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(baseDatePicker, c);

        baseTimezoneBox = new JComboBox(timezoneList);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(baseTimezoneBox, c);


        //Add the new time components
        newLabel = new JLabel("New Time", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(newLabel, c);
        newDatePicker = new JXDatePicker();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(newDatePicker, c);

        newTimezoneBox = new JComboBox(timezoneList);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(newTimezoneBox, c);


        //Convert Button
        button = new JButton("Convert");
        c.insets = new Insets(10,10,0,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;

        mainPanel.add(button, c);

        //Setup the Frame
        frame = new Frame("Timezone Converter");
        frame.getContentPane().add(mainPanel);
        frame.pack();

    }



}
