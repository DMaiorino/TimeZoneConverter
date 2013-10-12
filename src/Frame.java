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

    public Frame(String title){
        setup(title);
    }

    public void setup(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400,150));
        setVisible(true);
        setTitle(title);
    }

}
