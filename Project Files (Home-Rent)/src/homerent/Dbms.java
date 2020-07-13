/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homerent;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */

public class Dbms {
    
    String url="jdbc:mysql://127.0.0.1/homerent";
        String username="root";
        String password="";
   String query (String data,String pdata,String table) throws ClassNotFoundException, SQLException
   {
       // TODO code application logic here
        
        String query1="SELECT * FROM `" + table + "` WHERE username='";
        query1=query1.concat(data);
        query1=query1.concat("'");
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement;
        String name1="*";
       try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
           statement = (Statement) connection.createStatement();
           ResultSet result;
           result=statement.executeQuery(query1);
           result.next();
           name1 = result.getString("password");
            statement.close();
            return name1;
       }
       catch(Exception ex)
       {
           return name1;
       }
       
   }
   
   int usernamequery(String uname) throws ClassNotFoundException, SQLException
   {
       String query2="SELECT * FROM `ownerid` WHERE username='";
        query2=query2.concat(uname);
        query2=query2.concat("'");
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement;
        String name1="";
        try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
            statement= (Statement) connection.createStatement();
            ResultSet result1;
            result1=statement.executeQuery(query2);
            result1.next();
            name1=result1.getString("username");
            
            statement.close();
            connection.close();
            System.out.println("unque please");
            return 10;
        }
        catch(Exception ex)
       {
            System.out.println("Peoceed");
            return -1;
       }
   }
   int registration(String username1,String password1,String name,String nid,String address,String contactno) throws ClassNotFoundException, SQLException
   {
//       int value;
//       value=usernamequery(username);
//       System.out.println(value);
//       if(value==-1){
       String query1="INSERT INTO `ownerid`(`username`, `password`, `Name`, `NID`, `Address`, `Contact No`) VALUES ('"+ username1 +"','"+ password1+"','"+ name+"','"+ nid+"','"+ address +"','"+ contactno +"')";
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement;
        
           try (Connection connection = (Connection) DriverManager.getConnection(url,username,password)) {
               statement=(Statement) connection.createStatement();
               
               statement.execute(query1);
               
               statement.close();
               System.out.print("Success");
               return 1;
           }
           catch(Exception ex)
           {
               System.out.print("Failed");
               return 2;
           }
    }
   
   int uregistration(String username1,String password1,String name,String nid,String address,String contactno) throws ClassNotFoundException, SQLException
   {
       String query1="INSERT INTO `ueserid`(`username`, `password`,`Name`,`NID`,`Address`,`Contact No`) VALUES ('"+username1+"','"+password1+"','"+name+"','"+nid+"','"+address+"','"+contactno+"')";
       Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       
       try(Connection connection= (Connection) DriverManager.getConnection(url,username,password)){
       statement= (Statement) connection.createStatement();
       
       statement.execute(query1);
       
        statement.close();
         System.out.print("Success");
        return 1;
       }
       catch(Exception ex){
            System.out.print("Failed");
           return 2;
       }
      
   }
   void delete(String houseid) throws ClassNotFoundException, SQLException
   {
       String query="DELETE FROM `adtable` WHERE houseid='"+houseid+"'";
       Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       try(Connection connection= (Connection) DriverManager.getConnection(url,username,password)){
       statement= (Statement) connection.createStatement();
       
       statement.execute(query);
       
        statement.close();
       }
       catch(Exception ex)
       {
           
       }
       
   }
   
   void addata(String houseid,String housename,String address,String thana,String district,String houseregno,String housetaxno,String flatsize,String rent,String advance,String floorno,String flattype,String contact) throws ClassNotFoundException, SQLException
   {
       String query="INSERT INTO `adtable`(`houseid`, `housename`, `address`, `thana`, `district`, `houseregno`, `housetaxno`, `flatsize`, `rent`, `advance`, `floorno`, `flattype`, `contact`) VALUES ('"+houseid+"','"+housename+"','"+address+"','"+thana+"','"+district+"','"+houseregno+"','"+housetaxno+"','"+flatsize+"','"+rent+"','"+advance+"','"+floorno+"','"+flattype+"','"+contact+"')";
       Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       
       Connection connection= (Connection) DriverManager.getConnection(url,username,password);
       statement= (Statement) connection.createStatement();
       
       statement.execute(query);
       
       statement.close();
               
       
   }
//   public class data{
//       String 
//   }
//   data disquery(String district)
//   {
//       String query="select district, houseid from adtable group by rent having district='"+district+"'";
//       
//        return null;
//       
//   }
//       else{
//           
//       }
        
   // INSERT INTO `ownerid`(`username`, `password`, `Name`, `NID`, `Address`, `Contact No`) VALUES ('username1','password1','name','nid','address','contactno')
   
}
