/*

I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the section
on Assessment Offences in the Essential Information for Students.The work that I have submitted is entirely my own.
Any work from other authors is duly referenced and acknowledged."

Full Name: Malindu Mewan Nanayakkara
UoW Number: W1761214
IIT Student ID: 2019192

*/

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import utils.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController extends Controller {

    public Result listClubs() throws IOException {

        PremierLeagueManager premierLeagueManager = PremierLeagueManager.getInstance();

        premierLeagueManager.loadData();

        List<FootballClub> listOfClubs = premierLeagueManager.getListOfClubsAdded();

        List<FootballClub> noClubsFound = new ArrayList<>();

        if(listOfClubs.isEmpty()){
            FootballClub clubUndefined = new FootballClub("No Clubs Added", "No Clubs Added", "No Clubs Added", 0,0,0,0,0,0,0);
            noClubsFound.add(clubUndefined);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(noClubsFound, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(listOfClubs, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }
    }

    public Result listMatches() throws IOException {

        PremierLeagueManager premierLeagueManager = PremierLeagueManager.getInstance();

        premierLeagueManager.loadData();

        List<Match> listOfMatches = premierLeagueManager.getListOfMatches();

        List<Match> noMatchesFound = new ArrayList<>();

        if(listOfMatches.isEmpty()){
            Match matchUndefined = new Match("No Matches","No Matches",0,0,0,0,"--");
            noMatchesFound.add(matchUndefined);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(noMatchesFound, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(listOfMatches, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }
    }

    public Result addRandomMatch() throws IOException {

        PremierLeagueManager premierLeagueManager = PremierLeagueManager.getInstance();

        premierLeagueManager.loadData();

        List<Match> randomMatch = new ArrayList<>();

        premierLeagueManager.addRandomMatch(randomMatch);

        premierLeagueManager.saveData();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(randomMatch, JsonNode.class);
        return ok(Util.createResponse(jsonData, true));
    }

    public Result searchMatch(String date) throws IOException {

        boolean exist =  false;

        List<Match> foundMatches = new ArrayList<>();

        PremierLeagueManager premierLeagueManager = PremierLeagueManager.getInstance();

        premierLeagueManager.loadData();

        List<Match> listOfMatches = premierLeagueManager.getListOfMatches();

        List<Match> noMatchesFound = new ArrayList<>();

        for (Match match : listOfMatches){
            if (match.getDate().equals(date)){
                foundMatches.add(match);
                exist = true;
            }
        }

        if (!exist){
            Match matchUndefined = new Match("No Matches","No Matches",0,0,0,0,"--");
            noMatchesFound.add(matchUndefined);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(noMatchesFound, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(foundMatches, JsonNode.class);
            premierLeagueManager.saveData();
            return ok(Util.createResponse(jsonData, true));
        }
    }

}
