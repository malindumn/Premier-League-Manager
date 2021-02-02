/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package models;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {

    private int wins;
    private int draws;
    private int defeats;
    private int goalsReceived;
    private int goalsScored;
    private int points;
    private int numOfMatchesPlayed;

    public FootballClub(String nameOfTheClub, String location, String regNo, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int numOfMatchesPlayed) {
        super(nameOfTheClub, location, regNo);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.points = points;
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) { this.goalsScored = goalsScored; }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumOfMatchesPlayed() {
        return numOfMatchesPlayed;
    }

    public void setNumOfMatchesPlayed(int numOfMatchesPlayed) {
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    @Override
    public int compareTo(FootballClub o) {
        if (this.points == o.points) {
            if ((this.goalsScored - this.goalsReceived) < (o.goalsScored - o.goalsReceived))
                return 1;
            else if ((this.goalsScored - this.goalsReceived) > (o.goalsScored - o.goalsReceived))
                return -1;
            else
                return 0;
        } else if (this.points < o.points)
            return 1;
        else
            return -1;
    }

}
