package customerActivitesBeforAndAfter;

import AdminstratorAndOthers.Adminstrator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Customer {

    public String firstName;
    public String secondName;
    public String country;
    public String email;
    private String password;
    private String userName;
    public char sex;
    public int age;

    public class FeedBack {

        // attribute declartion is  no necessary in this b/c feedback is inner class of cutomer 
        // so access from customer class to do more  secure
        private void add() {

            Scanner scan = new Scanner(System.in);
            System.out.println("n\n\tadding feedback by customer");
            System.out.println("\tDon't write space between  the word ");
            System.out.println("\tenter  F:\\ yourname feedback.html");
            String fileName = scan.next();

            File file = new File("F:\\feed Back.html");
            try (PrintWriter fw = new PrintWriter(new File(fileName));
                    BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

                x.append("\n\n\t\tcustomer feed back :");
                x.append("\n-----------------------------------------------------------------------------------------");
                System.out.println("enter your name");
                firstName = scan.next();
                fw.write("\nname ");
                fw.write(firstName);
                x.append("\nname ");
                x.append(firstName);

                System.out.println("enter your email");
                email = scan.next();
                fw.write("\nemail ");
                fw.write(email);
                x.append("\nemail ");
                x.append(email);

                System.out.println("after you finsh writing your commnet write in new line only //'done//'");
                System.out.println("\n\n\twrite your comment or qustion here\n");
                fw.write("\ncomment and question   :");
                x.append("\ncomment and question    :");
                String line;
                while ((line = scan.nextLine()) != null) {
                    if (line.trim().equalsIgnoreCase("done")) {

                        JOptionPane.showMessageDialog(null, "your comment and qustion send sucessfull!");
                        x.close();
                        fw.close();
                        String[] choices = {"Delete", "View", "Add", "Back"};
                        int response3 = JOptionPane.showOptionDialog(null, "what do you want in your feedback?", "comment and qustions", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);
                        if (response3 == 0) {
                            delete();
                        } else if (response3 == 1) {
                            view();
                        } else if (response3 == 2) {
                            add();
                        } else {
                            Login(2);
                        }
                    }
                    fw.write(line);
                    x.append(line);
                }
                //uded to check vilidaion of file name
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "invalid file name. \n\ttray again!!");
                add();
            }
        }

        public void view() {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\tview feedback by customer");
            System.out.println("\tDon't write space between  the word ");
            System.out.println("\tenter  F:\\ yourname feedback.html");
            String fileName = scan.next();
            //customer at the time os view feed back feedback writen in individual and system file name
            String line;
            String file = "F:\\feed Back.html";
            try {
                FileReader fileReader = new FileReader(fileName);
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    System.out.println("\n\t\tyour feed back \n");
                    while ((line = bufferedReader.readLine()) != null) {
//                        Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                        voice.allocate();
//                        voice.setRate(120);
//                        voice.setPitch(100);
//                        voice.speak(line);
                        System.out.println(line);
                    }
                } catch (Exception aa) {

                    JOptionPane.showMessageDialog(null, "view feed back operaion failed\n\tTry again!!");
                    Login(2);

                }

                try (BufferedReader bufferedReader1 = new BufferedReader(fileReader)) {
                    System.out.println("\n\t\tall system feed back \n");
                    while ((line = bufferedReader1.readLine()) != null) {
//                        Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                        voice.allocate();
//                        voice.setRate(120);
//                        voice.setPitch(100);
//                        voice.speak(line);
                        System.out.println(line);
                    }
                } catch (Exception aa) {

                    JOptionPane.showMessageDialog(null, "view feed back operaion failed\n\tTry again!!");
                    Login(2);
                    //use viewfeedback is possible but thre is recursion                   
                }

            } catch (FileNotFoundException ex) {

                JOptionPane.showMessageDialog(null, "there is no  '" + fileName + "'  file"
                        + "\n\tview feed back operaion failed");
                Login(2);
            }
            String[] choices = {"Delete", "View", "Add", "Back"};
            int response3 = JOptionPane.showOptionDialog(null, "what do you want in your feedback?", "comment and qustions", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);
            if (response3 == 0) {
                delete();
            } else if (response3 == 1) {
                view();
            } else if (response3 == 2) {
                add();
            } else {
                Login(2);
            }

        }

        //b/c this in individual feedback but all feedback view and other operation done by admin 
        // admin can be delete comment  from system   
        private void delete() {
            Scanner scan = new Scanner(System.in);
            System.out.println("n\n\tdelete feedback by customer");
            System.out.println("\tDon't write space between  the word ");
            System.out.println("\tenter  F:\\ yourname feedback.html");
            String fileName = scan.next();
            try {
                File file = new File(fileName);
                if (file.delete()) {

                    JOptionPane.showMessageDialog(null, file.getName() + " is deleted!");
                    Login(2);
                } else {

                    JOptionPane.showMessageDialog(null, "feedback Delete operation is failed.");
                    Login(2);
                }
            } catch (Exception e) {
                Login(2);
            }

            String[] choices = {"Delete", "View", "Add", "Back"};
            int response3 = JOptionPane.showOptionDialog(null, "what do you want in your feedback?", "comment and qustions", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);
            if (response3 == 0) {
                delete();
            } else if (response3 == 1) {
                view();
            } else if (response3 == 2) {
                add();
            } else {
                Login(2);
            }
        }
    }

    public void viewDetail() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\tuser view registration form ");
        System.out.println("\tDon't write space between  the word ");
        System.out.println("\tenter  F:\\ yourname register");
        String fileName = scan.next();
        String line;
        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
