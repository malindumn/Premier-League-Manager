/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package models;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    //creating file to save the data.
    public File saveFileFootballClubs = new File("E:\\2nd Year\\OOP\\Coursework - Premier League\\CW - Submission  - Final\\Implementation\\datasource\\saveDataClubs.txt");
    public File saveFilePlayedMatches = new File("E:\\2nd Year\\OOP\\Coursework - Premier League\\CW - Submission  - Final\\Implementation\\datasource\\saveDataMatches.txt");

    private static PremierLeagueManager premierLeagueManager;

    private static final int MAX_NUM_OF_CLUBS = 20;

    //creating array lists to hold the data.
    private List<FootballClub> listOfClubsAdded = new ArrayList<>();
    private List<Match> listOfMatches = new ArrayList<>();

    private PremierLeagueManager() {}

    public static PremierLeagueManager getInstance() {
        if(premierLeagueManager == null){
            synchronized (PremierLeagueManager.class) {
                if (premierLeagueManager == null){
                    premierLeagueManager = new PremierLeagueManager();
                }
            }
        }
        return premierLeagueManager;
    }

    public List<FootballClub> getListOfClubsAdded() {
        return listOfClubsAdded;
    }

    public List<Match> getListOfMatches() {
        return listOfMatches;
    }

    @Override
    public void createClub(SportsClub fbClub) {

        boolean exists = false;

        //checking if the list exceeding the maximum number of clubs that can be added.
        if (listOfClubsAdded.size() == MAX_NUM_OF_CLUBS){
            System.out.println();
            System.out.println("Sorry to inform that the maximum number of clubs (20) has already been assigned to the premier league table.");
        }

        for (FootballClub club : listOfClubsAdded){
            //validating the club for its existence.
            if (fbClub.getRegNo().equals(club.getRegNo())){
                System.out.println();
                System.out.println("This Club Reg. No is already being used.");
                System.out.println();
                exists = true;
                break;
            }
            if (fbClub.equals(club)){
                System.out.println();
                System.out.println("This Club is already Added.");
                System.out.println();
                exists = true;
                break;
            }
        }

        //if club is not added yet, it will be added to the list.
        if (!exists) {
            listOfClubsAdded.add((FootballClub) fbClub);

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Your club has been successfully added.");
            System.out.println("--------------------------------------");
            System.out.println();
        }

    }

    @Override
    public void deleteClub(SportsClub fbClub) {

        for (FootballClub fbClub1 : listOfClubsAdded) {
            //checking if the club is in the list.
            if (fbClub1.getNameOfTheClub().equals(fbClub.getNameOfTheClub()) && fbClub1.getLocation().equals(fbClub.getLocation()) && fbClub1.getRegNo().equals(fbClub.getRegNo())){
                //removing the club.
                listOfClubsAdded.remove(fbClub1);
                System.out.println();
                System.out.println("The Club '" + fbClub.getNameOfTheClub() + "' which is located in " + fbClub.getLocation() + " under Registration Number of " + fbClub.getRegNo() + " has been successfully deleted.");
                System.out.println();
                break;
            }
        }
    }

    @Override
    public void displayStat(SportsClub fbClub) {

        boolean exists = false;

        for (FootballClub fbClub1 : listOfClubsAdded) {
            //checking club for its existence.
            if (fbClub1.getNameOfTheClub().equals(fbClub.getNameOfTheClub()) && fbClub1.getLocation().equals(fbClub.getLocation()) && fbClub1.getRegNo().equals(fbClub.getRegNo())) {
                System.out.println();
                System.out.println("===================================================");
                System.out.println(" Football Club       : " + fbClub.getNameOfTheClub()) ;
                System.out.println(" Location            : " + fbClub.getLocation());
                System.out.println(" Registration Number : " + fbClub.getRegNo());
                System.out.println("===================================================");
                System.out.println(" Total Wins----------------------: " + fbClub1.getWins());
                System.out.println(" Total Draws---------------------: " + fbClub1.getDraws());
                System.out.println(" Total Defeats-------------------: " + fbClub1.getDefeats());
                System.out.println(" Total Received Goals------------: " + fbClub1.getGoalsReceived());
                System.out.println(" Total Scored Goals--------------: " + fbClub1.getGoalsScored());
                System.out.println(" Total Points of the Club--------: " + fbClub1.getPoints());
                System.out.println(" Total Number of matches played--: " + fbClub1.getNumOfMatchesPlayed());
                System.out.println("---------------------------------------------------");
                System.out.println();
                exists = true;
                break;
            }
        }

        //if the club is not there, an error message will be shown.
        if (!exists) {
            System.out.println();
            System.out.println("Entered details do not exist in our data. Please check again.");
            System.out.println();
        }
    }

    @Override
    public void displayPLTable() {

        //checking if the list is empty.
        if (listOfClubsAdded.isEmpty()) {
            System.out.println("There are no clubs currently added to the system.");
            System.out.println();
        } else {
            //sorting the data inside the array list.
            Collections.sort(listOfClubsAdded);
            System.out.println("---------------------------------- P R E M I E R   L E A G U E   S T A N D I N G S ---------------------------------");
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %40s | %15s | %15s | %15s | %15s |%n", "Club Name - Reg No.          ", "Points    ", "Goals Scored ", "Goals Received", "Goal Difference");
            System.out.println("+==================================================================================================================+");
            for (FootballClub fbClub : listOfClubsAdded) {
                System.out.format("| %40s | %15s | %15s | %15s | %15s |%n", fbClub.getNameOfTheClub() + " - " + fbClub.getRegNo(), fbClub.getPoints()+ "       ", fbClub.getGoalsScored()+ "       ", fbClub.getGoalsReceived()+ "       ", (fbClub.getGoalsScored()-fbClub.getGoalsReceived())+ "       ");
            }
            System.out.println("+------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
        }
    }

    @Override
    public void addMatch(FootballClub fbClub1, FootballClub fbClub2) {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //declaring objects to hold the clubs.
        FootballClub firstClub = null;
        FootballClub secondClub = null;

        //checking if the firstClub wins.
        if (fbClub1.getGoalsScored() > fbClub2.getGoalsScored()) {
            for (FootballClub club : listOfClubsAdded) {
                if (fbClub1.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub1.getLocation().equals(club.getLocation()) && fbClub1.getRegNo().equals(club.getRegNo())) {
                    //initializing the firstClub object with the actual object from the array list.
                    firstClub = club;

                    //updating the stats of the club.
                    club.setWins(club.getWins() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub1.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub2.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub1.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
                if (fbClub2.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub2.getLocation().equals(club.getLocation()) && fbClub2.getRegNo().equals(club.getRegNo())) {
                    //initializing the secondClub object with the actual object from the array list.
                    secondClub = club;

                    //updating the stats of the club.
                    club.setDefeats(club.getDefeats() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub2.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub1.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub2.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
            }

            //checking if the secondClub wins.
        } else if (fbClub2.getGoalsScored() > fbClub1.getGoalsScored()) {
            for (FootballClub club : listOfClubsAdded) {
                if (fbClub2.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub2.getLocation().equals(club.getLocation()) && fbClub2.getRegNo().equals(club.getRegNo())) {
                    //initializing the secondClub object with the actual object from the array list.
                    secondClub = club;

                    //updating the stats of the club.
                    club.setWins(club.getWins() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub2.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub1.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub2.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
                if (fbClub1.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub1.getLocation().equals(club.getLocation()) && fbClub1.getRegNo().equals(club.getRegNo())) {
                    //initializing the firstClub object with the actual object from the array list.
                    firstClub = club;

                    //updating the stats of the club.
                    club.setDefeats(club.getDefeats() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub1.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub2.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub1.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
            }
            //checking if the match is a draw.
        } else {
            for (FootballClub club : listOfClubsAdded) {
                if (fbClub1.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub1.getLocation().equals(club.getLocation()) && fbClub1.getRegNo().equals(club.getRegNo())) {
                    //initializing the firstClub object with the actual object from the array list.
                    firstClub = club;

                    //updating the stats of the club.
                    club.setDraws(club.getDraws() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub1.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub2.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub1.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
                if (fbClub2.getNameOfTheClub().equals(club.getNameOfTheClub()) && fbClub2.getLocation().equals(club.getLocation()) && fbClub2.getRegNo().equals(club.getRegNo())) {
                    //initializing the secondClub object with the actual object from the array list.
                    secondClub = club;

                    //updating the stats of the club.
                    club.setDraws(club.getDraws() + 1);
                    club.setGoalsScored(club.getGoalsScored() + fbClub2.getGoalsScored());
                    club.setGoalsReceived(club.getGoalsReceived() + fbClub1.getGoalsScored());
                    club.setPoints(club.getPoints() + fbClub1.getPoints());
                    club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                }
            }
        }

        //creating the Match object from given data.
        Match match = new Match(firstClub.getNameOfTheClub(), secondClub.getNameOfTheClub(), fbClub1.getGoalsScored(), fbClub2.getGoalsScored(), fbClub1.getPoints(), fbClub2.getPoints(), now.format(dtf));

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("The Match has been successfully added to the records.");
        System.out.println("-----------------------------------------------------");
        System.out.println();

        //adding match to the list.
        listOfMatches.add(match);

    }

    @Override
    public boolean validateClub(FootballClub fbClub) {

        boolean existsClub = false;

        for (FootballClub club : listOfClubsAdded) {
            if (club.getNameOfTheClub().equals(fbClub.getNameOfTheClub()) && club.getLocation().equals(fbClub.getLocation()) && club.getRegNo().equals(fbClub.getRegNo())) {
                existsClub = true;
                break;
            }
        }

        if (!existsClub) {
            System.out.println();
            System.out.println("Club does not exist in our data. Please check again.");
            System.out.println();
        }

        return existsClub;
    }

    @Override
    public void saveData() throws IOException {

        FileOutputStream fos1 = new FileOutputStream(saveFileFootballClubs);
        FileOutputStream fos2 = new FileOutputStream(saveFilePlayedMatches);

        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

        for(FootballClub club : listOfClubsAdded){
            oos1.writeObject(club);
        }

        for(Match match : listOfMatches){
            oos2.writeObject(match);
        }

        oos1.flush();
        fos1.close();
        oos1.close();
        oos2.flush();
        fos2.close();
        oos2.close();

        //clearing the array list after saving the data to the array. In this way files are the only data source for the application.
        listOfClubsAdded.clear();
        listOfMatches.clear();
    }

    @Override
    public void loadData() throws IOException {

        //checking if the files are exist and they have data inside them
        if ((saveFileFootballClubs.exists() && saveFileFootballClubs.length() != 0) || (saveFilePlayedMatches.exists() && saveFilePlayedMatches.length() != 0)) {

            FileInputStream fis1 = new FileInputStream(saveFileFootballClubs);
            FileInputStream fis2 = new FileInputStream(saveFilePlayedMatches);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);

            for (; ; ) {
                try {
                    FootballClub fbClub = (FootballClub) ois1.readObject();
                    listOfClubsAdded.add(fbClub);
                } catch (Exception e) {
                    break;
                }
            }

            for (; ; ) {
                try {
                    Match match = (Match) ois2.readObject();
                    listOfMatches.add(match);
                } catch (Exception e) {
                    break;
                }
            }

            fis1.close();
            ois1.close();
            fis2.close();
            ois2.close();
        }
    }

    @Override
    public void addRandomMatch(List<Match> matchList) {

        //checking the list if its empty or if it contains only one club. To play a match there should be al least two clubs.
        if (!listOfClubsAdded.isEmpty() && listOfClubsAdded.size() >= 2) {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            FootballClub randomClub1;
            FootballClub randomClub2;

            Random rand = new Random();

            randomClub1 = listOfClubsAdded.get(rand.nextInt(listOfClubsAdded.size()));

            while (true) {
                randomClub2 = listOfClubsAdded.get(rand.nextInt(listOfClubsAdded.size()));
                //checking if the first randomly generated club is not equals to the second randomly generated club.
                if (randomClub2.equals(randomClub1)) {
                    continue;
                }
                break;
            }

            int pointsClub1 = 0;
            int pointsClub2 = 0;

            int scoreClub1 = rand.nextInt(11);
            int scoreClub2 = rand.nextInt(11);

            if (scoreClub1 > scoreClub2) {
                pointsClub1 = 3;
            } else if (scoreClub2 > scoreClub1) {
                pointsClub2 = 3;
            } else {
                pointsClub1 = 1;
                pointsClub2 = 1;
            }

            //checking if the randomClub1 wins.
            if (scoreClub1 > scoreClub2) {
                for (FootballClub club : listOfClubsAdded) {
                    if (club.getRegNo().equals(randomClub1.getRegNo())) {
                        //updating the stats of the club.
                        club.setWins(club.getWins() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub1);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub2);
                        club.setPoints(club.getPoints() + pointsClub1);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                    if (club.getRegNo().equals(randomClub2.getRegNo())) {
                        //updating the stats of the club.
                        club.setDefeats(club.getDefeats() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub2);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub1);
                        club.setPoints(club.getPoints() + pointsClub2);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                }
                //checking if the randomClub2 wins.
            } else if (scoreClub2 > scoreClub1) {
                for (FootballClub club : listOfClubsAdded) {
                    if (club.getRegNo().equals(randomClub2.getRegNo())) {
                        //updating the stats of the club.
                        club.setWins(club.getWins() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub2);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub1);
                        club.setPoints(club.getPoints() + pointsClub2);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                    if (club.getRegNo().equals(randomClub1.getRegNo())) {
                        //updating the stats of the club.
                        club.setDefeats(club.getDefeats() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub1);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub2);
                        club.setPoints(club.getPoints() + pointsClub1);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                }
                //checking if the match is a draw.
            } else {
                for (FootballClub club : listOfClubsAdded) {
                    if (club.getRegNo().equals(randomClub1.getRegNo())) {
                        //updating the stats of the club.
                        club.setDraws(club.getDraws() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub1);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub2);
                        club.setPoints(club.getPoints() + pointsClub1);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                    if (club.getRegNo().equals(randomClub2.getRegNo())) {
                        //updating the stats of the club.
                        club.setDraws(club.getDraws() + 1);
                        club.setGoalsScored(club.getGoalsScored() + scoreClub2);
                        club.setGoalsReceived(club.getGoalsReceived() + scoreClub1);
                        club.setPoints(club.getPoints() + pointsClub2);
                        club.setNumOfMatchesPlayed(club.getNumOfMatchesPlayed() + 1);
                    }
                }
            }

            //creating the Match object from given data.
            Match match = new Match(randomClub1.getNameOfTheClub(), randomClub2.getNameOfTheClub(), scoreClub1, scoreClub2, pointsClub1, pointsClub2, now.format(dtf));

            matchList.add(match);

            listOfMatches.add(match);

        }else {
            Match matchUndefined = new Match("No Clubs Added", "No Clubs Added", 0, 0, 0, 0, "--");
            matchList.add(matchUndefined);
        }
    }

}
