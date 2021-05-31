/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.medical.patient.tracker;



public class patient_login {
    
    String patientNumber;
    String TcNumber;
    String Name;
    String Surname;
    String Mobilenumber;
    String Birthdate;
    String Weight;
    String height;
    String Password;

    
    

    public patient_login(String patientNumber, String TcNumber, String Name, String Surname, String Mobilenumber, String Birthdate, String Weight, String height, String Password) {
        this.patientNumber = patientNumber;
        this.TcNumber = TcNumber;
        this.Name = Name;
        this.Surname = Surname;
        this.Mobilenumber = Mobilenumber;
        this.Birthdate = Birthdate;
        this.Weight = Weight;
        this.height = height;
        this.Password = Password;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getTcNumber() {
        return TcNumber;
    }

    public void setTcNumber(String TcNumber) {
        this.TcNumber = TcNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

   

    public String getMobilenumber() {
        return Mobilenumber;
    }

    public void setMobilenumber(String Mobilenumber) {
        this.Mobilenumber = Mobilenumber;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   

    @Override
    public String toString() {
        return "patient_login{" + "patientNumber=" + patientNumber + ", TcNumber=" + TcNumber + ", Name=" + Name + ", Surname=" + Surname +  ", Mobilenumber=" + Mobilenumber + ", Birthdate=" + Birthdate + ", Weight=" + Weight + ", height=" + height + ", Password=" + Password + '}';
    }
    
   

    
    
    
    
    
    
}
