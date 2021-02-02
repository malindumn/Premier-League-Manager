/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package models.professionalDevelopmentLeague;

import models.FootballClub;

public class UniversityFootballClub extends FootballClub {

    private String universityName;

    public UniversityFootballClub(String nameOfTheClub, String location, String regNo, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int numOfMatchesPlayed, String universityName) {
        super(nameOfTheClub, location, regNo, wins, draws, defeats, goalsReceived, goalsScored, points, numOfMatchesPlayed);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
