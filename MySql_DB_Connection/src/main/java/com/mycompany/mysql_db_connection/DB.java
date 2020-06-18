/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mysql_db_connection;

import java.sql.*;

/**
 *
 * @author ramya
 */
public class DB {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    
   public DB(){
       
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DemoInfo","root","");
            st = con.createStatement();
        }
    catch(Exception ex){
            System.out.println("Error : "+ex);
        }
       
   }

   public void getData(){
       try{
           String query = "select * from Info";
           rs = st.executeQuery(query);
           System.out.println("Records from Info");
           while(rs.next()){
               String Name = rs.getString("Name");
               String Age = rs.getString("Age");
               String Phno = rs.getString("Phno");
               System.out.println("Name: "+Name+" "+"Age: "+Age+" "+"Phno: "+Phno);
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
   }
}