package AdminstratorAndOthers;


import customerActivitesBeforAndAfter.Customer;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Adminstrator {

    private String ID;  
    private String password;

    //value a is used to separet admin from user at time of view tours
    // 1 for admin 
    // 0 and any for user  
    public void viewTours(int a) {
        Scanner scan = new Scanner(System.in);
        if (a == 1) {
            String[] chance = {"search", "Brows File"};
            int response = JOptionPane.showOptionDialog(null, "by what method you want to view tours", "tour view methods by admin", 0, JOptionPane.QUESTION_MESSAGE, null, chance, chance[1]);
            if (response == 0) {
                System.out.println("n\n\tview tour by admin and staff member");
                System.out.println("\tenter turtype.html to view all by tour type");
                System.out.println("enter allTours.html to view all tours in the system");
                System.out.println("\tenter  F:\\tourtype.html    you want to see!");
                String fileName = scan.next();
                String line;
                try {
                    FileReader fileReader = new FileReader(fileName);
                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        while ((line = bufferedReader.readLine()) != null) {
                            //used to conver to file to audio 
//                            Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                            voice.allocate();
//                            voice.setRate(120);
//                            voice.setPitch(100);
//                            voice.speak(line);
                            System.out.println("\n\n" + line + "\n");
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error reading file '" + fileName
                                + "' \ntray again!\n\n\tpress  1 move menu else any to try again ");

                        new Customer().Login(0);
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "\n\nthere is no  added tour  type  '" + fileName
                            + "' \n tray again!!");
                    new Customer().Login(0);
                }
                new Customer().Login(0);

            } else {
                Desktop desktop = Desktop.getDesktop();
                File ToOpen;
                try {
                    //used only open disk not folder
                    ToOpen = new File("F:\\");
                    desktop.open(ToOpen);
                } catch (Exception iae) {
                    JOptionPane.showMessageDialog(null, "you enter invalid disk type");
                    new Customer().Login(0);
                }
                JOptionPane.showMessageDialog(null, "Browsing file successfull!");
                new Customer().Login(0);
            }
        } else {
            System.out.println("n\n\tview tour by customer");
            System.out.println("\tenter turtype.html to view all by tour type");
            System.out.println("enter allTours.html to view all tours in the system");
            System.out.println("\tenter  F:\\tourtype.html    you want to see!");
            String fileName = scan.next();
            String line;
            try {
                FileReader fileReader = new FileReader(fileName);
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    while ((line = bufferedReader.readLine()) != null) {
//                        Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                        voice.allocate();
//                        voice.setRate(120);
//                        voice.setPitch(100);
//                        voice.speak(line);
                        System.out.println(line);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file '" + fileName
                            + "' \ntray again!\n\n\tpress  1 move menu else any to try again ");

                    new Customer().Login(2);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "\n\nthere is no  added tour  type  '" + fileName
                        + "' \n tray again!!");

                new Customer().Login(2);
            }

            new Customer().Login(2);
        }
    }

    void viewRegisteration() {
        String fileName = "F:\\allCustomerList.html";
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
//                    Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                    voice.allocate();
//                    voice.setRate(120);
//                    voice.setPitch(100);
//                    voice.speak(line);
                    System.out.println(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "customer registred file reading error\n");
                new Customer().Login(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "there is no registered customer \n\n");
            new Customer().Login(0);
        } finally {
            new Customer().Login(0);
        }
    }

    private void deleteTours() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tdeleteing tour by admin");
        System.out.println("\tDon't write space between  the word ");
        System.out.println("\tenter  F:\\ tourtype.html");
        String fileName = scan.next();

        File file;
        try {
            file = new File(fileName);
            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "Tour  '" + file.getName() + "' is deleted!");
                new Customer().Login(0);
            } else {
                JOptionPane.showMessageDialog(null, "Tour delete operation is failed.");
                new Customer().Login(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tour delete operation is failed");
            new Customer().Login(0);
        }
    }

    void addTours() {
        new Tours().addTour();

    }

    void writeResponce() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nwrite correct feedback response\n");
        System.out.println("\tEnter DONE to terminate");

        try (FileWriter xxx = new FileWriter("F:\\feed Back.html", true)) {

            xxx.append("\n\n\t\tadmin feedback/response: \n");
            xxx.append("\n\n----------------------------------------------------------------------------------------------");
            String line;
            while ((line = scan.nextLine()) != null) {

                if (line.trim().equalsIgnoreCase("done")) {
                    JOptionPane.showMessageDialog(null, "feedback responce add successful!");
                    xxx.close();
                    new Customer().Login(0);
                }
                xxx.append(line + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "write feed back fail try again");
            new Customer().Login(0);
        }

    }

    void viewBookingRequest() {
        String fileName = "F:\\allbooking.html";
        String line;
        System.out.println("\n\n\nlist of all booking request");
        try {
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
//                    Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                    voice.allocate();
//                    voice.setRate(120);
//                    voice.setPitch(100);
//                    voice.speak(line);
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "file '" + fileName + "'not found");
            new Customer().Login(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to open '" + fileName + "' file");
            new Customer().Login(0);
        }
        new Customer().Login(0);
    }

    private void paymentView() {
        String line;

        try {
            FileReader fileReader = new FileReader("F:\\paymentReport.html");
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
//                    Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                    voice.allocate();
//                    voice.setRate(120);
//                    voice.setPitch(100);
//                    voice.speak(line);
                    System.out.println(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file payment report ");
                new Customer().Login(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "\n\n  there is no  payment report.txt");
            new Customer().Login(0);
        }
        new Customer().Login(0);
    }

    public void viewFeedBack() {
        String fileName = "F:\\feed Back.html";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
//                    Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                    voice.allocate();
//                    voice.setRate(120);
//                    voice.setPitch(100);
//                    voice.speak(line);
                    System.out.println(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "error occur opening '" + fileName + "'  file");
                new Customer().Login(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "there is no  '" + fileName + "'  file");
            new Customer().Login(0);
        }
        new Customer().Login(0);
    }

    public void Login(int y) {
        String ID, password;
        if (y == 3) {
            Scanner scan = new Scanner(System.in);
            try {
                ID = JOptionPane.showInputDialog(null, "admin tour and travel login form" 
                        + "\n\t\tenter user name");
                password = JOptionPane.showInputDialog(null, "admin tour and travel login form" 
                        + "\n\t\tenter password");

                if ((ID.compareTo("admin")) == 0 && (password.compareTo("ETTMS")) == 0) {

                    //adminstrator chose activites he/she wants to do
                    String[] choices = {"Add.T", "Delete.T", "View.T", "W.F.R", "View.F", "V.B.R", "V.P.G", "V.register", "logout"};
                    int response3 = JOptionPane.showOptionDialog(null, "HELP \n ---\nT is tours \n W.F.R is  write tour response\n"
                            + "V.register is view register customer in the ETTMS\n"
                            + "V.B.R is view booking request\n"
                            + "V.P.G is view ammount pay done by customer for booking\n "
                            + "F is feedback\n\n"
                            + "what activity do you want done? \n\n",
                            "choice for adminstrator actvites ", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[8]);

                    if (response3 == 0) {
                        new Adminstrator().addTours();
                    } else if (response3 == 1) {
                        new Adminstrator().deleteTours();
                    } else if (response3 == 2) {
                        new Adminstrator().viewTours(1);
                    } else if (response3 == 3) {
                        new Adminstrator().writeResponce();
                    } else if (response3 == 4) {
                        new Adminstrator().viewFeedBack();
                    } else if (response3 == 5) {
                        new Adminstrator().viewBookingRequest();
                    } else if (response3 == 6) {
                        new Adminstrator().paymentView();
                    } else if (response3 == 7) {
                        new Adminstrator().viewRegisteration();
                    } else {

                        JOptionPane.showMessageDialog(null, "Admin logout successfull");
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "you enter incorrect password or user name ");
                    new Customer().Login(3);

                }
            } catch (Exception e) {
                new Customer().Login(3);
            }
        } else {

            //adminstrator chose activites he/she wants to do
            String[] choices = {"Add.T", "Delete.T", "View.T", "W.F.R", "View.F", "V.B.R", "V.P.G", "V.register", "logout"};
            int response3 = JOptionPane.showOptionDialog(null, "NB ---\nT is tours \n W.F.R is  write tour response\n"
                    + "V.register is view register customer in the ETTMS"
                    + "V.B.R is view booking request\n"
                    + "V.P.G is view ammount pay done by customer for booking\n "
                    + "F is feedback\n\n"
                    + "what activity do you want done? \n\n",
                    "choice for adminstrator actvites ", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[8]);

            if (response3 == 0) {
                new Adminstrator().addTours();
            } else if (response3 == 1) {
                new Adminstrator().deleteTours();
            } else if (response3 == 2) {
                new Adminstrator().viewTours(1);
            } else if (response3 == 3) {
                new Adminstrator().writeResponce();
            } else if (response3 == 4) {
                new Adminstrator().viewFeedBack();
            } else if (response3 == 5) {
                new Adminstrator().viewBookingRequest();
            } else if (response3 == 6) {
                new Adminstrator().paymentView();
            } else if (response3 == 7) {
                new Adminstrator().viewRegisteration();
            } else {

                JOptionPane.showMessageDialog(null, "Admin logout successfull");
                System.exit(0);
            }
        }
    }
}
