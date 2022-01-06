/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {
    static String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1434;databaseName=BkapStore";
    //jdbc:sqlserver://localhost\\MSSQLSERVER02
    static String use = "duong";
    static String pass = "duong1234$";
    public static Connection getConnet() throws ClassNotFoundException, SQLException{
        //load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(url, use, pass);
        return con;
    }
}
//thử đi