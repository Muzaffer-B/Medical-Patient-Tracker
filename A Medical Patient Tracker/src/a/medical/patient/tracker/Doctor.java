/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.medical.patient.tracker;

import java.util.ArrayList;

/**
 *
 * @author Muzaffer
 */
public class Doctor {
    
    
    
    
    String StaffID;
    String Name;
    String Lastname;
    String MobileNumber;
    String Gender;
    String Birthdate;
    String password;
    
    
    ArrayList<Doctor> doctor = new ArrayList<>();

   

    public Doctor(String StaffID, String Name, String Lastname, String MobileNumber, String Gender, String Birthdate, String password) {
        this.StaffID = StaffID;
        this.Name = Name;
        this.Lastname = Lastname;
        this.MobileNumber = MobileNumber;
        this.Gender = Gender;
        this.Birthdate = Birthdate;
        this.password = password;
    }
    
    
    
    
     public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