//                Voice voice = VoiceManager.getInstance().getVoice(new User().VOICENAME);
//                voice.allocate();
//                voice.setRate(120);
//                voice.setPitch(100);
//                voice.speak(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "account view operation is failed ");
            Login(2);
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "customer registred file reading error");
            Login(2);
        }
        Login(2);
    }

    private void deleteAccount() {

        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tdelete user account by user");
        System.out.println("\tDon't write space between  the word ");
        System.out.println("\tenter  F:\\ yourname register.txt");
        String fileName = scan.next();
        File file;
        try {
            file = new File(fileName);
            if (file.delete()) {

                JOptionPane.showMessageDialog(null, file.getName() + " is deleted!");
                Login(2);
            } else {

                JOptionPane.showMessageDialog(null, "Delete operation is failed.");
                Login(2);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Delete operation is failed.");
            Login(2);
        }
    }

    private void editacount() {
        String[] choicc = {"yes", "cancel"};
        int aaa = JOptionPane.showOptionDialog(null, "are you shure to edit you account", "", 0, JOptionPane.QUESTION_MESSAGE, null, choicc, choicc[1]);
        if (aaa == 0) {

            Scanner scan = new Scanner(System.in);
            System.out.println("n\n\tediting  user account by user");
            System.out.println("\tDon't write space between  the word ");
            System.out.println("\tenter  F:\\ yourname register.txt");
            String fileName = scan.next();

            File file;
            try {
                file = new File(fileName);
                if (file.delete()) {

                    JOptionPane.showMessageDialog(null, "your account is open to edit \n \t you can edit now!!");
                    System.out.println("\n\n\tnew registration form after delete the old account");
                    createAccount(1);
                } else {

                    JOptionPane.showMessageDialog(null, "Edit operation is failed.");
                    Login(2);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "account edit operation is failed.");
                Login(2);
            }

        } else {
            Login(2);
        }
    }

    public void Login(int y) {
        if (y == 1) {
            int a = 0;
            Scanner scan = new Scanner(System.in);
            System.out.println("\tenter  F:\\ yourname key.html");
            String fileName = scan.next();
            try {
                System.out.println();

                String name = JOptionPane.showInputDialog(null, "customer tour and travel login form" + "\n\t\tenter user name");
                String password = JOptionPane.showInputDialog(null, "customer tour and travel login form" + "\n\t\tenter password");

                String line;
                try (FileReader fileReader = new FileReader(fileName);
                        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    System.out.println("\n\t\tyour feed back \n");
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.compareTo(name) == 0) {
                            a++;
                        } else if (line.compareTo(password) == 0) {
                            a++;
                        }
                    }
                } catch (Exception aa) {

                    JOptionPane.showMessageDialog(null, "you enter in correct name \n\n\tplease try again ");
                    Login(1);

                }
                if (a == 2) {

                    JOptionPane.showMessageDialog(null, "customere login successful!");

                    String[] choices = {"About ETTMS", "Booking", "Payment", "View Tours", "FeedBack", "View", "Delete", "Edit", "logout"};
                    int response3 = JOptionPane.showOptionDialog(null, "What do you want?\n\n"
                            + "\nveiw detail is to view registration for\n"
                            + " delet to delete registration form from the system\n"
                            + " edit used to edit registration form", "Ethiopian tour and travel management menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[8]);

                    if (response3 == 0) {
                        String ettms;
                        try (FileReader fileReader = new FileReader("F:\\ETTMS.html");
                                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                            System.out.println("\n\t\tabout ethiopian tour and travel managemnt system \n");
                            while ((ettms = bufferedReader.readLine()) != null) {
                                System.out.println(ettms);
                            }
                        } catch (Exception aa) {

                            JOptionPane.showMessageDialog(null, "view feed back operaion failed\n\tTry again!!");
                            Login(2);

                        }
                        Login(2);
                    } else if (response3 == 1) {
                        new Booking().book();

                    } else if (response3 == 2) {

                        JOptionPane.showMessageDialog(null, "Befor payment you must reserve/book something");
                        new Booking().book();

                    } else if (response3 == 3) {
                        new Adminstrator().viewTours(0);

                    } else if (response3 == 4) {
                        //          User user = new User();
                        //          User.FeedBack fd = user.new FeedBack();
                        //the same us above
                        Customer.FeedBack fd = new Customer().new FeedBack();
                        String[] choicess = {"Delete", "View", "Add", "Back"};
                        int response = JOptionPane.showOptionDialog(null, "what do you want in your feedback?", "comment and qustions", 0, JOptionPane.QUESTION_MESSAGE, null, choicess, choicess[3]);
                        if (response == 0) {
                            fd.delete();
                        } else if (response == 1) {
                            fd.view();
                        } else if (response == 2) {
                            fd.add();
                        } else {
                            Login(2);
                        }
                    } else if (response3 == 5) {
                        new Customer().viewDetail();
                    } else if (response3 == 6) {
                        new Customer().deleteAccount();
                    } else if (response3 == 7) {
                        new Customer().editacount();
                    } else {

                        JOptionPane.showMessageDialog(null, "customer logout successfull");
                        System.exit(0);
                    }
                    //*******************

                } else {

                    JOptionPane.showMessageDialog(null, "you enter incorrect password or user name ");
                    Login(1);
                }
            } catch (Exception e) {
                Login(1);
            }
        } else if (y == 2) {
            String[] choices = {"About ETTMS", "Booking", "Payment", "View Tours", "FeedBack", "View", "Delete", "Edit", "logout"};
            int response3 = JOptionPane.showOptionDialog(null, "What do you want?\n\n"
                    + "\nveiw detail is to view registration for\n"
                    + " delet to delete registration form from the system\n"
                    + " edit used to edit registration form", "Ethiopian tour and travel management menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[8]);

            if (response3 == 0) {
                String ettms;
                try (FileReader fileReader = new FileReader("F:\\ETTMS.html");
                        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    System.out.println("\n\t\tabout ethiopian tour and travel managemnt system \n");
                    while ((ettms = bufferedReader.readLine()) != null) {
                        System.out.println(ettms);
                    }
                } catch (Exception aa) {

                    JOptionPane.showMessageDialog(null, "view feed back operaion failed\n\tTry again!!");
                    Login(2);

                }
                Login(2);
            } else if (response3 == 1) {
                new Booking().book();

            } else if (response3 == 2) {

                JOptionPane.showMessageDialog(null, "Befor payment you must reserve/book something");
                new Booking().book();

            } else if (response3 == 3) {
                new Adminstrator().viewTours(0);

            } else if (response3 == 4) {
                //          User user = new User();
                //          User.FeedBack fd = user.new FeedBack();
                //the same us above
                Customer.FeedBack fd = new Customer().new FeedBack();
                String[] choicess = {"Delete", "View", "Add", "Back"};
                int response = JOptionPane.showOptionDialog(null, "what do you want in your feedback?", "comment and qustions", 0, JOptionPane.QUESTION_MESSAGE, null, choicess, choicess[3]);
                if (response == 0) {
                    fd.delete();
                } else if (response == 1) {
                    fd.view();
                } else if (response == 2) {
                    fd.add();
                } else {
                    Login(2);
                }
            } else if (response3 == 5) {
                new Customer().viewDetail();
            } else if (response3 == 6) {
                new Customer().deleteAccount();
            } else if (response3 == 7) {
                new Customer().editacount();
            } else {

                JOptionPane.showMessageDialog(null, "customer logout successfull");
                System.exit(0);
            }
        } else {
            if (y == 3) {
                new Adminstrator().Login(3);
            } else {
                new Adminstrator().Login(0);
            }
        }

    }

    public void createAccount(int a) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\t WELL-COME TO ETHIOPIAN TOUR AND TRAVEL  SYSTEM  \n\t\t\tPALEASE CREATE ACCOUNT ");
        System.out.println("enter  F:\\ yourname register only with out extension");
        String fileName = scan.next();

        File file = new File("F:\\allCustomerList.html");
        try (FileWriter fw = new FileWriter(new File(fileName + ".html"));
                FileWriter fw2 = new FileWriter(new File(fileName + "key.html"));
                FileWriter fileWriter = new FileWriter(file, true)) {

            System.out.println("\tETHIOPIA TOUR and TRAVEL MANAGEMENT SYSTEM REGISTRATION FORM \n\n");
            fw.write("\n----------------------------------------------------------------------------------------------");
            fileWriter.append("\n----------------------------------------------------------------------------------------------");
            System.out.println("your first  name");
            fileWriter.append("\n  first name :");
            firstName = scan.next();
            fileWriter.append(firstName);
            fw.write("\n  first name :");
            fw.write(firstName);

            System.out.println("your second  name");
            fileWriter.append("\n  second  name :");
            secondName = scan.next();
            fileWriter.append(secondName);
            fw.write("\n  second  name :");
            fw.write(secondName);

            System.out.println("enter your   age");
            fileWriter.append("\n  age :");
            age = scan.nextInt();
            fileWriter.append(age + "");
            fw.write("\n  age :");
            fw.write(age + "");

            System.out.println("create your user name ");
            password = scan.next();
            fw2.write(password);
            System.out.println("create your password ");
            userName = scan.next();
            fw2.write("\n" + userName);

            fileWriter.append("\n  sex :");

            fw.write("\n  sex :");
            String[] chance = {"Male", "Female "};
            int response = JOptionPane.showOptionDialog(null, "chose you sex", "customer registration gender choice",
                    0, JOptionPane.QUESTION_MESSAGE, null, chance, chance[0]);
            if (response == 0) {

                fileWriter.append("M");
                fw.write("M");
            } else {
                fw.write("F");
                fileWriter.append("F");
            }

            System.out.println("your countery name");
            fileWriter.append("\n  countery name :");
            country = scan.next();
            fileWriter.append(country);
            fw.write("\n  countery name :");
            fw.write(country);

            fileWriter.append("\n  registration date  :");
            fileWriter.append(new Date().toString());
            fw.write("\n  registration date  :");
            fw.write(new Date().toString() + "\n\n");
            fw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "your registration is successfull!!!"
                    + JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "your registration is failed!!!" + "\n\n\tplease try again!!!"
                    + JOptionPane.INFORMATION_MESSAGE);
            new User().browsSystem();
        }

        //used to goto the privous place 
        // 1 is call from edit accout so customer not again login to the system 
        // 1 is call from edit account so customret go back to customer choice
        // is any customer is new to the sysyem / not loginn to the system 
        // so customer is must login to the system to access system    
        if (a == 1) {
            Login(2);
        } else {
            new User().browsSystem();
        }
    }
}
