import javax.swing.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 10/24/13
 * Time: 11:52 PM
 * A simple app for converting time.
 */
public class Menu implements ActionListener,ItemListener{

    //Menu Components
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public JMenuBar createMenuBar() {

        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        menuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);

        return menuBar;

    }

    public void actionPerformed(ActionEvent e){
            System.out.println("quit");
            System.exit(0);
    }

    public  void itemStateChanged(ItemEvent e){

    }
}
