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
import java.util.Objects;

public class SportsClub implements Serializable {

    private String nameOfTheClub;
    private String location;
    private String regNo;

    public SportsClub (String nameOfTheClub, String location, String regNo){
        this.nameOfTheClub = nameOfTheClub;
        this.location = location;
        this.regNo = regNo;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
                Objects.equals(location, that.location) &&
                Objects.equals(regNo, that.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheClub, location);
    }

}
