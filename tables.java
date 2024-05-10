/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author SAI
 */
public class tables {
    public static void main(String args[]){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            //st = con.createStatement();
            //st.executeUpdate("CREATE TABLE User(appuser_pk INTEGER primary key AUTOINCREMENT, userRole varchar(50), name varchar(100), mobileNumber varchar(50), email varchar(200), password varchar(50), address varchar(200), status varchar(50)");
            //st.executeUpdate("INSERT INTO User VALUES (1,'SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', '123', 'India', 'Active')");
            //st.executeUpdate("CREATE TABLE category (category_pk INTEGER  primary key AUTOINCREMENT, name varchar(200))");
            //st.executeUpdate("CREATE TABLE products (product_pk INTEGER primary key AUTOINCREMENT, name varchar(200), quantity int, price int, description varchar(200), category_fk int)");
            //st.executeUpdate("CREATE TABLE customer (customer_pk INTEGER primary key AUTOINCREMENT, name varchar(200), mobileNumber varchar(50), email varchar(200))");
            st.executeUpdate("CREATE TABLE orderDetail (order_pk INTEGER primary key AUTOINCREMENT, orderid varchar(200), customer_fk int, orderdate varchar(200), totalpaid int)");
            JOptionPane.showMessageDialog(null,"Table created successfully");
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                con.close();
                st.close();
            }
            catch(Exception e){}
        }
    }
}
