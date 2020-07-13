/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homerent;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class HomeRent {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
       
        Scanner obj= new Scanner(System.in);
        Scanner obj2=new Scanner(System.in);

        Dbms dobj=new Dbms();

        WelcomePage objx=new WelcomePage();
        objx.setVisible(true);
        

    }
    
}
