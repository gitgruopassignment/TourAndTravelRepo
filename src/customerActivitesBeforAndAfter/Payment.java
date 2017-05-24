package customerActivitesBeforAndAfter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Payment {

    private String firstName;
    private String secondName;
    private int accountNumber;
    public int agentAccountNumber = 1234567890;

    public void payForBook(double pay, String purpuse) {
        Scanner scan = new Scanner(System.in);
        String path = "F:\\paymentReport.html";
        File file = new File(path);
        try (BufferedWriter add = new BufferedWriter(new FileWriter(file, true))) {
            add.append("\n----------------------------------------------------------------------------------------------");
            System.out.println("\n\n\n\tENTER YOUR DATA CORRECTLY TO PAY PAYMENT EVERYTHING IS MUST BE SIMILAR TO YOU BANK BOOK ");
            System.out.println("\nfirst name :");
            firstName = scan.next();
            add.append("\nfirst name :");
            add.append(firstName);
           // add.append(new Booking().getFullName(0));

            System.out.println("second name :");
            secondName = scan.next();
            add.append("\nsecond name :");
            add.append(secondName);
            //add.append(new Booking().getFullName(1));

            add.append("\npayment   purpose  :" + purpuse);
            add.append("\npayment   for    " + purpuse + "  cost  is equal :" + pay);

            try {
                System.out.println("enter  your account number :");
                accountNumber = scan.nextInt();
                add.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "you enter invalid account number! \n\t tray again correctly");
                payForBook(pay, purpuse);
            }
            JOptionPane.showMessageDialog(null, "payment for   " + purpuse + "   is  success full" + "\n\tThanks!!");
            new Customer().Login(2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "payment for   " + purpuse + "   is  unsuccessfull" + "\n\tTry again  by start booking agin!!");
            new Customer().Login(2);
        }
    }
}
