/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package models;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {

    void createClub(SportsClub fbClub);

    void deleteClub(SportsClub fbClub);

    void displayStat(SportsClub fbClub);

    void displayPLTable();

    void addMatch(FootballClub fbClub1, FootballClub fbClub2);

    boolean validateClub(FootballClub club);

    void saveData() throws IOException;

    void loadData() throws IOException, ClassNotFoundException;

    void addRandomMatch(List<Match> matchList) throws IOException;
}


