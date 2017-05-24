package AdminstratorAndOthers;

import customerActivitesBeforAndAfter.Customer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tours {

    public String name;
    public String placeFound;
    public String region;
    public String type;

    //both fw.format and fw.write is the same
    void addTour() {
        Scanner scan = new Scanner(System.in);
        String[] choices = {"WterFall", "Religious", "Museum", "Park", "Lake", "HillStation", "Back"};
        int response = JOptionPane.showOptionDialog(null, "what types of tour do you want add? ", "Adding tour type choice", 0, JOptionPane.QUESTION_MESSAGE, null, choices, choices[6]);
        if (response == 0) {
            new WaterFall().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);
                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }
        } else if (response == 1) {
            new Religious().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);
                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }
        } else if (response == 2) {
            new Museum().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);
                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }
        } else if (response == 3) {
            new Park().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);
                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }
        } else if (response == 4) {
            new Lake().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);

                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }

        } else if (response == 5) {
            new HillStation().addTour();
            try {
                String aaa = JOptionPane.showInputDialog("Enter   1 add more tour \n\t any To go main menu ");
                int ccc = Integer.parseInt(aaa);
                if (ccc == 1) {
                    addTour();
                } else {
                    new Customer().Login(0);
                }
            } catch (NumberFormatException jj) {
                new Customer().Login(0);
            }
        } else {
            new Customer().Login(0);
        }
    }

}

class Religious extends Tours {

    //used to chiis mosqu or cherch
    public String typeOfReligious;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding religious tour please write exact information");
        String fileName = "F:\\allTours.html";
        String file = "F:\\tours\\Religious.html";

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

