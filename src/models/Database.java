
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abanoub
 */
public class Database {


  private Connection c;
public void startConnection(){
    try {
          c=  DriverManager.getConnection("jdbc:sqlite:hotel.db");

    } catch (SQLException e) {
    }

}

public Connection getConnection(){
    return c;
}

public void closeConnection(){
    try {
        c.close();
    } catch (SQLException e) {
    }
}

}
