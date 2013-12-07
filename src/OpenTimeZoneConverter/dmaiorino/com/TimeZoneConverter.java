package OpenTimeZoneConverter.dmaiorino.com;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/5/13
 * Time: 5:54 PM
 * A simple app for converting time.
 */
public class TimeZoneConverter {

    static Frame frame;

    public static void main (String[] args){
        new TimeZoneConverter().startGUI();
    }

    public void startGUI(){
        frame = new Frame();
        frame.setVisible(true);
    }

    static public Frame getFrame(){
        return frame;
    }

}

