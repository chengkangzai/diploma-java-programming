package assignment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class GUI_Class  {

    public static void showConfirmDialog(String s) {
        final JFrame parent = new JFrame();
        parent.setVisible(true);

        // JOptionPane.showInputDialog(parent, "What is your name?", null);
        final int showConfirmDialog = JOptionPane.showConfirmDialog(parent, s);
        switch (showConfirmDialog) {
            case 0:
                JOptionPane.showMessageDialog(parent, "Yes is return");
                break;

            case 1:
                JOptionPane.showMessageDialog(parent, "No is return");
                break;

            case 2:
                JOptionPane.showMessageDialog(parent, "Cancel is return");
                break;

        }
        parent.setVisible(false);
    }

    public static void showMessageBox(String message) {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        JOptionPane.showMessageDialog(parent, message, "Pop Up 1", 1);
        parent.setVisible(false);
    }

    public static void sayThanks() {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        JOptionPane.showMessageDialog(parent, "Thanks for purchase!", "Thanks and please come again", 1);
        parent.setVisible(false);
    }

    public static void exitSoftware() {
        final JFrame parent = new JFrame();
        final int showConfirmDialog = JOptionPane.showConfirmDialog(parent, "Are you sure you want to exit ?", "Exit Confirmation", 1);
        
        switch (showConfirmDialog) {
            case 0:
                DB.Logger(3, 1);
                System.exit(0);
                break;

            case 1:
                parent.setVisible(false);
                break;

            case 2:
                parent.setVisible(false);
                break;

        }

    }

    public static char[] showPasswordBox() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[] { "OK", "Cancel" };
        int option = JOptionPane.showOptionDialog(null, panel, "Password", JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        char[] password = pass.getPassword();
        return password;
    }

    public static int passwordMatching(String password) {
        String oriPassword =DB.returnPassword();
        String hashInput = DB.getHash(password.getBytes(), "SHA-256");
        int status = 0;
        if (oriPassword.equals(hashInput)) {
            status =1;
        }
        return status;
    }

    public static void showGUI() {
        DB.Logger(2, 1);
        GUI gui = new GUI();
        gui.setVisible(true);
        
    }

    public static void showAdminPanel() {
        DB.Logger(2, 0);
        adminPanel adminPL = new adminPanel();
        adminPL.setVisible(true);
    }
}
