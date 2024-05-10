/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
/**
 *
 * @author SAI
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try{
           Class.forName("org.sqlite.JDBC");
           Connection con = DriverManager.getConnection("jdbc:sqlite:F:\\SQLite\\stock.db");
           return con;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
