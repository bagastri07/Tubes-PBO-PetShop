/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author bagas
 */
public class Database {
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo_petshop";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public Database() throws SQLException{
        try{
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            stmt = conn.createStatement();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet getData(String SQLString) throws SQLException {
        rs = stmt.executeQuery(SQLString);
        return rs;
    }
    public void query(String SQLString) throws SQLException {
        stmt.executeUpdate(SQLString);
    }
}