            System.out.println("this is adding park tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---religious---");
            x.append("\n\ntypes of tour ---religious---");
            System.out.println("Name of tour ");
            name = scan.next();
            fw.append("\nname of tour   :");
            fw.append(name);
            x.append("\nname of tour   :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place   :");
            fw.append(placeFound);
            x.append("\nfound place   :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.append("\nreligon  :");
            fw.append(region);
            x.append("\nreligon  :");
            x.append(region);

            System.out.println("enter type of rligious tour");
            System.out.println("either mosque,church,other...");
            typeOfReligious = scan.next();
            fw.append("\ntype of rligious");
            fw.append(typeOfReligious);
            x.append("\ntype of rligious");
            x.append(typeOfReligious);

            fw.close();
            x.close();
            type = "religious name";
            JOptionPane.showMessageDialog(null, type + " " + " ' " + name + " ' " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}

class HillStation extends Tours {

    public double altitude;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding hill station tour please write exact info");
        String fileName = "F:\\allTours.html";
        String file = "F:\\HillStation.html";

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

            System.out.println("this is adding museum tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---hill station---");
            x.append("\n\ntypes of tour ---hill station---");
            System.out.println(",Name of tour ");
            name = scan.next();
            fw.append("\nname of tour  :");
            fw.append(name);
            x.append("\nname of tour  :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place   :");
            fw.append(placeFound);
            x.append("\nfound place   :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.append("\nreligon   :");
            fw.append(region);
            x.append("\nreligon   :");
            x.append(region);

            System.out.println("enter altitude of hill station \n");
            altitude = scan.nextDouble();
            fw.append("\naltitude   :");
            fw.append(altitude + "");
            fw.append("\naltitude   :");
            fw.append(altitude + "");

            fw.close();
            x.close();
            type = "hill station name";
            JOptionPane.showMessageDialog(null, type + " " + " ' " + name + " ' " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}

class Park extends Tours {

    public String typeOfAnimal;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding park tour type please write exact info ");
        String fileName = "F:\\allTours.html";
        String file = "F:\\Park.html";

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

            System.out.println("this is adding park tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---park---");
            x.append("\n\ntypes of tour ---park---");
            System.out.println(",Name of tour ");
            name = scan.next();
            fw.append("\nname of tour  :");
            fw.append(name);
            x.append("\nname of tour  :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place  :");
            fw.append(placeFound);
            x.append("\nfound place  :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.write("\nreligon  :");
            fw.write(region);
            x.append("\nreligon  :");
            x.append(region);

            System.out.println("enter name animal fonud in the of park ");
            System.out.println("write name by comma separtion");
            typeOfAnimal = scan.next();
            fw.write("\ntype animal   :");
            fw.write(typeOfAnimal);
            x.append("\ntype animal   :");
            x.append(typeOfAnimal);

            fw.close();
            x.close();
            type = "park name";
            JOptionPane.showMessageDialog(null, type + " " + " ' " + name + " ' " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}

class WaterFall extends Tours {

    public double length;
    public double width;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding water fall tour type please writ exact info");
        String fileName = "F:\\allTours.html";
        String file = "F:\\WaterFall.html";

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

            System.out.println("\tthis is adding water fall tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---watreFall---");
            x.append("\n\ntypes of tour ---watreFall---");
            System.out.println("Name of tour ");
            name = scan.next();
            fw.append("\nname of tour  :");
            fw.append(name);
            x.append("\nname of tour  :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place  :");
            fw.append(placeFound);
            x.append("\nfound place  :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.append("\nregion  :");
            fw.append(region);
            x.append("\nregion  :");
            x.append(region);

            System.out.println("enter length/hight of water fall\n");
            length = scan.nextDouble();
            fw.append("\nlength   :");
            fw.append(length + "");
            x.append("\nlength   :");
            x.append(length + "");

            System.out.println("enter  width of water fall\n");
            width = scan.nextDouble();
            fw.append("\nwidth  :");
            fw.append(width + "");
            x.append("\nwidth  :");
            x.append(width + "");

            fw.close();
            x.close();
            type = "waterFall name";
            JOptionPane.showMessageDialog(null, type + " " + " ' " + name + " ' " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}

class Museum extends Tours {

    public String openDate;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding museum tour pleaes ads correctly");
        String fileName = "F:\\allTours.html";
        String file = "F:\\Museum.html";

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter x = new BufferedWriter(new FileWriter(file, true))) {

            System.out.println("this is adding park tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---museum---");
            x.append("\n\ntypes of tour ---museum---");
            System.out.println("Name of tour ");
            name = scan.next();
            fw.append("\nname of tour   :");
            fw.append(name);
            x.append("\nname of tour   :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place   :");
            fw.append(placeFound);
            x.append("\nfound place   :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.append("\nreligon   :");
            fw.append(region);
            x.append("\nreligon   :");
            x.append(region);
//     GregorianCalendar gc = new GregorianCalendar();
//     int year =1800 + (int)Math.round(Math.random() * (2009 - 1800));
//     gc.set(gc.YEAR, year);
//     int dayOfYear = 1 + (int)Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
//     gc.set(gc.DAY_OF_YEAR, dayOfYear);

            //validate date is must by try and actch                          
            System.out.println("enter the date of musuem date\n");
            System.out.println("year : month : day ");
            openDate = scan.next();
            fw.append("\nopen date   :");
            fw.append(openDate + "E.C");
            x.append("\nopen date   :");
            x.append(openDate + "E.C");
//                     fw.write(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

            fw.close();
            x.close();
            type = "museum name";
            JOptionPane.showMessageDialog(null, type + " " + " << " + name + " >> " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}

class Lake extends Tours {

    public double area;
    public double averageDepath;
    public String LakeType;

    @Override
    void addTour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("n\n\tadding lake tour type please add correctly");

        try (FileWriter fw = new FileWriter("F:\\allTours.html", true);
                BufferedWriter x = new BufferedWriter(new FileWriter("F:\\Lake.html", true))) {

            System.out.println("this is adding park tour type format \n\tplease write correct data  ");
            fw.append("\n\n-------------------------------------------------------------------------------------------");
            x.append("\n\n----------------------------------------------------------------------------------------------");
            fw.append("\n\ntypes of tour ---lake---");
            x.append("\n\ntypes of tour ---lake---");

            System.out.println("Name of tour ");
            name = scan.next();
            fw.append("\nname of tour    :");
            fw.append(name);
            x.append("\nname of tour    :");
            x.append(name);

            System.out.println("found place name.is recommend well known city ");
            placeFound = scan.next();
            fw.append("\nfound place    :");
            fw.append(placeFound);
            x.append("\nfound place    :");
            x.append(placeFound);

            System.out.println("region found");
            region = scan.next();
            fw.append("\nreligon    :");
            fw.append(region);
            x.append("\nreligon    :");
            x.append(region);

            System.out.println("enter area of lake \n");
            area = scan.nextDouble();
            fw.append("\narea of lake   :");
            fw.append(area + "");
            x.append("\narea of lake   :");
            x.append(area + "");

            System.out.println("enter average depeth\n");
            averageDepath = scan.nextDouble();
            fw.append("\naverage depeth   :");
            fw.append(averageDepath + "");
            x.append("\naverage depeth   :");
            x.append(averageDepath + "");

            System.out.println("type of of lake \n");
            System.out.println("enter from this natural or human_made\n");
            LakeType = scan.next();
            fw.append("\nlake type  :");
            fw.append(LakeType);
            x.append("\nlake type  :");
            x.append(LakeType);

            fw.close();
            x.close();
            type = "lake name";
            JOptionPane.showMessageDialog(null, type + " " + " ' " + name + " ' " + " \n add seccessfuly");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "adding tour unsuccessfull \n\ttry again!");
            addTour();
        }
    }
}
