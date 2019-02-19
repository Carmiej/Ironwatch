package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blake
 */
public class IronwatchDB {
    
    Connection conn=null;
    String url="jdbc:derby:Ironwatch;create=true";  //url of the DB host
    String username="ironwatch";  //your DB username
    String password="ironwatch";   //your DB password
   
    //this function connects to the databse.
    public void connectDB()
    {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
    
    //This function updates the databse with the players name and there kill count
    public void updateTable(String playerName, int killCount) throws SQLException
    {
        Statement statement = conn.createStatement();
        String update = "insert into Graveyard(player_name, player_kills) values('"+playerName+"', "+killCount+")";
        statement.executeUpdate(update);
    }
    
    //this function creates the table in the databse if it does not allready exist.
    public void createTable()
    {
        try {
            Statement statement = conn.createStatement();
            String CreateTable = "create table Graveyard (player_name varchar(20), player_kills int)";
            statement.executeUpdate(CreateTable);
        } catch (SQLException ex) {
            Logger.getLogger(IronwatchDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Table allready Exists");
        }
    }
    
    //This function returns a string array of all of the data from the databse.
    public String[] getTable()
    {
        String[] results;
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet res = statement.executeQuery("Select count(player_name) from Graveyard");
            res.next();
            int j = res.getInt("1");
            results = new String[j];
            ResultSet rs = statement.executeQuery("Select * from Graveyard");
            int i = 0;
            while(rs.next())
            {
               results[i] = ("Name: "+rs.getString("player_name")+"  Kills: "+rs.getInt("player_kills"));
               ++i;
            }
           return results;
        } catch (SQLException ex) {
            Logger.getLogger(IronwatchDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            results = new String[1];
        }
        
       return results;
    }
        
}
