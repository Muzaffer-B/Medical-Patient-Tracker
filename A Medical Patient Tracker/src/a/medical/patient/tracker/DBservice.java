/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.medical.patient.tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.reflect.generics.tree.ReturnType;

/**
 *
 * @author Muzaffer
 */
public class DBservice {
    
    
    String url = "jdbc:mysql://localhost:3306/medicaltracker?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    String user = "root";
    String password = "malanil35";
    private ResultSet rs;

    private Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            connection = null;
        }
        return connection;
    }
    
 
    public void createAccount(String tcnumber,String name,String surname,String mobilenumber,String birthdate, String password,String weight,String height,String accounttype,String age)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker.accounts (password,name,surname,mobilenumber,birthdate,weight,height,tcnumber,accounttype,age) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, password);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, mobilenumber);
            ps.setString(5, birthdate);
            ps.setString(6, weight);
            ps.setString(7, height);
            ps.setString(8, tcnumber);
            ps.setString(9, accounttype);
            ps.setString(10, age);
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
     public void FillLabTechTable(String name,String mobilenumber,String Name,String Docname,String test)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker."+name+mobilenumber+" (name,doctor,test) values(?,?,?)");
            ps.setString(1, Name);
            ps.setString(2, Docname);
            ps.setString(3, test);
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
      public void FillMedicineTable(String name,String ingredent,String barcode,String stock)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker.medicine (name,ingredent,barcodenumber,stock) values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, ingredent);
            ps.setString(3, barcode);
             ps.setString(4, stock);
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
     
      public void FillDocTable(String name,String mobilenumber,String appointments,String ward,String Docname,String date)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker."+mobilenumber+" (name,appointments,ward,doctor,date) values(?,?,?,?,?)");
            ps.setString(1, name);
             ps.setString(2, appointments);
            ps.setString(3, ward);
            ps.setString(4, Docname);
            ps.setString(5, date);
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
       public void FillNurseTable(String name,String mobilenumber,String Surname,String Nurse)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker."+Nurse+ mobilenumber+" (name,surname,nurse) values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, Surname);
            ps.setString(3, Nurse);
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
     public void FillMedicTable(String mobilenumber,String medication)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker."+mobilenumber+" (medications) values(?)");
            ps.setString(1, medication);
            
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
     
        public void UpdateMedicStock(String name,String Stock)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE  medicaltracker.medicine SET stock='"+Stock+"' where name='"+name+"'");
           
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
      public void FillMedications(String name,String mobilenumber,String medications ,String diagnosis ,String appointments,String Docname,String ward)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE  medicaltracker."+mobilenumber+" SET medications='"+medications+"' ,diagnosis='"+diagnosis+"' where name='"+name+"'");
           
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
      
      
         public void FillTests(String name,String mobilenumber,String tests ,String lab )
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE  medicaltracker."+mobilenumber+" SET requesttests='"+tests+"' ,lab='"+lab+"' where name='"+name+"'");
           
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
      
         
              public void FillLabRequest(String name,String tests ,String doctor,String lab,String techname,String date)
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker.labtechnisian (name,test,doctor,lab,staffname,date) values(?,?,?,?,?,?)");
             ps.setString(1, name);
             ps.setString(2, tests);
             ps.setString(3, "DR. "+doctor);
             ps.setString(4, lab);
             ps.setString(5, techname);
             ps.setString(6, date);
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }  
         
           public void FillSecretary(String name,String doctor ,String medicine,String ward,String sgkcode )
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker.secretary (name,doctor,medicine,ward,sgkcode) values(?,?,?,?,?)");
            ps.setString(1, name);
             ps.setString(2, doctor);
             ps.setString(3, medicine);
             ps.setString(4, ward);
             ps.setString(5, sgkcode);
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }  
      
      
         public void FillTestAndLab(String name,String mobilenumber,String requesttests ,String lab )
    {
        Connection connection = connect();

        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker."+mobilenumber+" (name,requesttests,lab) values(?,?,?)");
            ps.setString(1, name);
             ps.setString(2, requesttests);
             ps.setString(3, lab);
             
           
            
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
      
      
      public String FindWard(String Name,String Mobilenumber){
         String ward = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT ward  FROM medicaltracker."+Mobilenumber+" where name='" + Name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                ward = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return ward;
    }
      
      
        public String FindMedicDoctor(String Name,String Mobilenumber){
         String medications = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT medications  FROM medicaltracker."+Mobilenumber+" where name='" + Name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                medications = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return medications;
    }
      
      
      
      
      
      // id kullanabilirim.
      
       public String FindAppointment(String Name,String Mobilenumber){
         String appointment = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT appointments  FROM medicaltracker."+Mobilenumber+" where name='" + Name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                appointment = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return appointment;
    }
      
       
     
        
       
       
      
     
     
       public String GetPatientName(String tcnumber){
         String patientname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT name  FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                patientname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return patientname;
    }
       
       
          public String GetPatientSurname(String tcnumber){
         String patientname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT surname  FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                patientname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return patientname;
    }
       
       
         public String GetNurseID(String Name){
         String id = null;
         
        
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT id FROM medicaltracker.accounts where name ='"+ Name +"'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String surname = rs.getString(1);
                

               id = surname;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return id;
    }
         
         public String GetNurseIDV2(String Name,String Password){
         String id = null;
         
        
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT id FROM medicaltracker.accounts where name ='"+ Name +"'" + " AND password='" + Password + "'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String surname = rs.getString(1);
                

               id = surname;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return id;
    } 
         
       
       
       
         public String GetNurseNumber(String id){
         String patientname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT mobilenumber  FROM medicaltracker.accounts where id='" + id +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                patientname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return patientname;
    }
       
       
              public String GetPatientNameV2(String Name){
         String surname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT surname  FROM medicaltracker.accounts where name='" + Name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                surname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return surname;
    }
       
              
            
              
        
              
       
       public String GetDoctorSurname(String Name){
         String surname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT surname  FROM medicaltracker.accounts where name='" + Name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                surname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return surname;
    }
       
                  public String getDoctorSurnameV2 ( String name,String number)
    {
        
        String Surname = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT surname FROM medicaltracker.accounts where name ='"+ name +"'" + " AND mobilenumber='" + number + "'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String surname = rs.getString(1);
                

               Surname = surname;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Surname;
    }
       
       
                public String getPatientSurnameV2 ( String tcnumber)
    {
        
        String Surname = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT surname FROM medicaltracker.accounts where tcnumber ='"+ tcnumber +"'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String surname = rs.getString(1);
                

               Surname = surname;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Surname;
    }
       
       
       
       
       
       
       public String GetDoctorNumber(String lastname){
         String patientname = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT mobilenumber  FROM medicaltracker.accounts where surname='" + lastname +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                patientname = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return patientname;
    }
     
     /*  
       public String GetDoctorNumber2(String Number){
         String patientnumber = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT mobilenumber  FROM medicaltracker.accounts where mobilenumber='" + Number +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                patientnumber = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return patientnumber;
    }
       */
    
    
    public void createStaffAccount(String tcnumber,String name,String surname,String mobilenumber,String birthdate, String password,String weight,String height,String accounttype)
    {
        Connection connection = connect();

        try
        {
             PreparedStatement ps = connection.prepareStatement("INSERT INTO medicaltracker.accounts (password,name,surname,mobilenumber,birthdate,weight,height,tcnumber,accounttype) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, password);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, mobilenumber);
            ps.setString(5, birthdate);
            ps.setString(6, weight);
            ps.setString(7, height);
            ps.setString(8, tcnumber);
            ps.setString(9, accounttype);   
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    public void createDoctorTable(String Mobilenumber)
    {
        Connection connection = connect();
        try
        {
            String SQL = "CREATE TABLE IF NOT EXISTS medicaltracker." + Mobilenumber + " ("+ 
                    "id INT NOT NULL AUTO_INCREMENT,"+ 
                    "name VARCHAR(30) ,"+ 
                    "doctor VARCHAR(100) ," + 
                    "medications  VARCHAR(100) ,"+ 
                    "appointments VARCHAR(100) ,"+
                    "date VARCHAR(100) ,"+ 
                    "requesttests  VARCHAR(100) ,"+
                    "diagnosis  VARCHAR(100) ,"+ 
                    "ward  VARCHAR(100) ,"+ 
                    "lab  VARCHAR(100) ,"+ 
                    "PRIMARY KEY (id))";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            int i;
            i = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    
    public void createNurseTable(String Name,String Mobilenumber)
    {
        Connection connection = connect();
        try
        {
            String SQL = "CREATE TABLE IF NOT EXISTS medicaltracker." + Name + Mobilenumber+ " ("+ 
                    "id INT NOT NULL AUTO_INCREMENT,"+ 
                    "name VARCHAR(30) ,"+ 
                    "surname  VARCHAR(100) ,"+  
                    "nurse  VARCHAR(100) ,"+                  
                    "PRIMARY KEY (id))";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            int i;
            i = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
     public void createLabTechTable(String Name,String Mobilenumber)
    {
        Connection connection = connect();
        try
        {
            String SQL = "CREATE TABLE IF NOT EXISTS medicaltracker." + Name + Mobilenumber+ " ("+ 
                    "id INT NOT NULL AUTO_INCREMENT,"+ 
                    "name VARCHAR(30) ,"+ 
                    "surname  VARCHAR(100) ,"+  
                    "doctor  VARCHAR(100) ,"+
                    "test  VARCHAR(100) ,"+ 
                    "PRIMARY KEY (id))";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            int i;
            i = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    
    
    
    
     public void getDoctorAppointments (JTable table,String Mobilenumber,String DocSurname)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker."+Mobilenumber+" where doctor='" + DocSurname + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 int id = rs.getInt(1);
                String name = rs.getString(2);
                String medications  = rs.getString(3);
                String diagnosis = rs.getString(4);
                String appointments = rs.getString(5);
                String requesttests = rs.getString(6);
                String doctor = rs.getString(7);
                String ward = rs.getString(8);

                Object[] content = {id,appointments,doctor,ward};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     public void getNurseMedicDoc (JTable table,String Mobilenumber,String Surname)
    {
        Random rand = new Random(); 
        int medictime = 3+rand.nextInt(7);
        
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,doctor,diagnosis FROM medicaltracker."+Mobilenumber+" where doctor='" + Surname + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String doctor = rs.getString(2);
                String diagnosis = rs.getString(3);

                Object[] content = {name,doctor,diagnosis,medictime};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
     
     
      public void getPharmacistReserveMedicine (JTable table,String barcodenumber)
    {
    
 
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,medicine,sgkcode FROM medicaltracker.secretary where sgkcode='" + barcodenumber + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String medicine = rs.getString(2);
                String sgkcode = rs.getString(3);

                Object[] content = {name,medicine,sgkcode};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    } 
      
        public String  getPharmacistMedicname (String barcodenumber)
    {
    
        String medicine =null;
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT medicine FROM medicaltracker.secretary where sgkcode='" + barcodenumber + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
               
                 medicine = rs.getString(1);
              

                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return medicine;
    } 
      
     
     
    public void getSecretaryMedicDoc (JTable table,String Name)
    {
    
 
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,doctor,medicine FROM medicaltracker.secretary where name='" + Name + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String doctor = rs.getString(2);
                String medicine = rs.getString(3);

                Object[] content = {name,doctor,medicine};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    } 
     public void getLabTestRequest (JTable table)
    {
    
 
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,test,doctor,lab,staffname FROM medicaltracker.labtechnisian")) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String test = rs.getString(2);
                String doctor = rs.getString(3);
                String lab = rs.getString(4);
                String staffname = rs.getString(5);
               

                Object[] content = {name,test,doctor,lab,staffname};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
     
         public void getLabTestRequestV2 (JTable table)
    {
    
 
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,test,doctor,lab,staffname,date FROM medicaltracker.labtechnisian")) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String test = rs.getString(2);
                String doctor = rs.getString(3);
                String lab = rs.getString(4);
               String staffname = rs.getString(5);
               String date = rs.getString(6);
                Object[] content = {date,name,test,doctor,lab,staffname};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    } 
    
    
    public void getSecretaryAppointmentsdoc (JTable table)
    {
    
 
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT doctor,ward FROM medicaltracker.secretary" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                String name = rs.getString(1);
                String ward = rs.getString(2);
               

                Object[] content = {"DR"+name,ward};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }  
    
    
    
     
    
    
    
    public boolean checkAppointmentExist(String mobilenumber,String time){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT appointments FROM medicaltracker."+mobilenumber+" where appointments='"+time+"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
    
    public boolean checkmedicineExist(String name){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT appointments FROM medicaltracker.medicine where name='"+name+"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
    
    
     public boolean checkMedicstExist(String mobilenumber,String Medication){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT medications FROM medicaltracker."+mobilenumber+" where medications='"+Medication+"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
     
     
     
     public void GetMedicine (JTable table,String name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,ingredent,barcodenumber,stock FROM medicaltracker.medicine where name='"+name+"'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                
                 
                 String appointments = rs.getString(1);       
                String ingredent = rs.getString(2);
                String barcodenumber = rs.getString(3);
                String stock = rs.getString(4);
                
                
                
                

                Object[] content = {appointments,ingredent,barcodenumber,stock};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
     
    
    
    public void GetAppointments (JTable table,String Mobilenumber,String Name)
    {
        
      
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT date,appointments,doctor,ward FROM medicaltracker."+Mobilenumber+" where name='" + Name + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 String date = rs.getString(1);
                 
              
                 
                String appointments = rs.getString(2);
            
                String doctor = rs.getString(3);
                String ward = rs.getString(4);
                
                
                
                

                Object[] content = {date,appointments,doctor,ward};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    public void GetAppointmentsv2 (JTable table,String Mobilenumber,String Surname)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker."+Mobilenumber+" where doctor='" + Surname + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 int id = rs.getInt(1);
                 String name =rs.getString(2);
                 String medications  = rs.getString(3);
                  String diagnosis = rs.getString(4);
                String appointments = rs.getString(5);
                String requesttests = rs.getString(6);
                String doctor = rs.getString(7);
                String ward = rs.getString(8);
                
                
                
                

                Object[] content = {name,id,appointments,ward};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    public void GetTestResults (JTable table,String Mobilenumber,String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT requesttests,doctor,ward,lab FROM medicaltracker."+Mobilenumber+" where name='" + Name + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
                 
              String requesttests = rs.getString(1);
                 
                String doctor = rs.getString(2);
            
                String ward = rs.getString(3);
                String lab = rs.getString(4);
                
                
                
                

                Object[] content = {requesttests,doctor,ward,lab};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    public void GetDisplay_medications (JTable table,String Mobilenumber,String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,medications,diagnosis,doctor FROM medicaltracker."+Mobilenumber+" where name='" + Name + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
                 String name =rs.getString(1);
                 String medications  = rs.getString(2);
                 String diagnosis = rs.getString(3);
                 //String appointments = rs.getString(5);
               //  String requesttests = rs.getString(6);
                // String ward = rs.getString(8);
                 String doctor = rs.getString(4);
                
                
                
                

                Object[] content = {name,medications,diagnosis,doctor,"time"};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    
    
    
    
        public boolean Staffuserexist(String ID){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM medicaltracker.accounts where id='" + ID +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
        
        
          public boolean StaffuserexistV2(String name){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM medicaltracker.accounts where accounttype!='0' AND name='" + name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
        
        /*
       public boolean NurseAssignedexist(String name,String number){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM medicaltracker."+name+number+" where nurse='" + name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }  
     */   
        
    
    public boolean userexist(String tcnumber){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
    
    public boolean checkLogin(String tcnumber, String password){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'" + " AND password='" + password + "'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
    
    
    
    public boolean checkStaffLogin(String Name ,String Password){
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + " AND password='" + Password + "'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return false;
    }
    
    
     public String checkDoctorLogin(String Name,String Password){
         String accounttype = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT accounttype  FROM medicaltracker.accounts where name='" + Name +"'"+" AND password='"+Password+"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                accounttype = rs.getString(1);
                System.out.println(""+accounttype);
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return accounttype;
    }
    
     
     
    
    public int getUserId(String tcnumber)
    {
        int userid = 0;

        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT id FROM medicaltracker.accounts where tcnumber='" + tcnumber + "'")) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                userid = rs.getInt(1);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return userid;
    }
    
    
    
              public String GetPatientMedication(String tcnumber){
         String id = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT id  FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                id = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return id;
    }
    
    
    public void getInfo (JTable table,String Tcnumber)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker.accounts where tcnumber='" + Tcnumber + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 int id = rs.getInt(1);
                String tcnumber = rs.getString(2);
                String name  = rs.getString(3);
                String surname = rs.getString(4);
                String mobilenumber = rs.getString(5);
                String weight = rs.getString(7);
                String height = rs.getString(8);

                Object[] content = {id,tcnumber,name,surname,mobilenumber,weight,height};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
           public void getLabtechtInfo ( JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,surname FROM medicaltracker.accounts where accounttype='L57'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
                String surname = rs.getString(2);

               String content = name+" "+surname;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
       public void getAppointmentInfo ( JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT surname FROM medicaltracker.accounts where accounttype='D626'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String surname = rs.getString(1);
                

               String content = surname;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
       
          public void getDoctorNameInfo ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,surname FROM medicaltracker.accounts where accounttype='D626'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
                String surname = rs.getString(2);
                
                   String namesurname = name+" "+surname;
                 Object[] content = {"DR. "+namesurname};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
                
              
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
          
        public void getDoctorDutyRoster ( JTable table)
    {        
        Connection connection = connect();
        ArrayList<String> doctorname = new ArrayList<>();
        
        try (PreparedStatement find = connection.prepareStatement("SELECT name,surname FROM medicaltracker.accounts where accounttype='D626'"  )) 
        {
             int m = 0;
             int n = 0;
             int p = 0;
             int z = 0;
             int t = 0;
            rs = find.executeQuery();
            while(rs.next())
            {                   
                    String name = rs.getString(1);
                   String surname = rs.getString(2);
   
                   String namesurname = name+" "+surname;
                   
                   doctorname.add(namesurname);

            }
                for(int i =0;i<2;i++){
                     Random rnd = new Random();
                   
                    m = rnd.nextInt(doctorname.size());
                    n = rnd.nextInt(doctorname.size());
                    p = rnd.nextInt(doctorname.size());
                    z = rnd.nextInt(doctorname.size());
                    t = rnd.nextInt(doctorname.size());
                    Object[] content = {"DR. "+doctorname.get(m),"DR. "+doctorname.get(n),"DR. "+doctorname.get(p),"DR. "+doctorname.get(z),"DR. "+doctorname.get(t)};
                   DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                    modelTable.addRow(content);
                }
         
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
          
       
            public void getNurseDutyRoster ( JTable table)
    {
        
        Connection connection = connect();
        ArrayList<String> doctorname = new ArrayList<>();
        
        try (PreparedStatement find = connection.prepareStatement("SELECT name,surname FROM medicaltracker.accounts where accounttype='N642'"  )) 
        {
             int m = 0;
             int n = 0;
             int p = 0;
             int z = 0;
             int t = 0;
            rs = find.executeQuery();
            while(rs.next())
            {
                        
                    String name = rs.getString(1);
                   String surname = rs.getString(2);
   
                   String namesurname = name+" "+surname;
                   
                   doctorname.add(namesurname);
                   

            }
                for(int i =0;i<2;i++){
                     Random rnd = new Random();
                   
                    m = rnd.nextInt(doctorname.size());
                    n = rnd.nextInt(doctorname.size());
                    p = rnd.nextInt(doctorname.size());
                    z = rnd.nextInt(doctorname.size());
                    t = rnd.nextInt(doctorname.size());

                        
                        Object[] content = {"DR. "+doctorname.get(m),"DR. "+doctorname.get(n),"DR. "+doctorname.get(p),"DR. "+doctorname.get(z),"DR. "+doctorname.get(t)};
                   DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                    modelTable.addRow(content);
                    
                    
                    
                }
                 
               
               
            
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
        
        

       
       
       
          public void getAllPhonebook ( JTable table,String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype!='0'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Namee = name;
               
               
               Object[] content = {number,Namee};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
          
          
                  public void getSearchPhonebook ( JTable table,String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name,surname FROM medicaltracker.accounts where accounttype!='0' AND  name='"+Name+"'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                String Surname =rs.getString(3);

               String number = surname;
               String  Namee = name;
               
               String NameSurname = name+" "+Surname;
               
               Object[] content = {number,NameSurname};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
          
          
          
            public void getAllPhonebookV2 ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype!='0'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Namee = name;
               
               
               Object[] content = {number,Namee};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }    
          
                 public void getDocPhonebook ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype='D626'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Name = name;
               
               
               Object[] content = {number,Name};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
                 
        public void getNursePhonebook ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype='N642'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Name = name;
               
               
               Object[] content = {number,Name};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
        
            public void getLabTechPhonebook ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype='L57'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Name = name;
               
               
               Object[] content = {number,Name};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
            
             public void getPharmacistPhonebook ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype='P40'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Name = name;
               
               
               Object[] content = {number,Name};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
             
             
                public void getSecretaryPhonebook ( JTable table)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber,name FROM medicaltracker.accounts where accounttype='S52'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
               String surname = rs.getString(1);
                String name =rs.getString(2);
                

               String number = surname;
               String  Name = name;
               
               
               Object[] content = {number,Name};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }       
        
                 
          
          
       
       
           public void getNurseInfo ( JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name FROM medicaltracker.accounts where accounttype='N642'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
                

               String content = name;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
           
           
        public void getDocPatientInfo (JComboBox combobox,String mobilenumber,String Doctor )
    {
        
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name FROM medicaltracker."+mobilenumber+" where doctor='"+Doctor+"'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
                

               String content = name;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
           
           
            public void fillNurseTable ( JTable table,String Name,String number)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name,surname,nurse FROM medicaltracker."+Name+number+" where nurse='"+Name+"'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
                String surname = rs.getString(2);
                String nurse = rs.getString(3);
                

                Object[] content = {name,surname,nurse};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
            
                  public void fillNurseDocBox1 (JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name FROM medicaltracker.accounts where accounttype ='D626'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String name = rs.getString(1);
               

                combobox.addItem(name);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }  
                  
                       public void fillNurseDocBox2 (JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT surname FROM medicaltracker.accounts where accounttype ='D626'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String surname = rs.getString(1);
               

                combobox.addItem(surname);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }              
            
           
       
       
       
           public void getMedicationInfo ( JComboBox combobox,String Mobilenumber,String Surname)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name FROM medicaltracker."+Mobilenumber+" where doctor='" + Surname + "'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String surname = rs.getString(1);
                

               String content = surname;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
           
            public void getMedicine ( JComboBox combobox)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT name FROM medicaltracker.medicine")) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String medicine = rs.getString(1);
                

               String content = medicine;
                
                combobox.addItem(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }    
           
           
           
           
           
            public String GetMedicStock(String name){
         String stock = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT stock  FROM medicaltracker.medicine where name='" + name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                stock = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return stock;
    }
            
            public String AddMedicStock(String name){
         String stock = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT stock  FROM medicaltracker.medicine where name='" + name +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                stock = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return stock;
    }     
            
           
           
           
              public String GetPatientid(String tcnumber){
         String id = null;
         
        Connection connection = connect();

        try
        {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM medicaltracker.accounts where name='" + Name +"'" + "surname='" + Surname + "'"+ " AND password='" + Password + "'";
            String SQL = "SELECT id  FROM medicaltracker.accounts where tcnumber='" + tcnumber +"'";
            rs = statement.executeQuery(SQL);
            if(rs.next())
            {
                id = rs.getString(1);
                
                
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return id;
    }
       
       
           public String getDoctorNumber ( String number)
    {
        
        String Number = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber FROM medicaltracker.accounts where accounttype ='D626'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String mobilenumber = rs.getString(1);
                

               Number = mobilenumber;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Number;
    }
           
           
           
           
      public String getDoctorNumberV2 ( String Name)
    {
        
        String Number = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber FROM medicaltracker.accounts where name='"+Name+"'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 
              
                String mobilenumber = rs.getString(1);
                

               Number = mobilenumber;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Number;
    }
      
      
             public String getDoctorNumberV3 ( String name,String Password)
    {
        
        String Number = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber FROM medicaltracker.accounts where name ='"+ name +"'" + " AND password='" + Password + "'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String mobilenumber = rs.getString(1);
                

               Number = mobilenumber;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Number;
    }
      
             
     public String getDoctorNumberV4 ( String name,String Surname)
    {
        
        String Number = null;
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT mobilenumber FROM medicaltracker.accounts where name ='"+ name +"'" + " AND surname='" + Surname + "'"  )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
              
              
                String mobilenumber = rs.getString(1);
                

               Number = mobilenumber;
                
               
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return Number;
    }
             
    
    
        public boolean search (String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker.accounts where name='" + Name + "'" )) 
        {
            
            
            
            rs = find.executeQuery();
            
            
            if(rs.next())
            {
                return true;
            }
            /*
            String nname = rs.getString("name");
            
           if(nname.equals(Name)){
               
               
               System.out.println("match");
               JOptionPane.showMessageDialog(null, "User Found", "Found", JOptionPane.INFORMATION_MESSAGE);
               
           }
           else JOptionPane.showMessageDialog(null, "User not  Found", "Found", JOptionPane.ERROR_MESSAGE);
            
            
            while(rs.next())
            {
                 int id = rs.getInt(1);
                String tcnumber = rs.getString(2);
                String name  = rs.getString(3);
                String surname = rs.getString(4);
                String mobilenumber = rs.getString(5);
                String weight = rs.getString(7);
                String height = rs.getString(8);

                Object[] content = {id,tcnumber,name,surname,mobilenumber,weight,height};
               
                
                
            }*/
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return false;
        
    }
        
        
            public boolean searchv2 (String Name)
    {
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker.accounts where name='" + Name + "AND where accounttype=''0'" )) 
        {
            
            
            
            rs = find.executeQuery();
            
            
            if(rs.next())
            {
                return true;
            }
           
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        
        return false;
        
    }
        
    
         public void getdocPatientinfo (JTable table,String Name)
    {
        
        
        
        
        Connection connection = connect();
        try (PreparedStatement find = connection.prepareStatement("SELECT * FROM medicaltracker.accounts where name='" + Name + "'" )) 
        {
            rs = find.executeQuery();
            while(rs.next())
            {
                 int id = rs.getInt(1);
                String tcnumber = rs.getString(2);
                String name  = rs.getString(3);
                String surname = rs.getString(4);
                String mobilenumber = rs.getString(5);
                String weight = rs.getString(7);
                String height = rs.getString(8);
                 String age = rs.getString(11);

                Object[] content = {id,tcnumber,name,surname,mobilenumber,weight,height,age};
                DefaultTableModel modelTable = (DefaultTableModel) table.getModel(); 
                modelTable.addRow(content);
            }
        }
        catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
    }
    
    
    public void staffLogin(){
        
        
        
        
    }
    
}
