
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class hotelPackageModel extends Database{
private Statement statement;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private String query;
private final ArrayList<hotelPackageModel> data=new ArrayList();
private int id;
private String room;
private String meal;
private String amenities;
private String date;

    public hotelPackageModel() {
    }

    public hotelPackageModel( int id, String room, String meal, String amenities, String date) {

        this.id = id;
        this.room = room;
        this.meal = meal;
        this.amenities = amenities;
        this.date = date;
    }



public void add(String room,String meal,String amenities){
 id=new Random().nextInt();
 date=new Date().toLocaleString();
 startConnection();
    try {
        query="insert into package values ('"+id+"','"+room+"','"+meal+"','"+amenities+"','"+date+"')";
        statement=getConnection().createStatement();
        statement.execute(query);
    } catch (SQLException ex) {
    }
 closeConnection();
}

public ArrayList<hotelPackageModel> selectAll(){
       this.startConnection();
        try {
            query = "select * from package";
            preparedStatement = getConnection().prepareStatement(this.query);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {                
                this.id = resultSet.getInt("id");
                this.room = resultSet.getString("room");
                this.meal = resultSet.getString("meal");
                this.amenities = resultSet.getString("amenities");
                this.date = resultSet.getString("date");
                data.add(new hotelPackageModel(this.id,this.room,this.meal,this.amenities,this.date));
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

    public String getRoom() {
        return room;
    }

    public String getMeal() {
        return meal;
    }

    public String getAmenities() {
        return amenities;
    }

    public String getDate() {
        return date;
    }
    public void clearData(){
        this.data.clear();
    }
}
