package customerActivitesBeforAndAfter;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Booking {

    private String firstName;
    private String secondName;
    private int departureDate;
    private int returnDate;
    private String bookingDate;
    private int numberOfPerson;
    private String departure_City;
    private int age[];

//    String getFullName(int a)
//    {
//        if(a==0)
//          return firstName;
//        else
//          return secondName;
//    }
    public void book() {
        int numberOfPersonCounter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\tbooking by customer ");
        System.out.println("\tDon't write space between  the word ");
        System.out.println("enter  F:\\ yourname booking.html");

        String fileName = scan.next();

        try (FileWriter x = new FileWriter(new File(fileName));
                FileWriter fw = new FileWriter(new File("F:\\allbooking.html"), true)) {
            JOptionPane.showMessageDialog(null, "write correctly the format get correct booking");

            System.out.println("enter your first name");
            firstName = scan.next();
            x.write("\n----------------------------------------------------------------------------------------------");
            x.append("\n----------------------------------------------------------------------------------------------");
            x.write("\nfirstName  :");
            x.write(firstName);
            fw.append("\nfirstName  :");
            fw.append(firstName);

            System.out.println("enter your second name");
            secondName = scan.next();
            x.write(" \nsecondName  :");
            x.write(secondName);
            fw.append(" \nsecondName  :");
            fw.append(secondName);

            try {
                System.out.println(" departure date");
                departureDate = scan.nextInt();
                if (departureDate < 32 && departureDate > 0) {
                    x.write(" \ndeparture date  :");
                    x.write(departureDate + "");
                    fw.append(" \ndeparture date  :");
                    fw.append(departureDate + "");
                } else {

                    // to close open file and delete immedetly if error occur
                    JOptionPane.showMessageDialog(null, "you enter invalid date!!\n\tTray again");
                    x.close();
                    fw.close();
                    File files = new File(fileName);
                    files.delete();
                    book();
                }
            } catch (InputMismatchException e) {

                JOptionPane.showMessageDialog(null, "you enter invalid input \n   try again\n");
                fw.close();
                x.close();
                File files = new File(fileName);
                files.delete();
                book();
            }

            System.out.println("return date");
            returnDate = scan.nextInt();

            try {
                //used to check correctness of date bettewen 0 and 31
                if (returnDate < 32 && returnDate > 0) {
                    x.write(" \nreturn date  :");
                    x.write(returnDate);
                    fw.append(" \nreturn date  :");
                    fw.append(returnDate + "");
                } else {

                    // to close open file and delete immedetly if error occur
                    JOptionPane.showMessageDialog(null, "you enter invalid date!!\n\tTray again");
                    fw.close();
                    x.close();
                    File files = new File(fileName);
                    files.delete();
                    book();
                }
            } catch (Exception e) {
                fw.close();
                x.close();
                File files = new File(fileName);
                files.delete();

                JOptionPane.showMessageDialog(null, "you enter invalid input \n   try again\n");
                book();
            }
            try {
                System.out.println("total number of persons");
                numberOfPerson = scan.nextInt();
                if (1 <= numberOfPerson) {
                    x.write(" \ntotal number of persons  :");
                    x.write(numberOfPerson);
                    if (2 <= numberOfPerson) {
                        System.out.println("please enter detail personal info ");

                        fw.append("\n.....all person that book with  " + firstName + "  " + secondName + "   see bellow.......");
                        x.write("\n.........all pesron book with you see bellow........... ");
                        for (int i = 0; i < numberOfPerson; i++) {
                            if (i == 0) {
                                System.out.println("enter your age ");
                                try {
                                    age[i] = scan.nextInt();
                                    x.write("\nage  :");
                                    fw.append("\nage  :");
                                    x.write(age[i]);
                                    fw.append(age + "");
                                    if (age[i] < 18) {
                                        System.out.println("youenter invalid age please try again");
                                        fw.close();
                                        x.close();
                                        File files = new File(fileName);
                                        files.delete();
                                        book();
                                    }
                                } catch (NumberFormatException nn) {
                                    fw.close();
                                    x.close();
                                    File files = new File(fileName);
                                    files.delete();
                                    book();
                                }
                            } else {
                                System.out.println("enter " + (i + 1) + " pesron detail information");
                                System.out.println("enter  first name");

                                firstName = scan.next();
                                x.write("\nfirstName  :");
                                x.write(firstName);
                                fw.append("\nfirstName  :");
                                fw.append(firstName);

                                System.out.println("enter  second name name");
                                secondName = scan.next();
                                x.write(" \nsecondName  :");
                                x.write(secondName);
                                fw.append(" \nsecondName  :");
                                fw.append(secondName);

                                System.out.println("enter age ");
                                try {
                                    age[i] = scan.nextInt();
                                    x.write("\nage  :");
                                    fw.append("\nage  :");
                                    x.write(age[i]);
                                    fw.append(age + "");
                                    if (age[i] < 1) {
                                        fw.close();
                                        x.close();
                                        File files = new File(fileName);
                                        files.delete();
                                        book();
                                    }
                                } catch (NumberFormatException mm) {
                                    fw.close();
                                    x.close();
                                    File files = new File(fileName);
                                    files.delete();
                                    book();
                                }
                            }
                        }
                    }
                    fw.append(" \ntotal number of persons  :");
                    fw.append(numberOfPerson + "");
                } else {

                    JOptionPane.showMessageDialog(null, "you enter invalid number of person!!\n\tTray again");
                    fw.close();
                    x.close();
                    File files = new File(fileName);
                    files.delete();
                    book();
                }
            } catch (InputMismatchException e) {

                JOptionPane.showMessageDialog(null, "you enter invalid input \n   try again\n");
                fw.close();
                x.close();
                File files = new File(fileName);
                files.delete();
                book();
            }

            System.out.println("deperture city");
            departure_City = scan.next();
            x.write(" \ndeparture city   :");
            x.write(departure_City);
            fw.append(" \ndeparture city   :");
            fw.append(departure_City);

            Date date = new Date();
            bookingDate = date.toString();
            x.write(" \nbooking date  :");
            x.write(bookingDate);
            fw.append(" \nbooking date :");
            fw.append(bookingDate);
            fw.close();
            x.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Booking is unsuccessfull!!");
            new Customer().Login(2);
        }

        JOptionPane.showMessageDialog(null, "Booking is successfull!!");

        String[] choices = {"Hotel", "Car Rental", "Ticket", "Back"};
        int response3 = JOptionPane.showOptionDialog(null, "what you want to reserve/Book! ", "customer reservation choice", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);
        if (response3 == 0) {
            if (2 <= numberOfPerson) {
                for (int i = 0; i < numberOfPerson; i++) {
                    if (18 < age[i]) {
                        numberOfPersonCounter++;
                    }
                }
            }
            double hotel = (departureDate - returnDate) * numberOfPersonCounter * 150.5;
            if (hotel < 0) {
                hotel = -1 * hotel;
            }
            // Payment kk = new Payment();
            new Payment().payForBook(hotel, "Hotel");

            JOptionPane.showMessageDialog(null, "hotel booking successfull!\n\tat xxx hotel");
            new Customer().Login(2);
        } else if (response3 == 1) {
            double carRental = 500.69;
            new Payment().payForBook(carRental, "Car Rental");

            JOptionPane.showMessageDialog(null, "car rental booking successfull!");
            new Customer().Login(2);
        } else if (response3 == 2) {

            String[] choicee = {"car", "plane"};
            int responses = JOptionPane.showOptionDialog(null, "what ticket do you want to reserve? ", "customer ticket reservation choice", 0, JOptionPane.QUESTION_MESSAGE, null, choicee, choicee[1]);
                if (2 <= numberOfPerson) {
                for (int i = 0; i < numberOfPerson; i++) {
                    if (10 < age[i]) {
                        numberOfPersonCounter++;
                    }
                }
            }
            if (responses == 0) {
                double ticket = numberOfPersonCounter * 460;
                new Payment().payForBook(ticket, "car Ticket");

                JOptionPane.showMessageDialog(null, "car ticket booking successfull!");
                new Customer().Login(2);
            } else if (responses == 1) {
                double ticket = numberOfPersonCounter * 2000.50;
                new Payment().payForBook(ticket, "plane Ticket");

                JOptionPane.showMessageDialog(null, "plane ticket booking successfull!");
                new Customer().Login(2);
            } else {
                File files = new File(fileName);
                files.delete();

                JOptionPane.showMessageDialog(null, "ticket booking unsuccessfull!");
                book();
            }
        } else {
            //customer chose back cause this 
            File files = new File(fileName);
            files.delete();

            JOptionPane.showMessageDialog(null, "your booking is cancel!!");
            new Customer().Login(2);
        }
    }

}
