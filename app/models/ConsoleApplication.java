/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleApplication {

    static Scanner sc = new Scanner(System.in);

    //creating an Instance of the PremierLeagueManager
    private static LeagueManager plm = PremierLeagueManager.getInstance();

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("***********************************************************");
        System.out.println("---------------------- W E L C O M E ----------------------");
        System.out.println("***********************************************************");

        main:
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println(" 1. Create a new Football club      ");
            System.out.println(" 2. Delete a Football club          ");
            System.out.println(" 3. Display stats of a Football club");
            System.out.println(" 4. Display Premier League Table    ");
            System.out.println(" 5. Add a played match              ");
            System.out.println(" 6. Open Graphical User Interface   ");
            System.out.println(" 7. Quit                            ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enter the number of the option you want to proceed :");
            String input1 = sc.next();
            System.out.println();

            switch (input1) {
                case "1":
                    createFootballClub();
                    continue main;
                case "2":
                    deleteFootballClub();
                    continue main;
                case "3":
                    displayStat();
                    continue main;
                case "4":
                    displayPLTable();
                    continue main;
                case "5":
                    addMatch();
                    continue main;
                case "6":
                    displayGUI();
                    continue main;
                case "7":
                    while (true) {
                        System.out.println("Are you sure you want to exit ? (y/n)");
                        String userInput = sc.next();
                        if (userInput.contains("y")) {
                            System.out.println();
                            System.out.println("Thank You!");
                            System.exit(0);
                            break main;
                        } else if (userInput.contains("n")) {
                            continue main;
                        } else System.out.println(" Invalid Input ! ");
                    }
                default:
                    System.out.println("**** Invalid Input ! ****");
                    System.out.println();
            }
        }
    }

    public static void createFootballClub() throws IOException, ClassNotFoundException {

        //loading data from file to the array lists
        plm.loadData();

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("****To go back to the menu enter 'Q'****");
            System.out.println();
            System.out.println("1. Name of the Football club :");
            String nameOfTheClub = sc.nextLine();

            if (nameOfTheClub.equals("Q")) {
                break;
            }

            System.out.println("2. Location of the Football club :");
            String location = sc.nextLine();

            if (location.equals("Q")) {
                break;
            }

            System.out.println("3. Registration Number of the Football club :");
            String regNo = sc.nextLine();

            if (regNo.equals("Q")) {
                break;
            }

            //creating a club from entered details.
            SportsClub fbClub = new FootballClub(nameOfTheClub, location, regNo, 0, 0, 0, 0, 0, 0, 0);

            //calling the method from premierLeagueManager and add the club to the array list.
            plm.createClub(fbClub);

            //saving data to the file from the array lists. This will also delete the data inside the array lists.
            plm.saveData();

            break;
        }
    }

    public static void deleteFootballClub() throws IOException, ClassNotFoundException {

        //loading data from file to the array lists
        plm.loadData();

        String nameOfTheClub;
        String regNo;
        String location;

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("****To go back to the menu enter 'Q'****");
            System.out.println();
            System.out.println("1. Name of the Football club :");
            nameOfTheClub = sc.nextLine();

            if (nameOfTheClub.equals("Q")) {
                break;
            }

            System.out.println("2. Location of the Football club :");
            location = sc.nextLine();

            if (location.equals("Q")) {
                break;
            }

            System.out.println("3. Registration Number of the Football club :");
            regNo = sc.nextLine();

            if (regNo.equals("Q")) {
                break;
            }

            //creating a club from entered details.
            SportsClub fbClub = new SportsClub(nameOfTheClub, location, regNo);

            //creating a temporary object from entered details for the validating purpose.
            FootballClub fbClub1Temp = new FootballClub(nameOfTheClub, location, regNo, 0, 0, 0, 0, 0, 0, 0);

            //validating the entered club for its existence.
            if (plm.validateClub(fbClub1Temp)) {
                //deleting the club from the array list
                plm.deleteClub(fbClub);
                //saving data to the file from the array lists. This will also delete the data inside the array lists.
                plm.saveData();
                break;
            } else {
                plm.saveData();
            }
        }
    }

    public static void displayStat() throws IOException, ClassNotFoundException {

        //loading data from file to the array lists
        plm.loadData();

        while (true) {

            System.out.println("----------------------------------------");
            System.out.println("****To go back to the menu enter 'Q'****");
            System.out.println();
            System.out.println("1. Name of the Football club : ");
            String nameOfTheClub = sc.nextLine();

            if (nameOfTheClub.equals("Q")) {
                break;
            }

            System.out.println("2. Location of the Football club : ");
            String location = sc.nextLine();

            if (location.equals("Q")) {
                break;
            }

            System.out.println("3. Registration Number of the Football club : ");
            String regNo = sc.nextLine();

            if (regNo.equals("Q")) {
                break;
            }

            //creating a club from entered details.
            SportsClub fbClub = new SportsClub(nameOfTheClub, location, regNo);

            //displaying the club stats.
            plm.displayStat(fbClub);

            //saving data to the file from the array lists. This will also delete the data inside the array lists.
            plm.saveData();

            break;
        }
    }

    public static void displayPLTable() throws IOException, ClassNotFoundException {
        //loading data from file to the array lists
        plm.loadData();
        //displaying standings
        plm.displayPLTable();
        //saving data to the file from the array lists. This will also delete the data inside the array lists.
        plm.saveData();
    }

    public static void addMatch() throws IOException, ClassNotFoundException {

        //loading data from file to the array lists
        plm.loadData();

        add:
        while (true) {
            String nameOfTheClub1;
            String regNo1 = null;
            String loc1 = null;

            String nameOfTheClub2;
            String regNo2 = null;
            String loc2 = null;

            club1:
            while (true) {
                System.out.println("----------------------------------------");
                System.out.println("****To go back to the menu enter 'Q'****");
                System.out.println();

                System.out.println("1. Name of the Football club 01 :");
                nameOfTheClub1 = sc.nextLine();

                if (nameOfTheClub1.equals("Q")) {
                    break add;
                }

                System.out.println("2. Reg No. of the Football club 01 :");
                regNo1 = sc.nextLine();

                if (regNo1.equals("Q")) {
                    break add;
                }

                System.out.println("3. Location of the Football club 01 :");
                loc1 = sc.nextLine();

                if (loc1.equals("Q")) {
                    break add;
                }

                //creating a temporary object from entered details for the validating purpose.
                FootballClub fbClub1Temp = new FootballClub(nameOfTheClub1, loc1, regNo1, 0, 0, 0, 0, 0, 0, 0);

                //validating the club.
                if (plm.validateClub(fbClub1Temp)) {
                    break club1;
                } else continue club1;
            }

            club2:
            while (true) {
                System.out.println("4. Name of the Football club 02 :");
                nameOfTheClub2 = sc.nextLine();

                if (nameOfTheClub2.equals("Q")) {
                    break add;
                }

                System.out.println("5. Reg No. of the Football club 02 :");
                regNo2 = sc.nextLine();

                if (regNo2.equals("Q")) {
                    break add;
                }

                System.out.println("6. Location of the Football club 02 :");
                loc2 = sc.nextLine();

                if (loc2.equals("Q")) {
                    break add;
                }

                //creating a temporary object from entered details for the validating purpose.
                FootballClub fbClub2Temp = new FootballClub(nameOfTheClub2, loc2, regNo2, 0, 0, 0, 0, 0, 0, 0);

                //validating the club.
                if (plm.validateClub(fbClub2Temp)) {
                    break club2;
                } else continue club2;
            }

            System.out.println("7. Score of the Football club 01 :");

            while (!sc.hasNextInt()) {
                if (sc.hasNext("Q")) {
                    break add;
                }
                System.out.print("Please enter a valid score for the Football Club 01 :");
                sc.next();
            }

            int score1 = sc.nextInt();
            sc.nextLine();

            System.out.println("8. Score of the Football club 02 :");

            while (!sc.hasNextInt()) {
                if (sc.hasNext("Q")) {
                    break add;
                }
                System.out.print("Please enter a valid score for the Football Club 02 :");
                sc.next();
            }

            int score2 = sc.nextInt();
            sc.nextLine();

            System.out.println("9. Points for Football club 01 :");

            while (!sc.hasNextInt()) {
                if (sc.hasNext("Q")) {
                    break add;
                }
                System.out.print("Please enter a valid points for the Football Club 01 :");
                sc.next();
            }

            int points1 = sc.nextInt();
            sc.nextLine();

            System.out.println("10. Points for Football club 02 :");

            while (!sc.hasNextInt()) {
                if (sc.hasNext("Q")) {
                    break add;
                }
                System.out.print("Please enter a valid points for the Football Club 02 :");
                sc.next();
            }

            int points2 = sc.nextInt();
            sc.nextLine();

            //creating objects of both clubs from the entered details.
            //Scores and points for the both clubs will be temporarily saved inside the goalsScored, goalsReceived and points parameters.
            FootballClub fbClub1 = new FootballClub(nameOfTheClub1, loc1, regNo1, 0, 0, 0, score2, score1, points1, 0);
            FootballClub fbClub2 = new FootballClub(nameOfTheClub2, loc2, regNo2, 0, 0, 0, score1, score2, points2, 0);

            //adding the match to the array list and updating the club stats at the same time.
            plm.addMatch(fbClub1, fbClub2);

            //saving data to the file from the array lists. This will also delete the data inside the array lists.
            plm.saveData();

            break;
        }
    }

    public static void displayGUI() throws IOException {

        //this will invoke the 'sbt run' command and eventually redirect to the browser.
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "sbt run");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        System.out.println("Opening Graphical User Interface in the Browser...");
        System.out.println();

        char[] animationChars = new char[]{'|', '/', '-', '\\'};
        for (int i = 0; i <= 100; i++) {
            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Processing: Done!          ");

        System.out.println();
    }

}
