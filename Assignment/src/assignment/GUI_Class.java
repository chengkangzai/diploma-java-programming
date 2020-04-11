package assignment;

import MyLogger.GuiLog;
import MyLogger.MyLogger;
import MyLogger.ProgramLog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class GUI_Class {

    /**
     *
     * @param message the message that you want to show up in the message box
     */
    public static void showMessageBox(String message) {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        JOptionPane.showMessageDialog(parent, message, "Pop Up ", 1);
        parent.setVisible(false);
    }

    public static void showWarningBox(String message) {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        JOptionPane.showMessageDialog(parent, message, "Pop Up ", 0);
        parent.setVisible(false);
    }

    /**
     * say thanks to the customer !
     */
    public static void sayThanks() {
        final JFrame parent = new JFrame();
        parent.setVisible(true);
        JOptionPane.showMessageDialog(parent, "Thanks for purchase!", "Thanks and please come again", 1);
        parent.setVisible(false);
    }

    /**
     * Ask the customer really want to exit ?
     */
    public static void exitSoftware() {
        final JFrame parent = new JFrame();
        final int showConfirmDialog = JOptionPane.showConfirmDialog(parent, "Are you sure you want to exit ?",
                "Exit Confirmation", 1);

        switch (showConfirmDialog) {
            case 0:
                new ProgramLog(1).log();
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

    /**
     * Show the password box (In this assignment is used for open admin panel)
     *
     * @return password in char array will be returned
     */
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

    /**
     *
     * @param password the password of input
     * @return status of the matching or not, 0 is not and 1 is matching
     */
    public static int passwordMatching(String password) {
        String oriPassword = DB.returnPassword();
        String hashInput = DB.getHash(password.getBytes(), "SHA-256");
        int status = 0;
        if (oriPassword.equals(hashInput)) {
            status = 1;
        }
        return status;
    }

    /**
     * Open the GUI Jframe
     */
    public static void showGUI() {
        new GuiLog(0, "GUI").log();
        new GUI().setVisible(true);

    }

    /**
     * open admin Panel
     */
    public static void showAdminPanel() {
        new GuiLog(0, "Admin Panel").log();
        new adminPanel().setVisible(true);
    }
}
