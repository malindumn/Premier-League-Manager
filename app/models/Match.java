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
import java.time.LocalDateTime;

public class Match implements Serializable,Comparable<Match> {

    private String fbClub1Name;
    private String fbClub2Name;
    private int score1;
    private int score2;
    private int points1;
    private int points2;
    private String date;

    public Match(String fbClub1Name, String fbClub2Name, int score1, int score2, int points1, int points2, String date) {
        this.fbClub1Name = fbClub1Name;
        this.fbClub2Name = fbClub2Name;
        this.score1 = score1;
        this.score2 = score2;
        this.points1 = points1;
        this.points2 = points2;
        this.date = date;
    }

    public String getFbClub1Name() {
        return fbClub1Name;
    }

    public void setFbClub1Name(String fbClub1Name) {
        this.fbClub1Name = fbClub1Name;
    }

    public String getFbClub2Name() {
        return fbClub2Name;
    }

    public void setFbClub2Name(String fbClub2Name) {
        this.fbClub2Name = fbClub2Name;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getPoints1() { return points1;}

    public void setPoints1(int points1) {
        this.points1 = points1;
    }

    public int getPoints2() {
        return points2;
    }

    public void setPoints2(int points2) {
        this.points2 = points2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Match o) {
        if(this.getDate().compareTo(o.getDate()) > 0){
            return 1;
        }else if (this.getDate().compareTo(o.getDate()) < 0){
            return -1;
        }else
            return 0;
    }
}
