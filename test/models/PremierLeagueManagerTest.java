package models;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {

    @Test
    void getInstance() {
        PremierLeagueManager premierLeagueManager1 =  PremierLeagueManager.getInstance();
        PremierLeagueManager premierLeagueManager2 =  PremierLeagueManager.getInstance();
        assertEquals(premierLeagueManager1,premierLeagueManager2);
    }

    @Test
    void createClub() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        SportsClub fbClub = new FootballClub("A", "B", "#1", 0, 0, 0, 0 ,0 , 0, 0);
        plm.createClub(fbClub);
    }

    @Test
    void deleteClub() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        SportsClub fbClub = new FootballClub("A", "B", "#1", 0, 0, 0, 0 ,0 , 0, 0);
        plm.deleteClub(fbClub);
    }

    @Test
    void displayStat() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        SportsClub fbClub = new FootballClub("A", "B", "#1", 0, 0, 0, 0 ,0 , 0, 0);
        plm.displayStat(fbClub);
    }

    @Test
    void displayPLTable() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        SportsClub fbClub = new FootballClub("A", "B", "#1", 0, 0, 0, 0 ,0 , 0, 0);
        plm.createClub(fbClub);
        plm.displayPLTable();
    }

    @Test
    void addMatch() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        FootballClub fbClub1 = new FootballClub("A1", "B1", "01", 0, 0, 0, 0 ,0 , 0, 0);
        FootballClub fbClub2 = new FootballClub("A2", "B2", "02", 0, 0, 0, 0 ,0 , 0, 0);
        plm.createClub(fbClub1);
        plm.createClub(fbClub2);
        plm.addMatch(fbClub1,fbClub2);
    }

    @Test
    void validateClub() {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        FootballClub fbClub = new FootballClub("A3", "B3", "03", 0, 0, 0, 0 ,0 , 0, 0);
        plm.createClub(fbClub);
        plm.validateClub(fbClub);
    }

    @Test
    void saveData() throws IOException {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        plm.saveData();
        File file = new File("saveDataClubs.txt");
        assertTrue(file.isFile());
    }

    @Test
    void loadData() throws IOException {
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        plm.loadData();
    }

    @Test
    void addRandomMatch() {
        List<Match> randomMatch = new ArrayList<>();
        PremierLeagueManager plm = PremierLeagueManager.getInstance();
        FootballClub fbClub1 = new FootballClub("A4", "B4", "04", 0, 0, 0, 0 ,0 , 0, 0);
        FootballClub fbClub2 = new FootballClub("A4", "B4", "05", 0, 0, 0, 0 ,0 , 0, 0);
        plm.createClub(fbClub1);
        plm.createClub(fbClub2);
        plm.addRandomMatch(randomMatch);
    }

}
