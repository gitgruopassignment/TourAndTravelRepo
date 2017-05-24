package customerActivitesBeforAndAfter;

import javax.swing.JOptionPane;

public class User {

    public final String VOICENAME = "kevin";

    public void browsSystem() {

        String[] choices = {"Customer login", "Admin Login", "Registration", "Exit"};
        int response3 = JOptionPane.showOptionDialog(null, "What do you want?\n\n"
                + "HELP:\n Before login you must register to ETTMS. \n \t", "Ethiopian tour and travel management system",
                0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);

        if (response3 == 0) {
            new Customer().Login(1);
        } else if (response3 == 1) {
            new Customer().Login(3);
        } else if (response3 == 2) {
            new Customer().createAccount(0);
        } else {
            System.exit(0);
        }

    }

    public static void main(String... aa) {
        User first = new User();
        System.err.println("\n\n\n\t\tWELL-COME TO ETHIOPIAN TOUR AND TRAVEL MANAGEMENT SYSTEM ");
        System.err.println("\n\n\t\tpress any to continue");
        String kk = new java.util.Scanner(System.in).next();
        first.browsSystem();
    }
}
