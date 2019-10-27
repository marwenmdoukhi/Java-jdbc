/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjdbc.jfx.soir;

/**
 *
 * @author marwen
 */
import java.sql.*;
import java.util.Scanner;

public class ProjetJDBCJFXSoir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/pisoir?useSSL=false", "root", "");
        System.out.println(connx);        // TODO code application logic here
        /*if (conn!=null){
         System.out.println("ok");
     }
     else {
         System.out.println("erreur");
     }*/
        
        
        //pour l'affichage
        //Statement stmt = connx.createStatement();
        // insercation 
        //int x = stmt.executeUpdate("insert into ucertifs(libelle,prix)values('IELTS','400')");
        //mise a jour 
        /* int x = stmt.executeUpdate("update ucertifs set libelle='ocp' where id='7'" );
     
       System.out.println(x);
        ResultSet rs = stmt.executeQuery("select * from ucertifs");
        while (rs.next()) {
            System.out.println(rs.getString("libelle"));
            System.out.println(rs.getDouble("prix"));
        }
         */
        Statement stmt = connx.createStatement();
        Scanner lecture = new Scanner(System.in);

        System.out.println("Donner le libelle de la certif : ");

        String libelle = lecture.nextLine();

        System.out.println("Donner le prix de la certif : ");

        double prix = Double.parseDouble(lecture.nextLine());
        int x = stmt.executeUpdate("insert into ucertifs (libelle, prix) values ('" + libelle + "','" + prix + "')");

        ResultSet rs = stmt.executeQuery("select * from ucertifs");
        while (rs.next()) {
            System.out.println(rs.getString("libelle"));
            System.out.println(rs.getDouble("prix"));
            

        }

    }

}
