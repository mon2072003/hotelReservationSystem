
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class roomModel extends Database{
private Statement statement;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private String query;
private final ArrayList<roomModel> data=new ArrayList();
private int id;
private String roomType;
private String date;

    public roomModel() {
    }

    public roomModel(int id, String roomType, String date) {
        this.id = id;
        this.roomType = roomType;
        this.date = date;
    }

    
public void add(String room){
 id=new Random().nextInt();
 date=new Date().toLocaleString();
 startConnection();
    try {
        query="insert into room values ('"+id+"','"+room+"','"+date+"')";
        statement=getConnection().createStatement();
        statement.execute(query);
    } catch (SQLException ex) {
    }
 closeConnection();
}

public ArrayList<roomModel> selectAll(){
       this.startConnection();
        try {
            query = "select * from room";
            preparedStatement = getConnection().prepareStatement(this.query);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {                
                this.id = resultSet.getInt("id");
                this.roomType = resultSet.getString("room");
                this.date = resultSet.getString("date");
                data.add(new roomModel(this.id,this.roomType,this.date));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
       this.closeConnection();
       return data;
}

    public int getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getDate() {
        return date;
    }
    public void clearData(){
        this.data.clear();
    }
}
