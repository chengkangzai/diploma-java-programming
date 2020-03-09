package assignment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI_Class {

    public static void showPopUp() {
        //Initializing JFRAME and button
        final JFrame parent = new JFrame();
        JButton button = new JButton();
        //set the button text
        button.setText("Click me to show dialog!");
        // add the button to the jframe
        parent.add(button);
        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        parent.pack();
        //Show it
        parent.setVisible(true);

        //Event listener of Java
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //show the dialog 
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
            }
        });
    }

    public static void test() {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        //JOptionPane.showInputDialog(parent, "What is your name?", null);
        //JOptionPane.showMessageDialog(parent, "A button is been click ");
        Object[] possibilities = {"ham", "spam", "yam"};
        String s = (String) JOptionPane.showInputDialog(
                parent,
                "A button is been click!",
                "Confirmation Dialog ",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "ham");
        if ("ham".equals(s)) {
            parent.setVisible(false);
        }else if ("spam".equals(s)){
            parent.setVisible(false);
        }else if ("yam".equals(s)){
            parent.setVisible(false);
        }
    }
    


}
