/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author DELL
 */
public class DBContext {
    public static Connection JDBCConnection() {
        final String Url = "jdbc:sqlserver://DESKTOP-JADGEKH\\SQLEXPRESS01:1433;databaseName=QuanlyThietBi";
        final String user = "sa";
        final String pass = "39151111";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(Url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }
    public static void main(String[] args){
    Connection connection = JDBCConnection();
       if (connection !=  null){
           System.out.println("thanh cong");
       }
       else 
            System.out.println("that bai");
    }
}
