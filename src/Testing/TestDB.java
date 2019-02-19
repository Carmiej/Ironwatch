package Testing;

import models.IronwatchDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This will test the database connection and pulling data from the database.
 * @author The Razorback
 */
public class TestDB {
    
    public static void main(String[] args)
    {
        IronwatchDB dbtest = new IronwatchDB();
        
        Connection conn=null;
        String url="jdbc:derby:Ironwatch;create=true";  //url of the DB host
        String username="ironwatch";  //your DB username
        String password="ironwatch";   //your DB password
        
        //Connection to the database itsself
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Good Result");
        } catch (SQLException ex) {
            System.out.println("bad Result");
        }
        
        //Tests the retrievel of data from the database.
        String[] results;
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet res = statement.executeQuery("Select count(player_name) from Graveyard");
            res.next();
            int j = res.getInt("1");
            results = new String[j];
            ResultSet rs = statement.executeQuery("Select * from Graveyard");
            System.out.println("Good Result");
        } catch (SQLException ex) {
            Logger.getLogger(IronwatchDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Bad Result");
        }
        
        
    }
    
}
